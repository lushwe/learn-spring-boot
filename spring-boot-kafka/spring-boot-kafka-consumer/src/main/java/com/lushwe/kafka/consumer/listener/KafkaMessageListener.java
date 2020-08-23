package com.lushwe.kafka.consumer.listener;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 说明：Kafka消息监听
 *
 * @author Jack Liu
 * @date 2019-07-29 15:30
 * @since 0.1
 */
@Component
public class KafkaMessageListener {


    @KafkaListener(topics = {"test_2020"})
    public void test(ConsumerRecord<String, String> consumerRecord) {

        System.out.println("消费：" + JSON.toJSONString(consumerRecord.value(), true));

    }
}
