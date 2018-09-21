package com.yukari.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yukari.mapper.AnchorOnlineTimeMapper;
import com.yukari.model.AnchorOnlineTime;
import com.yukari.model.BaseEntity;
import com.yukari.service.AnchorInfoService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AchorInfoServiceImpl implements AnchorInfoService {

    @Autowired
    AnchorOnlineTimeMapper anchorOnlineTimeMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public BaseEntity getAnchorInfo() {
        Map<String,Object> map = new HashMap<>();

        // 获取房间信息
        Connection conn = Jsoup.connect("http://open.douyucdn.cn/api/RoomApi/room/196").timeout(60 * 1000).userAgent("Mozilla").ignoreContentType(true);
        try {
            Document doc = conn.get();
            JSONObject jsonObject = JSON.parseObject(doc.text());
            String roomTitle = jsonObject.getJSONObject("data").getString("room_name");
            String anchorName = jsonObject.getJSONObject("data").getString("owner_name");
            String anchorImgUrl = jsonObject.getJSONObject("data").getString("avatar");
            map.put("roomTitle",roomTitle);
            map.put("anchorName",anchorName);
            map.put("anchorImgUrl",anchorImgUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取最后一次直播信息
        AnchorOnlineTime act = anchorOnlineTimeMapper.getLast();

        if (act.getOnline_status() == 1) {
            // 开播

            // 获取开播时间
            map.put("onlineTime",sdf.format(act.getOnlineTime()));
        } else if (act.getOnline_status() == 0) {
            // 关播

            // 获取上次开关播时间
            map.put("onlineTime",sdf.format(act.getOnlineTime()));
            map.put("offlineTime",sdf.format(act.getOfflineTime()));
            // 获取上次时长
            map.put("onlineLength",act.getOnline_length());
        }

        map.put("onlineStatus",act.getOnline_status());
        // 获取当前年月
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month =calendar.get(Calendar.MONTH)+1;

        // 统计本月时长
        String startTime = year + "-" + month + "-" +"01 00:00:00";
        String endTime = year + "-" + month + "-" +"31 23:59:59";
        List<String> onlineTimeLengths = anchorOnlineTimeMapper.getOneMonthAllTimeLength(startTime, endTime);
        Long totalTimeLength = 0L;
        for (String timeLength : onlineTimeLengths) {
            Pattern pa = Pattern.compile("[0-9]\\d*");
            Matcher ma = pa.matcher(timeLength);
            List<Long> t = new ArrayList<>();
            while (ma.find()) {
                t.add(Long.parseLong(ma.group()));
            }
            if (!t.isEmpty()) {
                totalTimeLength += (t.get(0) * (1000 * 60 * 60)) + (t.get(1) * (1000 * 60));
            }
        }
        map.put("totalTimeLength",formatDuring(totalTimeLength));

        return new BaseEntity(0,map);
    }


    // 毫秒转换为XX小时XX分钟
    private String formatDuring (long mss){
        long hours = mss / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        return hours + "小时" + minutes +"分钟";
    }


}
