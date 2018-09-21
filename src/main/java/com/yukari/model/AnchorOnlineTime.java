package com.yukari.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AnchorOnlineTime implements Serializable {

    private Integer id;
    private Integer room_id;
    private Date onlineTime;
    private Date offlineTime;
    private String online_length;
    private Integer online_status;

}

