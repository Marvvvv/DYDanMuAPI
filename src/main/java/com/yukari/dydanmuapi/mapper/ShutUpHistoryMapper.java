package com.yukari.dydanmuapi.mapper;


import com.yukari.dydanmuapi.model.ShutUpHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShutUpHistoryMapper {

    List<ShutUpHistory> getByTimeRange (@Param("startTime") String startTime, @Param("endTime") String endTime);

}