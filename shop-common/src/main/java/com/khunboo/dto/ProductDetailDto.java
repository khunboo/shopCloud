package com.khunboo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class ProductDetailDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 销售种类
     */
    @NotEmpty(message = "销售种类不能为空")
    private int saleType;

    /**
     * 销售品牌
     */
    @NotEmpty(message = "销售品牌不能为空")
    private String saleBrand;

    /**
     * 销售产品
     */
    @NotEmpty(message = "销售产品不能为空")
    private String saleProduct;

    /**
     * 产品简介
     */
    private String content;

    /**
     * 产品价格
     */
    @NotEmpty(message = "产品价格不能为空")
    private String salePrice;

    /**
     * 产品数量
     */
    @NotEmpty(message = "产品数量不能为空")
    private int productCnt;

    /**
     * 产品图片路径
     */
    @NotEmpty(message = "图片路径")
    private String coverPath;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新者
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private String updateTime;
}
