package com.sai.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.microservice.entity.Course;
import com.sai.microservice.repo.CourseRepository;
import com.sai.microservice.request.CreateCourseRequest;
import com.sai.microservice.response.CourseResponse;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	

	public String createCourse(CreateCourseRequest createCourseRequest) {
		
		Course course=new Course();
		course.setTitle(createCourseRequest.getTitle());
		course.setDuration(createCourseRequest.getDuration());
		
		course=courseRepository.save(course);
		
		return "Course created successfully";
	}
	
	public CourseResponse getById (long id) {
		
		Course course=courseRepository.findById(id).get();
		
		return new CourseResponse(course);
		
	}
	
	
	public List<Course> findAllCourses(){
		List<Course> courses=courseRepository.findAll();
		return courses;
	}
	
	

}

