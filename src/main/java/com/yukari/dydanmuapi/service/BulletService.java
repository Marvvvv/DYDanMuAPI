package com.yukari.dydanmuapi.service;

import com.github.pagehelper.PageInfo;
import com.yukari.dydanmuapi.model.BulletHistory;

import java.util.List;
import java.util.Map;

public interface BulletService {

    PageInfo<BulletHistory> findAllBullet(int pageNum);

    List<Map<String,Object>> bulletCountRank (String timeRange);

}
