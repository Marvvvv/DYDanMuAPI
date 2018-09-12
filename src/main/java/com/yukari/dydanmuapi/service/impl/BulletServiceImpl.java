package com.yukari.dydanmuapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yukari.dydanmuapi.mapper.BulletHistoryMapper;
import com.yukari.dydanmuapi.model.BulletHistory;
import com.yukari.dydanmuapi.service.BulletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulletServiceImpl implements BulletService{

    @Autowired
    BulletHistoryMapper bulletHistoryMapper;

    private static Logger logger = LoggerFactory.getLogger(BulletServiceImpl.class);

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<BulletHistory> findAllBullet (int pageNum) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, 20);
        List<BulletHistory> bullets = bulletHistoryMapper.getAllBulletHistory();
        PageInfo result = new PageInfo(bullets);
        return result;
    }

}
