package com.fibi.fibi.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TrainAd")
public class TrainAd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trainid;

    @Min(5)
    @NotNull
    int price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "aula")
    Aula aula;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "createdBy")
    User userCreator;

    @Temporal(TemporalType.DATE)
    private java.util.Date date;

    @Temporal(TemporalType.TIME)
    private java.util.Date time;


    public long getTrainid() {
        return trainid;
    }

    public void setTrainid(long trainid) {
        this.trainid = trainid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(User userCreator) {
        this.userCreator = userCreator;
    }
}
