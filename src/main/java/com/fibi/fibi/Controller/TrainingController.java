package com.fibi.fibi.Controller;


import com.fibi.fibi.Constants.Constants;
import com.fibi.fibi.model.Assignment;
import com.fibi.fibi.model.TrainingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import com.fibi.fibi.model.Training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    AulaRepository aulaRepository;

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
        training.setDate(parseDate(trainingDto.getDate()));
        training.setTime(parseTime(trainingDto.getTime()));
        training.setAula(aulaRepository.findById(trainingDto.getAula()).get());
        return training;
    }


    private TrainingDto createTransferObject(Training t) {
        String date = t.getDate().toString();
        String time = t.getTime().toString();
        return new TrainingDto(t.getTrainid(), t.getUserProfessor().getUserId(), t.getUserStudent().getUserId(), t.getPrice(), t.getAssignment().getAssignmentName(), t.getAula().getAula(), date, time);
    }

    private Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    private Date parseTime(String time) {
        try {
            return new SimpleDateFormat("HH:mm:ss").parse(time);
        } catch (ParseException e) {
            return null;
        }
    }


}
