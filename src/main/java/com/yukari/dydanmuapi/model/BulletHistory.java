package com.yukari.dydanmuapi.model;

import java.util.Date;

public class BulletHistory {
    private Integer id;

    private Integer roomId;

    private Integer uid;

    private String uname;

    private Integer ulevel;

    private String headiconUrl;

    private String fansCardName;

    private Integer fansCardLevel;

    private Integer fansCardRoomId;

    private String content;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getUlevel() {
        return ulevel;
    }

    public void setUlevel(Integer ulevel) {
        this.ulevel = ulevel;
    }

    public String getHeadiconUrl() {
        return headiconUrl;
    }

    public void setHeadiconUrl(String headiconUrl) {
        this.headiconUrl = headiconUrl == null ? null : headiconUrl.trim();
    }

    public String getFansCardName() {
        return fansCardName;
    }

    public void setFansCardName(String fansCardName) {
        this.fansCardName = fansCardName == null ? null : fansCardName.trim();
    }

    public Integer getFansCardLevel() {
        return fansCardLevel;
    }

    public void setFansCardLevel(Integer fansCardLevel) {
        this.fansCardLevel = fansCardLevel;
    }

    public Integer getFansCardRoomId() {
        return fansCardRoomId;
    }

    public void setFansCardRoomId(Integer fansCardRoomId) {
        this.fansCardRoomId = fansCardRoomId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}