package com.yukari.mapper;


import com.yukari.model.NobleOpenOrRenew;

import java.util.List;

public interface NobleOpenOrRenewMapper {

    List<NobleOpenOrRenew> getGiftRadiosByTime (String boxEndTime);

}