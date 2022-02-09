package com.lushwe.learn.server;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO 写点注释吧
 *
 * @author liusw
 * @version V1.0
 * @since 2/8/22 11:24 AM
 */
@Component
@ServerEndpoint("/{fromName}/{toName}")
public class WebSocketServer {

    private static AtomicInteger onlineCount = new AtomicInteger(0);

    private static ConcurrentHashMap<String, WebSocketServer> webSocketServerMAP = new ConcurrentHashMap<>();
    private Session session;
    private String fromName;
    private String toName;
    private String uri;


    @OnOpen
    public void onOpen(Session session, @PathParam("fromName") String fromName, @PathParam("toName") String toName) throws IOException {
        this.session = session;
        this.fromName = fromName;
        this.toName = toName;
        this.uri = session.getRequestURI().toString();

        WebSocketServer webSocketServer = webSocketServerMAP.get(uri);

        if (webSocketServer != null) {
            //同样业务的连接已经在线，则把原来的挤下线。
            webSocketServer.session.getBasicRemote().sendText(uri + "重复连接被挤下线了");
            //关闭连接，触发关闭连接方法onClose()
            webSocketServer.session.close();
        }
        //保存uri对应的连接服务
        webSocketServerMAP.put(uri, this);
        // 在线数加1
        addOnlineCount();

        sendMessage(webSocketServerMAP + "当前在线连接数:" + getOnlineCount());

        System.out.println(this + "有新连接加入！当前在线连接数：" + getOnlineCount());
    }


    /**
     * 连接关闭时触发，注意不能向客户端发送消息了
     *
     * @throws IOException
     */
    @OnClose
    public void onClose() throws IOException {
        //删除uri对应的连接服务
        webSocketServerMAP.remove(uri);
        // 在线数减1
        reduceOnlineCount();

        System.out.println("有一连接关闭！当前在线连接数" + getOnlineCount());
    }

    /**
     * 收到客户端消息后触发,分别向2个客户端（消息发送者和消息接收者）推送消息
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        //服务器向消息发送者客户端发送消息
        this.session.getBasicRemote().sendText("发送给" + toName + "的消息:" + message);
        //获取消息接收者的客户端连接
        StringBuilder receiverUri = new StringBuilder("ws://localhost:8888/");
        receiverUri.append(toName)
                .append("/")
                .append(fromName);
        WebSocketServer webSocketServer = webSocketServerMAP.get(receiverUri.toString());
        if (webSocketServer != null) {
            webSocketServer.session.getBasicRemote().sendText("来自" + fromName + "的消息:" + message);
        }
        /*// 群发消息
        Collection<WebSocketServer> collection = webSocketServerMAP.values();
        for (WebSocketServer item : collection) {
            try {
                item.sendMessage("收到群发消息:" + message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }*/
    }

    /**
     * 通信发生错误时触发
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 向客户端发送消息
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 获取在线连接数
     *
     * @return
     */
    public static int getOnlineCount() {
        return onlineCount.get();
    }

    /**
     * 原子性操作，在线连接数加一
     */
    public static void addOnlineCount() {
        onlineCount.getAndIncrement();
    }

    /**
     * 原子性操作，在线连接数减一
     */
    public static void reduceOnlineCount() {
        onlineCount.getAndDecrement();
    }
}
