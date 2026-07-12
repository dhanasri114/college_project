package com.spring.react.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.react.project.details.Student;
import com.spring.react.project.repository.Studentrepository;

@Service
public class StudentService 
{
	@Autowired
	Studentrepository studrepo;
	
	public List<Student> addStudentdetails(List<Student> stud)
	{
		return studrepo.saveAll(stud);
	}
	
	public Student addStudent(Student stud)
	{
		return studrepo.save(stud);
	}
	
	public List<Student> readAllStudent()
	{
		return studrepo.findAll();
	}
	
	public Student readStudentById(int sid)
	{
		return studrepo.findById(sid).orElse(null);
	}
	public Student updateStudentById(int sid,long number)
	{
		Student stud=new Student();
		stud=studrepo.findById(sid).orElse(null);
		stud.setNumber(number);
		return studrepo.save(stud);
	}
	public Student updateStudent(int sid,Student stud)
	{
		Student stu=new Student();
		stu=studrepo.findById(sid).orElse(null);
		
		stu.setName(stud.getName());
		stu.setBranch(stud.getBranch());
		stu.setNumber(stud.getNumber());
		stu.setEmail(stud.getEmail());
		return studrepo.save(stu);
	}
	
	public Student deleteStudent(int sid)
	{
		 studrepo.deleteById(sid);
		 return null;
	}
}
