package com.yukari.dydanmuapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class GiftRadio {
    private Integer id;

    private Integer room_id;

    private String giver;

    private String anchor_name;

    private Integer gift_id;

    private String gift_name;

    private Integer amount;

    private Integer gift_style;

    private Date date;

}