package com.fibi.fibi.model;

public class TrainingDto {
    private long trainId;

    private long professorId;

    private long studentId;

    private int price;

    private String assignment;

    private String date;

    private String time;

    private String aula;

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

    public long getTrainId() {
        return trainId;
    }

    public void setTrainId(long trainId) {
        this.trainId = trainId;
    }

    public long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public TrainingDto(long trainId, long professorId, long studentId, int price, String assignment, String aula, String date, String time) {
        this.trainId = trainId;
        this.professorId = professorId;
        this.studentId = studentId;
        this.price = price;
        this.assignment = assignment;
        this.aula = aula;
        this.date = date;
        this.time = time;
    }
}
