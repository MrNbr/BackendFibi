package com.fibi.fibi.Controller;


import com.fibi.fibi.Constants.Constants;
import com.fibi.fibi.model.Assignment;
import com.fibi.fibi.model.TrainingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import com.fibi.fibi.model.Training;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(Constants.API_PATH + TrainingController.PATH)
public class TrainingController implements Serializable {

    public static final String PATH = "/trainings";

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AssignmentRepository assignmentRepository;

    @GetMapping
    public List<TrainingDto> getAllTrainings() {
        List<Training> trainings = trainingRepository.findAll();
        List<TrainingDto> allTrainings = new ArrayList<>();
        for(Training t : trainings ) {
            allTrainings.add(createTransferObject(t));
        }
        return allTrainings;
    }

    @PostMapping
    public TrainingDto createTraining(@Valid @RequestBody TrainingDto trainingDto) {
        Training t = trainingRepository.save(createPersistentObject(trainingDto));
        return createTransferObject(t);
    }

    private Training createPersistentObject(TrainingDto trainingDto) {
        Training training = new Training();
        training.setPrice(trainingDto.getPrice());
        training.setAssignment(assignmentRepository.findById(trainingDto.getAssignment()).get());
        training.setUserProfessor(userRepository.findById(trainingDto.getProfessorId()).get());
        training.setUserStudent(userRepository.findById(trainingDto.getStudentId()).get());
        return training;
    }


    private TrainingDto createTransferObject(Training t) {
        return new TrainingDto(t.getTrainid(), t.getUserProfessor().getUserId(), t.getUserStudent().getUserId(), t.getPrice(), t.getAssignment().getAssignmentName());
    }


}
