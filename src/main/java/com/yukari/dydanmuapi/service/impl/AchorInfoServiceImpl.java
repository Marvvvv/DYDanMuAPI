package com.yukari.dydanmuapi.service.impl;

import com.yukari.dydanmuapi.mapper.AchorOnlineMapper;
import com.yukari.dydanmuapi.model.AchorOnline;
import com.yukari.dydanmuapi.model.BaseEntity;
import com.yukari.dydanmuapi.service.AchorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AchorInfoServiceImpl implements AchorInfoService {

    @Autowired
    AchorOnlineMapper achorOnlineMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public BaseEntity getAchorInfo() {
        // 获取最后一次直播状态 @TODO  数据库表结构重构
        AchorOnline ao = achorOnlineMapper.getLastInfo();
        Map<String,Object> map = new HashMap<>();
        map.put("onlineStatus",ao.getOnline_status());

        // 获取当前月份
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int month =calendar.get(Calendar.MONTH)+1;


        if (ao.getOnline_status() == 1) {
            // 开播
            map.put("openDate",sdf.format(ao.getDate()));

            // 统计本月开播时长

        } else if (ao.getOnline_status() == 0) {
            // 关播
            map.put("closeDate",sdf.format(ao.getDate()));
            // 获取上次开播时间
            // 计算上次开播时长
            // 统计本月开播时长

        }
        return new BaseEntity(0,map);
    }
}
