package com.example.cms.entity;

import lombok.Data;

/**
 * @Title：RSSI
 * @Package：com.example.cms.entity
 * @Description：蓝牙信号强度收集数据表
 * @author：done
 * @date：2021/9/26 16:05
 */
@Data
public class RSSI {
    private Integer id;
    private String X;
    private String Y;
    private String Z;
    private String N1;
    private String N2;
    private String N3;
    private String N4;
    private String N5;
    private String N6;
    private String N7;
    private String N8;
    private String W1;
    private String W2;
    private String W3;
    private String W4;
    private String W5;
    private String W6;
    private String W7;
    private String W8;
    private String W9;
    private String W0;
    private String F1;
    private String F2;
    private String electricity;  // 电池电量
    private String startTime;  // 开始扫描时间
    private String phoneMac;
    private String phoneBrand;
    private String phoneAndroid;
    private String scanDuration;  // 扫描时长
    private String scanInterval;  // 广播间隔
    private String txPower;  // 发射功率
}
