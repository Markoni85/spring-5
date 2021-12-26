package com.myspringpath.studenteurekaclient.repository;

import org.springframework.data.repository.CrudRepository;

import com.myspringpath.studenteurekaclient.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
