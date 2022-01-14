package com.myspringpath.studentexameseurekaclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myspringpath.studentexameseurekaclient.StudentExamRepository;
import com.myspringpath.studentexameseurekaclient.model.StudentExam;

@RestController
@RequestMapping("/student-exames")
public class StudentExamController {

	@Autowired
	private StudentExamRepository examRepository;
	
	@GetMapping
	public List<StudentExam> getStudentsExams() {
		List<StudentExam> studentExams = (List<StudentExam>) examRepository.findAll();
		
		return studentExams;
	}
	
	@GetMapping("/{studentId}")
	@ResponseBody
	public StudentExam getForStudentId(@PathVariable("studentId") long studentId) {
		StudentExam se = examRepository.findById(studentId).get();
		return se;
	}
}
