package com.example.sharding.mapper;

import com.example.sharding.model.Shop;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Description: 不分片的默认表：执行默认数据源
 * @Author tianwl
 * @Company 安徽中科美络信息技术有限公司
 * @Email tianwl@izkml.com
 * @Date 2022/6/6 15:31
 */
@Slf4j
@SpringBootTest
public class ShopMapperTests {

    @Resource
    ShopMapper shopMapper;

    /**
     * 写走主库
     */
    @Test
    public void testInsert(){
        for (int i = 0; i < 2; i++) {
            Shop shop = new Shop();
            shop.setShopId(Long.valueOf(i));
            shop.setShopName("西安文理的小店_" + i);
            shop.setShopType("abbbdd_" + i);
            shopMapper.insert(shop);
        }
    }

    /**
     * 读走从库
     */
    @Test
    public void testQuery(){
        log.info(shopMapper.selectById(1).toString());
    }
}
