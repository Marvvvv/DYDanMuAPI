package com.yukari.service;

import com.github.pagehelper.PageInfo;
import com.yukari.model.BulletHistory;

import java.util.List;
import java.util.Map;

public interface BulletService {

    PageInfo<BulletHistory> findAllBullet(int pageNum);

    List<Map<String,Object>> bulletCountRank (String timeRange);

}
