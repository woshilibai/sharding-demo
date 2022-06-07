package com.example.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sharding.model.Dict;
import com.example.sharding.model.Shop;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: todo
 * @Author tianwl
 * @Company 安徽中科美络信息技术有限公司
 * @Email tianwl@izkml.com
 * @Date 2022/6/6 13:58
 */
public interface DictMapper extends BaseMapper<Dict> {

    @Select("select * from t_dict where dict_code=#{dict.dictCode} and dict_value=#{dict.dictValue}")
    List<Dict> queryList(@Param("dict") Dict dict);
}
