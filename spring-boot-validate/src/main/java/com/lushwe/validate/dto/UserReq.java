package com.lushwe.validate.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 说明：TODO 写点注释吧
 *
 * @author Jack Liu
 * @date 2019-07-19 11:03
 * @since 0.1
 */
@Data
public class UserReq {

    @NotNull(message = "不能为空")
    @Min(value = 1)
    private Long userId;

}
