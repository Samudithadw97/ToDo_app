package com.elysian.todoapplication.services.impl;
import com.elysian.todoapplication.entity.Work;
import com.elysian.todoapplication.repository.WorkRepository;

//Import require class
import java.util.List;
import java.util.Optional;

import com.elysian.todoapplication.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Annotation
@Service

public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkRepository workRepository;

    //save operation
    @Override
    public Work saveWork(Work work) {
        return workRepository.save(work);
    }

    //Read operation
    @Override
    public List<Work> getAllWorks() {
        return workRepository.findAll();
    }

    @Override
    public Work updateWork(Work work, int workId) {
        Optional<Work> oldWork = workRepository.findById(workId);
        Work newWork = oldWork.get();
        work.setId(newWork.getId());
        return workRepository.save(work);
    }

    @Override
    public List<Work> updateWorkType(String work, int workId) {
        workRepository.updateWorkTypeByID(work,workId);
        return workRepository.findAll();
    }

    // Delete operation
    @Override
    public void deleteWorkById(int workId) {
        workRepository.deleteById(workId);
    }

    // Update operation
//    @Override
//    public Work updateWork(Work work, int workId) {
//        Work todo = workRepository.findById(workId).get();
//
//        if (Objects.nonNull(work.getWorkDate())
//                && !"".equalsIgnoreCase(
//                work.getWorkDate())) {
//            todo.setWorkDate(
//                    work.getWorkDate());
//        }
//
//        if (Objects.nonNull(
//                work.getWorkNote())
//                && !"".equalsIgnoreCase(
//                work.getWorkNote())) {
//            todo.setWorkNote(
//                    work.getWorkNote());
//        }
//
//        if (Objects.nonNull(work.getWorkTime())
//                && !"".equalsIgnoreCase(
//                work.getWorkTime())) {
//            todo.setWorkTime(
//                    work.getWorkTime());
//        }
//
//        return null;
//
//    }
}






