package com.example.sharding;

import com.example.sharding.mapper.ShopMapper;
import com.example.sharding.model.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Description: 测试mybatisplus
 * @Author tianwl
 * @Company 安徽中科美络信息技术有限公司
 * @Email tianwl@izkml.com
 * @Date 2022/6/6 14:04
 */
@SpringBootTest
public class MybatisPlusTests {

    @Resource
    ShopMapper shopMapper;

    @Test
    public void test1(){
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("西安文理的小店");
        shop.setShopType("abbbdd");
        shopMapper.insert(shop);
    }

    @Test
    public void test2(){
        System.out.println(shopMapper.selectById(1));
    }
}
