package com.elysian.todoapplication.services;
import com.elysian.todoapplication.entity.Work;
import java.util.List;

public interface WorkService {

    List<Work> getAllWorks() ;

    // Save operation
    Work saveWork(Work work);

    // Read operation
//    List<Work> fetchWorkList();

    // Update operation
//    Work updateWork(Work work,int workId);


    List<Work> updateWorkType(String work, int workId);

    // Delete operation
    void deleteWorkById(int workId);

    Work updateWork(Work work, int workId);
}

