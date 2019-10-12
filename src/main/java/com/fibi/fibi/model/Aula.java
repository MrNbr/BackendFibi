package com.fibi.fibi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aula")
public class Aula {

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    @Id
    private String aula;

}
