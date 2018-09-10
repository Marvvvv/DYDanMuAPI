package com.yukari.dydanmuapi.mapper;

import com.yukari.dydanmuapi.model.BulletHistory;

public interface BulletHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BulletHistory record);

    int insertSelective(BulletHistory record);

    BulletHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BulletHistory record);

    int updateByPrimaryKey(BulletHistory record);
}