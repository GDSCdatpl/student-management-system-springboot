package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.sms.repository.CourseRepository;

@Controller
public class CourseController {
	private CourseRepository courseRepository;
	
	@GetMapping("/courses")
	private String getCourses(Model model) {
		model.addAttribute("courses", courseRepository.findAll());
		return "courses";
	}
}
