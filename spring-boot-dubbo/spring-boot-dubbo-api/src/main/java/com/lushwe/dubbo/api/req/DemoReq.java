package com.lushwe.dubbo.api.req;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 说明：DemoReq
 *
 * @author Jack Liu
 * @date 2021-09-10 23:12
 * @since 0.1
 */
@Getter
@Setter
public class DemoReq implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * id
     */
    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id必须大于0")
    @Max(value = 100, message = "id不能大于100")
    private Long id;

    /**
     * name
     */
    @NotBlank(message = "name不能为空")
    private String name;

    /**
     * ids
     */
    @Size.List({
            @Size(min = 1, message = "ids不能少于1个"),
            @Size(max = 3, message = "ids不能超过3个")
    })
    private List<Long> ids;

}
