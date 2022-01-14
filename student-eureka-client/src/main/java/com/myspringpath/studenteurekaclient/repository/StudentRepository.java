package com.myspringpath.studenteurekaclient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myspringpath.studenteurekaclient.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
