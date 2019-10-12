package com.fibi.fibi.Controller;


import com.fibi.fibi.Constants.Constants;
import com.fibi.fibi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(Constants.API_PATH + TrainingController.PATH)
public class TrainingController implements Serializable {

    public static final String PATH = "/trainingsScheduled";

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TrainAdRepository trainAdRepository;


    @GetMapping
    public List<TrainingDto> getAllTrainingsScheduled() {
        List<Training> trainings = trainingRepository.findAll();
        List<TrainingDto> allTrainings = new ArrayList<>();
        for(Training t : trainings ) {
            allTrainings.add(createTransferObject(t));
        }
        return allTrainings;
    }

    @PostMapping
    public TrainingDto scheduleTraining(@Valid @RequestBody TrainingDto trainingDto) {
        if(trainingDto.getProfessorId() == trainingDto.getStudentId()) {
            return null;
        }
        Training t = trainingRepository.save(createPersistentObject(trainingDto));
        TrainAd tAd = t.getTrainid();
        int price = tAd.getPrice();
        User student = t.getUserStudent();
        User professor = t.getUserProfessor();
        student.setKoins(student.getKoins() - price);
        professor.setKoins(professor.getKoins() + price);
        userRepository.save(student);
        userRepository.save(professor);
        return createTransferObject(t);
    }

    private TrainingDto createTransferObject(Training t) {
        return new TrainingDto(t.getTrainingSheduledId(), t.getTrainid().getTrainid(), t.getUserStudent().getUserId(), t.getUserProfessor().getUserId());
    }

    private Training createPersistentObject(TrainingDto trainingDto) {
        Training training = new Training();
        training.setTrainingSheduledId(trainingDto.getTrainingScheduleId());
        training.setUserStudent(userRepository.findById(trainingDto.getStudentId()).get());
        training.setUserProfessor(userRepository.findById(trainingDto.getProfessorId()).get());
        training.setTrainid(trainAdRepository.findById(trainingDto.getTrainId()).get());
        return training;
    }

}
