package se2.group2.controller;

import se2.group2.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import se2.group2.repository.CourseRepository;
import se2.group2.repository.EnrollmentRepository;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@GetMapping("/courses")
	private String getCourses(Model model) {
		model.addAttribute("courses", courseRepository.findAll());
		return "courses";
	}

	@GetMapping("/courses/{id}")
	private String getCourseById(Model model, @PathVariable Long id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);
		if (optionalCourse.isPresent()) {
			model.addAttribute("course", optionalCourse.get());
			return "course";
		} else {
			return "error";
		}
	}
	
	@GetMapping("/student/courses")
	private String getStudentCourses(Model model) {
		GlobalModel.INSTANCE.put("sid", 1L);
		List<Course> courses = courseRepository.findAll();
		 Long sid = (Long) GlobalModel.INSTANCE.get("sid");
		for (Course course : courses) {
			if (!enrollmentRepository.findByStudentIdAndCourseId(sid, course.id)
					.isEmpty())
				course.enrolled = true;
			else
				course.enrolled = false;
		}
		model.addAttribute("courses", courseRepository.findAll());
		return "student_courses";
	}
	
	@GetMapping("/student/courses/{id}")
	private String getStudentCourseById(Model model, @PathVariable Long id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);
		if (optionalCourse.isPresent()) {
			Course course = optionalCourse.get();
			Long sid = (Long) GlobalModel.INSTANCE.get("sid");
			if (!enrollmentRepository.findByStudentIdAndCourseId(sid, course.id)
					.isEmpty())
				course.enrolled = true;
			else
				course.enrolled = false;
			model.addAttribute("course", course);
			return "student_course";
		} else {
			return "error";
		}
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


	@PostMapping("/courses/{id}")
	public String updateCourse(@PathVariable Long id,
								@ModelAttribute("student") Course course,
								Model model) {

		// get course from database by id
		Course existingCourse = courseRepository.findById(id).get();
		existingCourse.setId(id);
		existingCourse.setName(course.getName());
		existingCourse.setTeacherId(course.getTeacherId());
		existingCourse.setDesc(course.getDesc());

		// save updated course object
		courseRepository.save(existingCourse);
		return "redirect:/courses";
	}


	@GetMapping("/courses/new")
	public String createCourseForm(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "create_course";
	}

	// handle delete course
	@GetMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable Long id) {
		courseRepository.deleteById(id);
		return "redirect:/courses";
	}
}
