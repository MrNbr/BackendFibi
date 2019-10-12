package com.fibi.fibi.model;

public class TrainAdDto {
    private long trainId;

    private long creatorId;

    private String date;

    private String time;

    private String aula;

    private int price;

    public long getTrainId() {
        return trainId;
    }

    public void setTrainId(long trainId) {
        this.trainId = trainId;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TrainAdDto(long trainId, long creatorId, String date, String time, String aula, int price) {
        this.trainId = trainId;
        this.creatorId = creatorId;
        this.date = date;
        this.time = time;
        this.aula = aula;
        this.price = price;
    }
}
