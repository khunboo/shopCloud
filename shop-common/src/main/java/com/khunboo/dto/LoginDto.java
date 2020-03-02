package com.khunboo.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
public class LoginDto implements Serializable {

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

    /**
     * 状态
     */
    private int status;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新者
     */
    private String updater;

    /**
     * 更新时间
     */
    private String updateTime;


}
