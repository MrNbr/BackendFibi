package com.fibi.fibi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import java.io.Serializable;

@Embeddable
public class AulaId implements Serializable {

    @Column(name = "floor", nullable = false)
    private String floor;

    @Column(name = "building", nullable = false)
    private String building;

    @Column(name = "number", nullable = false)
    private String number;

    public AulaId(String building, String floor, String number) {
        this.floor = floor;
        this.building = building;
        this.number = number;
    }

}
