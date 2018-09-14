package com.yukari.mapper;


import com.yukari.model.ShutUpHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShutUpHistoryMapper {

    List<ShutUpHistory> getByTimeRange (@Param("startTime") String startTime, @Param("endTime") String endTime);

}