package com.yukari.mapper;


import com.yukari.model.AnchorOnlineTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnchorOnlineTimeMapper {

    AnchorOnlineTime getLast();

    void updateOnlineTime(AnchorOnlineTime anchorOnlineTime);

    void insert(AnchorOnlineTime anchorOnlineTime);

    List<String> getOneMonthAllTimeLength (@Param("startTime") String startTime, @Param("endTime") String endTime);



}
