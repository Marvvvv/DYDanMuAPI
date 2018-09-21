package com.yukari.cache;

import com.yukari.model.GiftInfo;

import java.util.Map;

/**
 * 全局缓存类
 */
public class GlobalCache {

    private static GlobalCache globalCache = new GlobalCache();


    public static GlobalCache getGlobalCache() {
        return globalCache;
    }

    private Map<Integer, GiftInfo> giftInfoCache;

    public Map<Integer, GiftInfo> getGiftInfoCache() {
        return giftInfoCache;
    }

    public void setGiftInfoCache(Map<Integer, GiftInfo> giftInfoCache) {
        this.giftInfoCache = giftInfoCache;
    }
}

