package com.yukari.controller;

import com.yukari.model.BaseEntity;
import com.yukari.service.GiftRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/giftRadio")
public class GiftRadioController {


    @Autowired
    GiftRadioService giftRadioService;


    /**
     * 获取未过宝箱时间的礼物信息
     */
    @GetMapping("/getNotOverYetGiftInfo")
    public BaseEntity getNotOverYetGiftInfo () {
        try {
            return new BaseEntity(0,giftRadioService.getNotOverGift());
        } catch (Exception e) {
            return new BaseEntity(1,"数据库连接失败!");
        }
    }



}
