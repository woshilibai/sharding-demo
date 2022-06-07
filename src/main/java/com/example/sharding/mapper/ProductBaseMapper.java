package com.example.sharding.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sharding.model.ProductBase;
import com.example.sharding.model.Shop;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Description: todo
 * @Author tianwl
 * @Company 安徽中科美络信息技术有限公司
 * @Email tianwl@izkml.com
 * @Date 2022/6/6 13:58
 */
public interface ProductBaseMapper extends BaseMapper<ProductBase> {

    //  sql中只有分表分片键示例
    @Select("<script> select * from t_product_base t left join t_product_detail s on t.prod_id=s.prod_id where t.prod_id in " +
            "<foreach collection='ids' open='(' separator=',' close=')' item='id'> #{id} </foreach>" +
            " </script>")
    List<Map<String, String>> queryListByIds(@Param("ids") List<Long> ids);

    //  sql中有分库分片键和分表分片键示例
    @Select("<script> select * from t_product_base t left join t_product_detail s on t.prod_id=s.prod_id where t.shop_id=#{shopId} and t.prod_id in " +
            "<foreach collection='ids' open='(' separator=',' close=')' item='id'> #{id} </foreach>" +
            " </script>")
    List<Map<String, String>> queryListByIdsAndShop(@Param("ids") List<Long> ids, @Param("shopId") Long shopId);

    //  范围查询，行表达式分片策略不支持
    @Select("select * from t_product_base where shop_id>#{shopId} and prod_id>#{id}")
    List<Map<String, String>> queryListByRange(@Param("id") Long id, @Param("shopId") Long shopId);

    //  统计总数
    @Select("select count(1) from t_product_base")
    int queryCount();

    //  分组统计总数
    @Select("select t.shop_id, count(1) total from t_product_base t left join t_product_detail s on t.prod_id=s.prod_id group by t.shop_id order by t.prod_id desc")
    List<Map<String, String>> queryGroupCount();
}
