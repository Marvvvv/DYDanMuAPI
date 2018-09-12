package com.yukari.dydanmuapi.service;

import com.github.pagehelper.PageInfo;
import com.yukari.dydanmuapi.model.BulletHistory;

public interface BulletService {

    PageInfo<BulletHistory> findAllBullet(int pageNum);

}
