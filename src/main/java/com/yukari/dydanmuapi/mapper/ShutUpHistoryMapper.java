package com.yukari.dydanmuapi.mapper;

import com.yukari.dydanmuapi.model.ShutUpHistory;

public interface ShutUpHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShutUpHistory record);

    int insertSelective(ShutUpHistory record);

    ShutUpHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShutUpHistory record);

    int updateByPrimaryKey(ShutUpHistory record);
}