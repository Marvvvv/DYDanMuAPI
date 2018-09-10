package com.yukari.dydanmuapi.controller;

import com.yukari.dydanmuapi.model.BaseEntity;
import com.yukari.dydanmuapi.model.BulletHistory;
import com.yukari.dydanmuapi.service.BulletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bullet")
public class BulletController {


    @Autowired
    BulletService bulletService;


    @GetMapping("/queryBullet")
    public BaseEntity queryBullet (int pkid) {
        return new BaseEntity(0,bulletService.queryBulletByPK(pkid));
    }


    @GetMapping("/pagehelperTest")
    public BaseEntity pageHelper (int page,int pageSize) {
        return new BaseEntity(0,bulletService.findAllBullet(page,pageSize));
    }




}
