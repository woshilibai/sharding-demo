package com.example.sharding.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.example.sharding.model.Dict;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Description: 广播表：所有数据源中均存在的表
 * @Author tianwl
 * @Company 安徽中科美络信息技术有限公司
 * @Email tianwl@izkml.com
 * @Date 2022/6/6 15:18
 */
@Slf4j
@SpringBootTest
public class DictMapperTests {
    @Resource
    DictMapper dictMapper;

    /**
     * 广播表:插入到所有数据源
     */
    @Test
    public void testInsert(){
        Dict dict = new Dict();
        dict.setDictCode("abc");
        dict.setDictValue("商品种类");
        dictMapper.insert(dict);
    }

    /**
     * 广播表：查询时负载均衡查询各数据源
     */
    @Test
    public void testQuery(){
        Dict dict = new Dict();
        dict.setDictCode("abc");
        dict.setDictValue("商品种类");
        log.info(dictMapper.queryList(dict).toString());
    }
}
