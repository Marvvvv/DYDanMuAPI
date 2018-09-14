package com.yukari.service;

import com.github.pagehelper.PageInfo;
import com.yukari.model.ShutUpHistory;

public interface ShutUpService {

    PageInfo<ShutUpHistory> findByRange(String timeRange, int page, int pageSize);

}
