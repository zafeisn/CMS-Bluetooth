package com.example.cms.mapper;

import com.example.cms.entity.RSSI;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Title：RSSIMapper
 * @Package：com.example.cms.mapper
 * @Description：
 * @author：done
 * @date：2021/9/26 16:17
 */
@Mapper
public interface RSSIMapper {

    @Select("select * from t_rssi")
    List<RSSI> findAll();

}
