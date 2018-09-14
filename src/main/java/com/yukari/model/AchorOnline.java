package com.yukari.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AchorOnline {

    private Integer id;
    private Integer roomId;
    private Integer online_status;
    private Date date;

}
