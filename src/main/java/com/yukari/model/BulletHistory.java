package com.yukari.model;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BulletHistory {
    private Integer id;

    private Integer room_id;

    private Integer uid;

    private String uname;

    private Integer ulevel;

    private String headIcon_url;

    private String fans_card_name;

    private Integer fans_card_level;

    private Integer fans_card_room_id;

    private String content;

    private String date;

}