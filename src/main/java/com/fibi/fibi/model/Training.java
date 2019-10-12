package com.fibi.fibi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "training", uniqueConstraints = @UniqueConstraint(columnNames = {"train_id", "user_id_professor", "user_id_student"}))
public class Training implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trainingSheduledId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "train_id")
    private TrainAd trainid;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id_professor")
    User userProfessor;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id_student")
    User userStudent;

    public long getTrainingSheduledId() {
        return trainingSheduledId;
    }

    public void setTrainingSheduledId(long trainingSheduledId) {
        this.trainingSheduledId = trainingSheduledId;
    }

    public TrainAd getTrainid() {
        return trainid;
    }

    public void setTrainid(TrainAd trainid) {
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
}
