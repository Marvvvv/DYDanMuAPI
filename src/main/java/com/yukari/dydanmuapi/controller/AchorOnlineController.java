package com.yukari.dydanmuapi.controller;

import com.yukari.dydanmuapi.model.BaseEntity;
import com.yukari.dydanmuapi.service.AchorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/achorInfo")
public class AchorOnlineController {

    @Autowired
    AchorInfoService achorInfoService;

    @GetMapping("/baseInfo")
    public BaseEntity getAchorInfo () {
        return achorInfoService.getAchorInfo();
    }




}
