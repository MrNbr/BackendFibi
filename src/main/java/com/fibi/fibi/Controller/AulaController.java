package com.fibi.fibi.Controller;

import com.fibi.fibi.Constants.Constants;
import com.fibi.fibi.model.Aula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(Constants.API_PATH + AulaController.PATH)
public class AulaController {

    public static final String PATH = "/aules";

    @Autowired
    AulaRepository aulaRepository;

    @GetMapping
    public List<Aula> getAules() {
        return aulaRepository.findAll();
    }
}
