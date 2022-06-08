package com.example.sharding.mapper;

import cn.hutool.json.JSONUtil;
import com.example.sharding.model.ProductBase;
import com.example.sharding.model.ProductDetail;
import com.example.sharding.model.Shop;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Description: 绑定表：分片键和分片算法相同的表，避免在join查询时出现笛卡尔积查询，影响性能
 * @Author tianwl
 * @Company 安徽中科美络信息技术有限公司
 * @Email tianwl@izkml.com
 * @Date 2022/6/6 15:31
 */
@Slf4j
@SpringBootTest
public class ProductMapperTests {

    @Resource
    ProductBaseMapper productBaseMapper;

    @Resource
    ProductDetailMapper productDetailMapper;

//    @Transactional    //  测试类执行完毕后事务会自动回滚，不方便测试
    @Test
    public void testInsert(){
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
    }

    /**
     * sql中只有分表分片键示例
     * 1、sql解析发现没有分库分片键，会路由到所有分片库执行，具体进一步路由到哪个分片表，根据分表分片键的值确定
     * 2、t_product_base和t_product_detail为绑定表，避免笛卡尔积查询
     */
    @Test
    public void testQuery(){
        List<Long> ids = new ArrayList<>();
        ids.add(740642733047152640L);
        ids.add(740642733047152641L);
        List<Map<String, String>> list = productBaseMapper.queryListByIds(ids);
        log.info("============={}",JSONUtil.toJsonStr(list));
    }

    /**
     * sql中有分库分片键和分表分片键示例
     */
    @Test
    public void testQuery2(){
        List<Long> ids = new ArrayList<>();
        ids.add(740642733047152640L);
        ids.add(740642733047152641L);
        List<Map<String, String>> list = productBaseMapper.queryListByIdsAndShop(ids, Long.valueOf(new Random().nextInt(2)));
        log.info("============={}",JSONUtil.toJsonStr(list));
    }

    /**
     * 报错：Inline strategy cannot support this type sharding:RangeRouteValue(columnName=shop_id, tableName=t_product_base, valueRange=(1‥+∞))
     * 行表达式分片策略，只支持对SQL语句中的 = 和 in 的分片操作，且是单分片键
     * 其他分片策略：
     *  标准分片策略：单分片键， PreciseShardingAlgorithm 处理 = 和 IN ， RangeShardingAlgorithm 处理 BETWEEN AND， >， <，>=，<=
     *  复合分片策略：复合分片键，支持对 SQL语句中的 =，>， <， >=， <=，IN和 BETWEEN AND 的分片操作
     *  行表达式分片策略：单分片键，支持对 SQL语句中的 = 和 IN 的分片操作
     *  Hint分片策略：强制指定分片路由，指定分片健而非从 SQL中提取分片健的方式进行分片的策略
     */
    @Test
    public void testQuery3(){
        Long id = 740642733047152640L;
        List<Map<String, String>> list = productBaseMapper.queryListByRange(id, 1L);
        log.info("============={}",JSONUtil.toJsonStr(list));
    }

    /**
     * 统计总数示例
     */
    @Test
    public void testQuery4(){
        int count = productBaseMapper.queryCount();
        log.info("============={}",count);
    }

    /**
     * 分组统计总数示例
     */
    @Test
    public void testQuery5(){
        List<Map<String, String>> list = productBaseMapper.queryGroupCount();
        log.info("============={}",JSONUtil.toJsonStr(list));
    }

}
