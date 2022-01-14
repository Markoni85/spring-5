package com.myspringpath.studentexameseurekaclient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myspringpath.studentexameseurekaclient.model.StudentExam;

@Repository
public interface StudentExamRepository extends CrudRepository<StudentExam, Long> {

}
