package com.elysian.todoapplication.repository;


import com.elysian.todoapplication.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
public interface WorkRepository extends JpaRepository<Work, Integer> {
    @Modifying
    @Query(value = "UPDATE work SET worktype = :worktype WHERE id = :id", nativeQuery = true)
    void updateWorkTypeByID(String worktype, Integer id);

}
