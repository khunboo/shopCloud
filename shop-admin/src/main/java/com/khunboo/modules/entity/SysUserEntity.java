package com.khunboo.modules.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "sys_user")
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER)
    public String id;

    /**
     * 用户名
     */
    public String username;

    /**
     * 密码
     */
    public String password;

    /**
     * 用户状态
     */
    public int status;

    /**
     * 创建人
     */
    public String creater;


    /**
     * 创建时间
     */
    public String createDate;

    /**
     * 更新人
     */
    public String updater;

    /**
     * 更新时间
     */
    public String updateDate;

    /**
     * 加密盐
     */
    public String salt;
}
