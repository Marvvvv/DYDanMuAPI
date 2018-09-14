package com.yukari.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yukari.mapper.BulletHistoryMapper;
import com.yukari.model.BulletHistory;
import com.yukari.service.BulletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BulletServiceImpl implements BulletService {

    @Autowired
    BulletHistoryMapper bulletHistoryMapper;

    private static Logger logger = LoggerFactory.getLogger(BulletServiceImpl.class);

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<BulletHistory> findAllBullet (int pageNum) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, 20);
        List<BulletHistory> bullets = bulletHistoryMapper.getAllBulletHistory();
        PageInfo result = new PageInfo(bullets);
        return result;
    }


    @Override
    public List<Map<String,Object>> bulletCountRank (String timeRange) {
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
        return bulletHistoryMapper.queryBulletRankByRange(startTime,endTime);
    }

}
