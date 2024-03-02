package com.example.cms.controller;

import com.example.cms.entity.Admin;
import com.example.cms.entity.RSSI;
import com.example.cms.service.AdminService;
import com.example.cms.service.RSSIService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Title：TablesController
 * @Package：com.example.cms.controller
 * @Description：记录数据表 - 管理员表、蓝牙数据采集信息表
 * @author：done
 * @date：2021/9/25 19:46
 */
@Controller
public class TablesController {

    @Autowired
    AdminService adminService;

    @Autowired
    RSSIService rssiService;

    /**
     * 用户表
     * @param session
     * @return
     */
    @RequestMapping("/user")
    public String tables(HttpSession session){
        List<Admin> adminAll = adminService.findAll();
        session.setAttribute("adminAll",adminAll);
        return "user";
    }

    /**
     * RSSI表
     * @param session
     * @return
     */
    @RequestMapping("/rssi")
    public String data(HttpSession session){
        List<RSSI> rssiAll = rssiService.findAll();
        session.setAttribute("rssiAll",rssiAll);
        return "rssi";
    }

    // 导出表
    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        String[] cellList = {
                "id","X","Y","Z","N1","N2","N3","N4","N5","N6","N7","N8","W1","W2","W3","W4",
                "W5","W6","W7","W8","W9","W0","F1","F2","Electricity","Start_Time", "Phone_MAC",
                "Phone_Brand","Phone_Android","Scan_Duration","Scan_Interval","Tx_Power"
        };

        // 1、创建webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 2、在webbook中添加一个sheet
        HSSFSheet sheet = wb.createSheet();
        // 3、在sheet中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        // 4、创建单元格，设置值表头
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(cellList[0]);
        cell.setCellStyle(cellStyle);

        for(int i=1; i<cellList.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(cellList[i]);
            cell.setCellStyle(cellStyle);
        }

        // 5、写入
        List<RSSI> rssiList = rssiService.findAll();
        for(int j=0; j<rssiList.size(); j++) {
            row = sheet.createRow(j+1);
            RSSI rssi = rssiList.get(j);
//            System.out.println("测试：" + startBleCustom.getEight() + " " + startBleCustom.getScanTime());

            // 创建单元格，并设置值
            row.createCell(0).setCellValue(rssi.getId());
            row.createCell(1).setCellValue(rssi.getX());
            row.createCell(2).setCellValue(rssi.getY());
            row.createCell(3).setCellValue(rssi.getZ());
            row.createCell(4).setCellValue(rssi.getN1());
            row.createCell(5).setCellValue(rssi.getN2());
            row.createCell(6).setCellValue(rssi.getN3());
            row.createCell(7).setCellValue(rssi.getN4());
            row.createCell(8).setCellValue(rssi.getN5());
            row.createCell(9).setCellValue(rssi.getN6());
            row.createCell(10).setCellValue(rssi.getN7());
            row.createCell(11).setCellValue(rssi.getN8());
            row.createCell(12).setCellValue(rssi.getW1());
            row.createCell(13).setCellValue(rssi.getW2());
            row.createCell(14).setCellValue(rssi.getW3());
            row.createCell(15).setCellValue(rssi.getW4());
            row.createCell(16).setCellValue(rssi.getW5());
            row.createCell(17).setCellValue(rssi.getW6());
            row.createCell(18).setCellValue(rssi.getW7());
            row.createCell(19).setCellValue(rssi.getW8());
            row.createCell(20).setCellValue(rssi.getW9());
            row.createCell(21).setCellValue(rssi.getW0());
            row.createCell(22).setCellValue(rssi.getF1());
            row.createCell(23).setCellValue(rssi.getF2());
            row.createCell(24).setCellValue(rssi.getElectricity());
            row.createCell(25).setCellValue(rssi.getStartTime());
            row.createCell(26).setCellValue(rssi.getPhoneMac());
            row.createCell(27).setCellValue(rssi.getPhoneBrand());
            row.createCell(28).setCellValue(rssi.getPhoneAndroid());
            row.createCell(29).setCellValue(rssi.getScanDuration());
            row.createCell(30).setCellValue(rssi.getScanInterval());
            row.createCell(31).setCellValue(rssi.getTxPower());
        }
        // 6、下载
        OutputStream out = response.getOutputStream();
        String fileName = "蓝牙信息.xls";
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
        wb.write(out);
    }

}
