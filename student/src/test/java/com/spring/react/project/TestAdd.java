package com.spring.react.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.react.project.details.Student;
import com.spring.react.project.repository.Studentrepository;
import com.spring.react.project.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class TestAdd 
{
	@Mock
	Studentrepository srepo;
	
	@InjectMocks
	StudentService service;
	
	@Test
	void testAddStudent()
	{
		Student stu=new Student();
		
		stu.setSid(1);
		stu.setName("sai");
		stu.setEmail("sai@gmail.com");
		stu.setBranch("cse");
		stu.setNumber(9787567452l);
		
		
		//it is fake object 
//		Studentrepository srepo = mock(Studentrepository.class);
		
		when(srepo.save(stu)).thenReturn(stu);
		
//		StudentService service=new StudentService();
		
		Student actual = service.addStudent(stu);
		
		assertEquals(1,actual.getSid());
		assertEquals("sai", actual.getName());
		
//		verify(srepo).save(stu);
//		
//		srepo.save(stu);
//		srepo.save(stu);
//		it show how many tome to call your mock object
		verify(srepo,times(3)).save(stu);
		
	}
}
