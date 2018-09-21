package com.yukari.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GiftInfo implements Serializable {

    private Integer id;
    private Integer gift_id;
    private String gift_name;
    private Integer gift_devote;
    private Integer gift_exp;
    private String gift_pic_url;
    private String gift_gif_url;

    @Override
    public int hashCode() {
        return gift_id.hashCode();
    }
}
