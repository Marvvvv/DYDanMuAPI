package com.yukari.controller;

import com.yukari.model.BaseEntity;
import com.yukari.service.BulletService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bullet")
public class BulletController {

    @Autowired
    BulletService bulletService;

    @GetMapping("/pagehelperTest")
    public BaseEntity pageHelper (int page, int pageSize) {
        return new BaseEntity(0,bulletService.findAllBullet(page));
    }



    @GetMapping("/countRank")
    public BaseEntity bulletCountRank (String timeRange) {
        if (StringUtils.isBlank(timeRange)) {
            return new BaseEntity(1,"参数不能为空!");
        }
        try {
            List<Map<String,Object>> rankInfo = bulletService.bulletCountRank(timeRange);
            return new BaseEntity(0,rankInfo);
        } catch (Exception e) {
            return new BaseEntity(1,"数据库连接丢失!");
        }
    }









}
