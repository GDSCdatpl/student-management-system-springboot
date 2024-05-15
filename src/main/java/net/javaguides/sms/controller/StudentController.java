package net.javaguides.sms.controller;

import net.javaguides.sms.entity.Course;
import net.javaguides.sms.entity.Enrollment;
import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.CourseRepository;
import net.javaguides.sms.repository.EnrollmentRepository;
import net.javaguides.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private CourseRepository courseRepository;


    // handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model) {
    	final List<Student> students = studentRepository.findAll();
    	for (Student student : students) {
    		List<Enrollment> enrollments = enrollmentRepository.findByStudentId(student.getId());
    		List<Course> courses = courseRepository.findAllById(
    					enrollments
    					.stream()
    					.map(enr -> enr.courseId)
    					.toList()
    				);
    		student.setCourses(courses);
    	}
    	model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        // create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentRepository.findById(id).get());
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {

        // get student from database by id
        Student existingStudent = studentRepository.findById(id).get();
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setIsDisabled(student.getIsDisabled());


        // save updated student object
        studentRepository.save(existingStudent);
        return "redirect:/students";
    }

    // handler method to handle delete student request

    @GetMapping("/students/disable/{id}")
    public String disableStudent(@PathVariable Long id) {
        final Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            final Student student = studentOptional.get();
            student.setIsDisabled(true);
            studentRepository.save(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/students/enroll/{id}")
    public String enrollStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentRepository.findById(id).get());
        model.addAttribute("enrollment", new Enrollment());
        return "enroll_student";
    }
    
    @GetMapping("/students/enroll/course/{cid}")
    public String studentEnrollCourse(@PathVariable Long cid, Model model) {
        Long sid = (Long) GlobalModel.INSTANCE.get("sid");
        Enrollment enrollment = new Enrollment(
        			sid,
        			cid
        		);
        enrollmentRepository.save(enrollment);
        return "redirect:/student/courses";
    }
    
    @PostMapping("/students/enroll")
    public String enrollStudent(@ModelAttribute("enrollment") Enrollment enrollment) {
    	enrollmentRepository.save(enrollment);
        return "redirect:/students";
    }
    
    @GetMapping("/students/kick/{sid}/{cid}")
    public String enrollStudentForm(@PathVariable Long sid, @PathVariable Long cid, Model model) {
    	List<Enrollment> enrollments = enrollmentRepository.findByStudentId(sid);
    	for (Enrollment enrollment : enrollments) {
    		if (enrollment.courseId == cid) 
    			enrollmentRepository.delete(enrollment);
    	}
        return "redirect:/students";
    }
}
