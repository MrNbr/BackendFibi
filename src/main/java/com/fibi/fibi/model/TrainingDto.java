package com.fibi.fibi.model;

public class TrainingDto {

    private long trainingScheduleId;

    private long trainId;

    private long studentId;

    private long professorId;

    public TrainingDto(long trainingScheduleId, long trainId, long studentId, long professorId) {
        this.trainId = trainId;
        this.studentId = studentId;
        this.professorId = professorId;
        this.trainingScheduleId = trainingScheduleId;
    }

    public long getTrainId() {
        return trainId;
    }

    public void setTrainId(long trainId) {
        this.trainId = trainId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    public long getTrainingScheduleId() {
        return trainingScheduleId;
    }

    public void setTrainingScheduleId(long trainingScheduleId) {
        this.trainingScheduleId = trainingScheduleId;
    }
}
