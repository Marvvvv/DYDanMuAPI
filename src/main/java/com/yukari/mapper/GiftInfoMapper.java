package com.yukari.mapper;

import com.yukari.model.GiftInfo;

import java.util.List;

public interface GiftInfoMapper {

    List<GiftInfo> getAllGift();

    void emptyData();

    void insert(GiftInfo giftInfo);

    void batchInsert(List<GiftInfo> giftInfos);



}
