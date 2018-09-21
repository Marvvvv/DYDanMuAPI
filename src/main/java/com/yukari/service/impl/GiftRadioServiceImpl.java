package com.yukari.service.impl;

import com.yukari.cache.GlobalCache;
import com.yukari.mapper.GiftInfoMapper;
import com.yukari.mapper.GiftRadioMapper;
import com.yukari.mapper.NobleOpenOrRenewMapper;
import com.yukari.model.GiftInfo;
import com.yukari.model.GiftRadio;
import com.yukari.model.NobleOpenOrRenew;
import com.yukari.model.RadioMQModel;
import com.yukari.service.GiftRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GiftRadioServiceImpl implements GiftRadioService {

    @Autowired
    GiftRadioMapper giftRadioMapper;

    @Autowired
    NobleOpenOrRenewMapper nobleOpenOrRenewMapper;

    @Autowired
    GiftInfoMapper giftInfoMapper;


    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<RadioMQModel> getNotOverGift() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND,-178);
        String boxEndTime = sdf.format(calendar.getTime());
        List<GiftRadio> notOvergift = giftRadioMapper.getGiftRadiosByTime(boxEndTime);
        List<NobleOpenOrRenew> notOverNoble = nobleOpenOrRenewMapper.getGiftRadiosByTime(boxEndTime);
        List<RadioMQModel> radioMqs = new ArrayList<>();
        // 礼物广播
        if (notOvergift != null && !notOvergift.isEmpty()) {
            for (GiftRadio radio : notOvergift) {
                RadioMQModel model = new RadioMQModel();
                model.setRadioType(1);
                model.setDate(sdf.format(radio.getDate()));
                model.setAchorName(radio.getAnchor_name());
                model.setGift_name(radio.getGift_name());
                model.setRoomId(radio.getRoom_id());
                model.setGiveName(radio.getGiver());
                model.setGift_src(getGiftSrcByGiftId(radio.getGift_id()));
                int remainTime = (int)(radio.getDate().getTime() - calendar.getTime().getTime())/1000;
                model.setRemainTime(remainTime);
                if (remainTime >= 5) {
                    radioMqs.add(model);
                }
            }
        }

        // 贵族广播
        if (notOverNoble != null && !notOverNoble.isEmpty()) {
            for (NobleOpenOrRenew noble:notOverNoble) {
                RadioMQModel model = new RadioMQModel();
                model.setRadioType(2);
                model.setDate(sdf.format(noble.getDate()));
                model.setAchorName(noble.getAnchor_name());
                model.setGift_name(noble.getNoble_name());
                model.setRoomId(noble.getRoom_id());
                model.setGiveName(noble.getUname());
                model.setGift_src(rtnNobleSrc(noble.getNoble_name()));
                int remainTime = (int)(noble.getDate().getTime() - calendar.getTime().getTime())/1000;
                model.setRemainTime(remainTime);
                if (remainTime >= 5) {
                    radioMqs.add(model);
                }
            }
        }
        return radioMqs;
    }



    private String rtnNobleSrc (String nobleName) {
        switch (nobleName) {
            case "游侠":
                return "https://res.douyucdn.cn/resource/2017/09/16/common/6b12f00d675b1bf85f03c67c9c5f1b24.png";
            case "骑士":
                return "https://res.douyucdn.cn/resource/2017/09/16/common/2804bf974a63ddf64f77942a56392a32.png";
            case "子爵":
                return "https://res.douyucdn.cn/resource/2017/09/16/common/06db8debe9fa16787586998b2498701a.png";
            case "伯爵":
                return "https://res.douyucdn.cn/resource/2017/09/16/common/17392efa63400c410947c5a69ff1cc35.gif";
            case "公爵":
                return "https://res.douyucdn.cn/resource/2017/09/16/common/534e34cbcfab5f62744e7ee89d946410.gif";
            case "国王":
                return "https://res.douyucdn.cn/resource/2017/09/16/common/0f0cecdc2a8b42727f59d0f07a571712.gif";
            case "皇帝":
                return "https://res.douyucdn.cn/resource/2017/09/16/common/59853156e3274457ac3bc9f837c287c7.gif";
            default:
                return "";
        }
    }


    private String getGiftSrcByGiftId (int giftId){
        Map<Integer,GiftInfo> giftInfoMap = GlobalCache.getGlobalCache().getGiftInfoCache();
        if (giftInfoMap != null && !giftInfoMap.isEmpty()) {
            // 从缓存中拿礼物url
            if (giftInfoMap.containsKey(giftId)) {
                return giftInfoMap.get(giftId).getGift_gif_url();
            }
            return "";
        } else {
            // 从数据库中拿
            Map<Integer,GiftInfo> map = new HashMap<>();
            List<GiftInfo> giftInfos = giftInfoMapper.getAllGift();
            for (GiftInfo info : giftInfos) {
                map.put(info.getGift_id(),info);
            }
            GlobalCache.getGlobalCache().setGiftInfoCache(map);
            if (map.containsKey(giftId)) {
                return map.get(giftId).getGift_gif_url();
            }
            return "";
        }
    }


}
