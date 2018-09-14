package com.yukari.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yukari.mapper.ShutUpHistoryMapper;
import com.yukari.model.ShutUpHistory;
import com.yukari.service.ShutUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ShutUpServiceImpl implements ShutUpService {

    @Autowired
    ShutUpHistoryMapper shutUpHistoryMapper;


    @Override
    public PageInfo<ShutUpHistory> findByRange(String timeRange, int page, int pageSize) {
        String startTime = "";
        String endTime = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if ("today".equals(timeRange)) {
            // 今天
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1; // 月份从0开始计数的
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            startTime = year + "-" + month + "-" + day + " 00:00:00";
            endTime = year + "-" + month + "-" + day + " 23:59:59";
        } else if ("yesterday".equals(timeRange)) {
            // 昨天
            calendar.add(Calendar.DATE, -1);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1; // 月份从0开始计数的
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            startTime = year + "-" + month + "-" + day + " 00:00:00";
            endTime = year + "-" + month + "-" + day + " 23:59:59";
        } else if ("currMonth".equals(timeRange)) {
            // 本月
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1; // 月份从0开始计数的
            startTime = year + "-" + month + "-" + "01 00:00:00";
            endTime = year + "-" + month + "-" + "31 00:00:00";
        }

        PageHelper.startPage(page, pageSize);
        List<ShutUpHistory> shutUpHistoryList = shutUpHistoryMapper.getByTimeRange(startTime,endTime);
        PageInfo result = new PageInfo(shutUpHistoryList);
        return result;
    }
}
