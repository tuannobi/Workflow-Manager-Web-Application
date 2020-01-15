package com.tuan.workmanager.model;

import java.util.Date;

public class Board {
    private int boardId;
    private String tile;
    private String description;
    private Date createdDate;
    private Date modifiedLastestDate;
    private int userId;
    private Date startDate;
    private Date endDate;

    public Board(String tile, String description, Date createdDate, int userId, Date startDate, Date endDate) {
        this.tile = tile;
        this.description = description;
        this.createdDate = createdDate;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Board(int boardId, String tile, String description, Date createdDate, Date modifiedLastestDate, int userId, Date startDate, Date endDate) {
        this.boardId = boardId;
        this.tile = tile;
        this.description = description;
        this.createdDate = createdDate;
        this.modifiedLastestDate = modifiedLastestDate;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Board(int boardId, String tile, String description, Date modifiedLastestDate, int userId, Date startDate, Date endDate) {
        this.boardId = boardId;
        this.tile = tile;
        this.description = description;
        this.modifiedLastestDate = modifiedLastestDate;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Board() {

    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedLastestDate() {
        return modifiedLastestDate;
    }

    public void setModifiedLastestDate(Date modifiedLastestDate) {
        this.modifiedLastestDate = modifiedLastestDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", tile='" + tile + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedLastestDate=" + modifiedLastestDate +
                ", userId=" + userId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
