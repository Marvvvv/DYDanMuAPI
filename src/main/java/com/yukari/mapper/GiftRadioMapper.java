package com.yukari.mapper;

import com.yukari.model.GiftRadio;

import java.util.List;

public interface GiftRadioMapper {

    List<GiftRadio> getGiftRadiosByTime (String boxEndTime);

}