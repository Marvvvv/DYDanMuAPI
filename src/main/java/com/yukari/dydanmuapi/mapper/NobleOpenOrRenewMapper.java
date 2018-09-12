package com.yukari.dydanmuapi.mapper;


import com.yukari.dydanmuapi.model.NobleOpenOrRenew;

import java.util.List;

public interface NobleOpenOrRenewMapper {

    List<NobleOpenOrRenew> getGiftRadiosByTime (String boxEndTime);

}