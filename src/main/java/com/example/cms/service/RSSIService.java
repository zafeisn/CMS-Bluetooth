package com.example.cms.service;

import com.example.cms.entity.RSSI;
import com.example.cms.mapper.RSSIMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title：RSSIService
 * @Package：com.example.cms.service
 * @Description：
 * @author：done
 * @date：2021/9/26 16:19
 */
@Service
public class RSSIService {

    @Autowired
    private RSSIMapper rssiMapper;

    public List<RSSI> findAll(){
        return rssiMapper.findAll();
    }
}
