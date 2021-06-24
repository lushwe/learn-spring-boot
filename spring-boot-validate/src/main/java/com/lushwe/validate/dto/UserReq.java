package com.lushwe.validate.dto;

import com.lushwe.validate.group.Insert;
import com.lushwe.validate.group.Update;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

    @NotNull(groups = {Update.class}, message = "ID不能为空")
    @Min(groups = {Update.class}, value = 1)
    private Long id;

    @NotBlank(groups = {Insert.class, Update.class}, message = "用户名不能为空")
    private String userName;

    @NotBlank(groups = {Insert.class, Update.class}, message = "用户地址不能为空")
    private String userAddress;

}
