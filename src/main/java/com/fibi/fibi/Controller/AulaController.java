package com.fibi.fibi.Controller;

import com.fibi.fibi.Constants.Constants;
import com.fibi.fibi.model.Aula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public Aula createAula(@Valid @RequestBody Aula aula) {
        return aulaRepository.save(aula);
    }
}
