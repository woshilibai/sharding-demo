package com.example.sharding.model;

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
@TableName("t_shop")
public class Shop {
    @TableId
    private Long shopId;
    private String shopName;
    private String shopType;
}
