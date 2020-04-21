package com.khunboo.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "work_hours")
public class WorkHoursEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER)
    private int id;

    /**
     * 单位名称
     */
    private String unitname;

    /**
     * 课时数量
     */
    private int workCount;

    /**
     * 学生数量
     */
    private int memberCount;

    /**
     * 上课时间
     */
    private String workTime;

    /**
     * 劳动报酬
     */
    private String workMoney;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建人
     */
    private String createUser;
}
