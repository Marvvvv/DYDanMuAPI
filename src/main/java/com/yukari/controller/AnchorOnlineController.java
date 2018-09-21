package com.yukari.controller;

import com.yukari.model.BaseEntity;
import com.yukari.service.AnchorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/achorInfo")
public class AnchorOnlineController {

    @Autowired
    AnchorInfoService anchorInfoService;

    @GetMapping("/baseInfo")
    public BaseEntity getAchorInfo () {
        return anchorInfoService.getAnchorInfo();
    }




}
