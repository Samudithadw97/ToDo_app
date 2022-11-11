package com.elysian.todoapplication.controller;

import com.elysian.todoapplication.entity.Work;
import com.elysian.todoapplication.services.WorkService;

import java.util.List;

//Import require classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Annotation

@CrossOrigin("*")
@RestController
@RequestMapping("api/work")
public class WorkController {
    @Autowired
    private WorkService workService;

    // Save operation
    @PostMapping("/save")
    public Work saveWork(@RequestBody Work work) {
        return workService.saveWork(work);
    }

    // Read operation
    @GetMapping("/read")
    public ResponseEntity<?> getAll() {
        List<Work> work  = workService.getAllWorks();
        return new ResponseEntity<>(work, HttpStatus.OK) ;
    }

    //Update operation
    @PutMapping("/update/{id}")
    public ResponseEntity<?>  updateWork(@RequestBody Work work, @PathVariable("id") int workId) {
        Work updatework = workService.updateWork(work, workId);
        return new ResponseEntity<>(updatework, HttpStatus.OK) ;
    }

    //Update work type
    @PatchMapping("/updatetype/{wid}")
    public ResponseEntity<?>  updateWorkType(@RequestBody Work worktype, @PathVariable("wid") int workId) {
        List<Work> works = workService.updateWorkType(worktype.getWorktype(), workId);
        return new ResponseEntity<>(works, HttpStatus.OK) ;
    }

    // Delete operation
    @DeleteMapping("/delete/{id}")
    public String deleteWorkById(@PathVariable("id") int workId) {
        workService.deleteWorkById(workId);
        return "Deleted Successfully";
    }
}

