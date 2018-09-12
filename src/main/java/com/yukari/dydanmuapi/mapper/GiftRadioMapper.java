package com.yukari.dydanmuapi.mapper;

import com.yukari.dydanmuapi.model.GiftRadio;

import java.util.List;

public interface GiftRadioMapper {

    List<GiftRadio> getGiftRadiosByTime (String boxEndTime);

}