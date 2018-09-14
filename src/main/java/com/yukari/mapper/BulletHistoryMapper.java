package com.yukari.mapper;

import com.yukari.model.BulletHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BulletHistoryMapper {
    List<BulletHistory> getAllBulletHistory();

    List<Map<String,Object>> queryBulletRankByRange(@Param("startTime") String startTime, @Param("endTime") String endTime);
}