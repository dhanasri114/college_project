package com.spring.react.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.react.project.details.Student;
import com.spring.react.project.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:5173") //this this react localhost url
public class StudentController 
{
	@Autowired
	StudentService studservice;
	
	//add list of students
	@PostMapping("/student/addstudents")
	public List<Student> addStudents(@RequestBody List<Student> stud)
	{
		return studservice.addStudentdetails(stud);
	}
	
	@PostMapping("student/addstudent")
	public Student createStudent(@RequestBody Student stud)
	{
		return studservice.addStudent(stud);
	}
	
	@GetMapping("student/readall")
	public List<Student> readStudentAll()
	{
		return studservice.readAllStudent();
	}
	
	@GetMapping("student/readid/{sid}")
	public Student readStudentById(@PathVariable int sid)
	{
		return studservice.readStudentById(sid);
	}
	
	@PutMapping("student/update/number/{sid}/{number}")
	public Student updateStudentNumber(@PathVariable int sid,@PathVariable long number)
	{
		return studservice.updateStudentById(sid, number);
	}
	
	@PutMapping("student/{sid}")
		public Student updateStudentAll(@PathVariable int sid,@RequestBody Student stud)
		{
		return studservice.updateStudent(sid,stud);
		}
	
	@DeleteMapping("student/delete/{sid}")
	public Student deleteStudentById(@PathVariable int sid)
	{
		return studservice.deleteStudent(sid);
	}
}