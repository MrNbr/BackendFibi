package com.fibi.fibi.Controller;

import com.fibi.fibi.Constants.Constants;
import com.fibi.fibi.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_PATH + AssignmentController.PATH)
public class AssignmentController {

    public static final String PATH = "/assignments";

    @Autowired
    AssignmentRepository assignmentRepository;

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @PostMapping
    public Assignment createAssignment(@Valid @RequestBody Assignment assignment) {
        return assignmentRepository.save(assignment);
    }
}
