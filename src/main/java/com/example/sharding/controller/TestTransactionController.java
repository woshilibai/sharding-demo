package com.example.sharding.controller;

import com.example.sharding.mapper.DictMapper;
import com.example.sharding.mapper.ProductBaseMapper;
import com.example.sharding.mapper.ProductDetailMapper;
import com.example.sharding.model.Dict;
import com.example.sharding.model.ProductBase;
import com.example.sharding.model.ProductDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @Description: todo
 * @Author tianwl
 * @Company 安徽中科美络信息技术有限公司
 * @Email tianwl@izkml.com
 * @Date 2022/6/8 10:47
 */
@RestController
@Slf4j
@RequestMapping("/trans")
public class TestTransactionController {

    @Resource
    DictMapper dictMapper;

    @Resource
    ProductBaseMapper productBaseMapper;

    @Resource
    ProductDetailMapper productDetailMapper;

    /**
     * 测试广播表的事务支持
     * 结论：通过
     * @param code
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/dict/{code}")
    public String dictTest(@PathVariable("code") String code){
        Dict dict = new Dict();
        dict.setDictCode(code);
        dict.setDictValue("xxxx");
        dictMapper.insert(dict);
        //  模拟业务异常
        int i=10/0;
        return "ok";
    }

    /**
     * 测试分片表的事务支持
     * 结论：通过
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/prod")
    public String prodTest(){
        for (int i = 0; i < 10; i++) {
            Long shopId = Long.valueOf(new Random().nextInt(10));
            ProductBase productBase = new ProductBase();
//            productBase.setProdId("1");   //  sharding自动生成分布式唯一主键
            productBase.setShopId(shopId);
            productBase.setProdName("iPhone" + i);
            productBase.setProdType("telephone");
            productBaseMapper.insert(productBase);
            log.info("productBase============={}",productBase.toString());

            ProductDetail productDetail = new ProductDetail();
            productDetail.setProdId(productBase.getProdId());
            productDetail.setShopId(shopId);
            productDetail.setProdDetailInfo("很牛逼的智能手机");
            productDetailMapper.insert(productDetail);
        }
        //  模拟业务异常
        int i=10/0;
        return "ok";
    }

}
