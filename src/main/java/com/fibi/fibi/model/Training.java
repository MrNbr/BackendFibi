package com.fibi.fibi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "training", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id_professor", "user_id_student"}))
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trainid;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id_professor")
    User userProfessor;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id_student")
    User userStudent;

    @NotNull
    int price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "aula")
    Aula aula;

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    @Temporal(TemporalType.DATE)
    private java.util.Date date;

    @Temporal(TemporalType.TIME)
    private java.util.Date time;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "assignment")
    private Assignment assignment;

    public long getTrainid() {
        return trainid;
    }

    public void setTrainid(long trainid) {
        this.trainid = trainid;
    }

    public User getUserProfessor() {
        return userProfessor;
    }

    public void setUserProfessor(User userProfessor) {
        this.userProfessor = userProfessor;
    }

    public User getUserStudent() {
        return userStudent;
    }

    public void setUserStudent(User userStudent) {
        this.userStudent = userStudent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
