package com.example.sharding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: todo
 * @Author tianwl
 * @Company 安徽中科美络信息技术有限公司
 * @Email tianwl@izkml.com
 * @Date 2022/6/6 13:48
 */
@Data
@TableName("t_product_detail")
public class ProductDetail {
    @TableId(type = IdType.AUTO)    //  主键由sharding自动生成
    private Long id;
    private Long prodId;
    private Long shopId;
    private String prodDetailInfo;
}
