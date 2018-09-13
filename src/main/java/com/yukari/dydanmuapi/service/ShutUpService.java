package com.yukari.dydanmuapi.service;

import com.github.pagehelper.PageInfo;
import com.yukari.dydanmuapi.model.ShutUpHistory;

public interface ShutUpService {

    PageInfo<ShutUpHistory> findByRange(String timeRange, int page, int pageSize);

}
