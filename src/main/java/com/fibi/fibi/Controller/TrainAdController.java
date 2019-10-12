package com.fibi.fibi.Controller;

import com.fibi.fibi.Constants.Constants;
import com.fibi.fibi.model.TrainAd;
import com.fibi.fibi.model.Training;
import com.fibi.fibi.model.TrainAdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Constants.API_PATH + TrainAdController.PATH)
public class TrainAdController {

    public static final String PATH = "/trainingAds";

    @Autowired
    TrainAdRepository trainAdRepository;

    @Autowired
    AulaRepository aulaRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<TrainAdDto> getAllTrainingAds() {
        List<TrainAd> trainings = trainAdRepository.findAll();
        List<TrainAdDto> allTrainings = new ArrayList<>();
        for(TrainAd t : trainings ) {
            allTrainings.add(createTransferObject(t));
        }
        return allTrainings;
    }

    @PostMapping
    public TrainAdDto createTraining(@Valid @RequestBody TrainAdDto trainAdDto) {
        TrainAd t = trainAdRepository.save(createPersistentObject(trainAdDto));
        return createTransferObject(t);
    }

    private TrainAd createPersistentObject(TrainAdDto trainAdDto) {
        TrainAd t = new TrainAd();
        t.setAula(aulaRepository.findById(trainAdDto.getAula()).get());
        t.setUserCreator(userRepository.findById(trainAdDto.getCreatorId()).get());
        t.setDate(parseDate(trainAdDto.getDate()));
        t.setTime(parseTime(trainAdDto.getTime()));
        t.setPrice(trainAdDto.getPrice());
        return t;
    }

    private TrainAdDto createTransferObject(TrainAd t) {
        String date = t.getDate().toString();
        String time = t.getTime().toString();
        return new TrainAdDto(t.getTrainid(), t.getUserCreator().getUserId(), date, time, t.getAula().getAula(), t.getPrice());
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
