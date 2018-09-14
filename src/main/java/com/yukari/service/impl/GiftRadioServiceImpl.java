package com.yukari.service.impl;

import com.yukari.mapper.GiftRadioMapper;
import com.yukari.mapper.NobleOpenOrRenewMapper;
import com.yukari.model.GiftRadio;
import com.yukari.model.NobleOpenOrRenew;
import com.yukari.model.RadioMQModel;
import com.yukari.service.GiftRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GiftRadioServiceImpl implements GiftRadioService {

    @Autowired
    GiftRadioMapper giftRadioMapper;

    @Autowired
    NobleOpenOrRenewMapper nobleOpenOrRenewMapper;


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
        if (notOvergift != null && !notOvergift.isEmpty()) {
            for (GiftRadio radio : notOvergift) {
                RadioMQModel model = new RadioMQModel();
                model.setRadioType(1);
                model.setDate(sdf.format(radio.getDate()));
                model.setAchorName(radio.getAnchor_name());
                model.setGift_name(radio.getGift_name());
                model.setRoomId(radio.getRoom_id());
                model.setGiveName(radio.getGiver());
                int remainTime = (int)(radio.getDate().getTime() - calendar.getTime().getTime())/1000;
                model.setRemainTime(remainTime);
                if (remainTime >= 5) {
                    radioMqs.add(model);
                }
            }
        }

        if (notOverNoble != null && !notOverNoble.isEmpty()) {
            for (NobleOpenOrRenew noble:notOverNoble) {
                RadioMQModel model = new RadioMQModel();
                model.setRadioType(2);
                model.setDate(sdf.format(noble.getDate()));
                model.setAchorName(noble.getAnchor_name());
                model.setGift_name(noble.getNoble_name());
                model.setRoomId(noble.getRoom_id());
                model.setGiveName(noble.getUname());
                int remainTime = (int)(noble.getDate().getTime() - calendar.getTime().getTime())/1000;
                model.setRemainTime(remainTime);
                if (remainTime >= 5) {
                    radioMqs.add(model);
                }
            }
        }
        return radioMqs;
    }
}
