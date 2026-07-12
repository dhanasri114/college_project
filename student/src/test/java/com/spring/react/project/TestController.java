package com.spring.react.project;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.react.project.controller.StudentController;
import com.spring.react.project.details.Student;
import com.spring.react.project.service.StudentService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@WebMvcTest(StudentController.class)
public class TestController 
{
	@Autowired
	MockMvc mvc;
	
	  @MockitoBean
	  StudentService service;
	
	
	  @Test
	void testAddStident() throws Exception
	{
		Student stu=new Student();
		
		stu.setSid(1);
		stu.setName("dhanu");
		stu.setEmail("dhnau@gmail.com");
		stu.setNumber(9867864587l);
		stu.setBranch("CSE");
		
		when(service.addStudent(any(Student.class))).thenReturn(stu);
		
		String json="""
				
				{
				"sid": 1,
				"name": "dhanu",
				"email": "dhanu@gmail.com",
				"branch": "CSE",
				"number": 9867864587
				}
				""";
		
		
		mvc.perform(post("/student/addstudent")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content(json))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.sid").value(1))
		        .andExpect(jsonPath("$.name").value("dhanu"));
	}
}
