package net.javaguides.sms.controller;

import net.javaguides.sms.entity.Course;
import net.javaguides.sms.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.sms.repository.CourseRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/courses")
	private String getCourses(Model model) {
		model.addAttribute("courses", courseRepository.findAll());
		return "courses";
	}

	@GetMapping("/courses/{id}")
	private String getCourseById(Model model, Long id) {
		model.addAttribute("course", courseRepository.findById(id).get());
		return "course";
	}

	@PostMapping("/courses/new")
	public String saveCourse(@ModelAttribute("course") Course course) {
		courseRepository.save(course);
		return "redirect:/courses";
	}

	@GetMapping("/courses/edit/{id}")
	public String editCourseForm(@PathVariable Long id, Model model) {
		model.addAttribute("course", courseRepository.findById(id).get());
		return "edit_course";
	}


	@GetMapping("/courses/new")
	public String createCourseForm(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "create_course";
	}

	// handle delete course
	@GetMapping("/courses/delete/{id}")
	public String deleteCourse(Model model, Long id) {
		courseRepository.deleteById(id);
		return "redirect:/courses";
	}
}
