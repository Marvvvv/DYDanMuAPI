package com.yukari.dydanmuapi.service;

import com.github.pagehelper.PageInfo;
import com.yukari.dydanmuapi.model.BulletHistory;

public interface BulletService {

    BulletHistory queryBulletByPK (Integer pkid);

    PageInfo<BulletHistory> findAllBullet(int pageNum, int pageSize);

}
