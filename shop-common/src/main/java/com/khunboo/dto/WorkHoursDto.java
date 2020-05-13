package com.khunboo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class WorkHoursDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    /**
     * 单位名称
     */
    @NotBlank(message = "单位名称不能为空")
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
    @NotBlank(message = "上课时间不能为空")
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
