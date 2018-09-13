package com.yukari.dydanmuapi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yukari.dydanmuapi.model.BaseEntity;
import com.yukari.dydanmuapi.model.BulletHistory;
import com.yukari.dydanmuapi.service.ShutUpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shutup")
public class ShutUpController {

    @Autowired
    ShutUpService shutUpService;

    @GetMapping("/byRange")
    public BaseEntity getShutUpByRange (String timeRange,int page) {
        if (StringUtils.isBlank(timeRange)) {
            return new BaseEntity(1,"参数不能为空!");
        }
        try {
            return new BaseEntity(0,shutUpService.findByRange(timeRange,page,5));
        } catch (Exception e) {
            return new BaseEntity(1,"数据库连接丢失!");
        }
    }



}
