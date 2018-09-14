package com.yukari.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ShutUpHistory {
    private Integer id;

    private Integer room_id;

    private Integer executer_type;

    private Integer executer_id;

    private String executer_name;

    private Integer shutUp_id;

    private String shutUp_name;

    private String end_time;

    private String ban_time;

    private String date;

}