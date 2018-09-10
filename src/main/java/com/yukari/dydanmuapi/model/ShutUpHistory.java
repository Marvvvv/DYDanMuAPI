package com.yukari.dydanmuapi.model;

import java.util.Date;

public class ShutUpHistory {
    private Integer id;

    private Integer roomId;

    private Integer executerType;

    private Integer executerId;

    private String executerName;

    private Integer shutupId;

    private String shutupName;

    private Date endTime;

    private String banTime;

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

    public Integer getExecuterType() {
        return executerType;
    }

    public void setExecuterType(Integer executerType) {
        this.executerType = executerType;
    }

    public Integer getExecuterId() {
        return executerId;
    }

    public void setExecuterId(Integer executerId) {
        this.executerId = executerId;
    }

    public String getExecuterName() {
        return executerName;
    }

    public void setExecuterName(String executerName) {
        this.executerName = executerName == null ? null : executerName.trim();
    }

    public Integer getShutupId() {
        return shutupId;
    }

    public void setShutupId(Integer shutupId) {
        this.shutupId = shutupId;
    }

    public String getShutupName() {
        return shutupName;
    }

    public void setShutupName(String shutupName) {
        this.shutupName = shutupName == null ? null : shutupName.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBanTime() {
        return banTime;
    }

    public void setBanTime(String banTime) {
        this.banTime = banTime == null ? null : banTime.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}