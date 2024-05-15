package net.javaguides.sms;

import net.javaguides.sms.entity.Course;
import net.javaguides.sms.entity.Enrollment;
import net.javaguides.sms.entity.Student;
import net.javaguides.sms.entity.Teacher;
import net.javaguides.sms.repository.CourseRepository;
import net.javaguides.sms.repository.EnrollmentRepository;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private EnrollmentRepository enrollmentRepository;


    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	studentRepository.save(new Student(
    				null,
    				"Nam",
    				"Tran",
    				"namtran@gmail.com",
    				"12345678",
    				false
    			));
    	studentRepository.save(new Student(
				null,
				"My",
				"Tran Tra",
				"ttmy@gmail.com",
				"12345678",
				false
			));
    	studentRepository.save(new Student(
				null,
				"Le",
				"Minh Hong",
				"lmh@gmail.com",
				"12345678",
				false
			));
    	
    	teacherRepository.save(new Teacher(
    			null, 
    			"Quan", 
    			"quandd", 
    			"12345678", 
    			false));
    	teacherRepository.save(new Teacher(
    			null, 
    			"Hung", 
    			"hungnq", 
    			"12345678", 
    			false));
    	teacherRepository.save(new Teacher(
    			null, 
    			"Vi", 
    			"vinv", 
    			"12345678", 
    			false));
    	
    	courseRepository.save(new Course(
    				null,
    				"SE2",
    				1L,
    				"Software engineering course",
    				1,
    				"FIT2022#SE2"
    			));
    	courseRepository.save(new Course(
				null,
				"REQ",
				2L,
				"Software requirement course",
				1,
				"FIT2022#REQ"
			));
    	courseRepository.save(new Course(
				null,
				"DSA",
				3L,
				"Data structure and algorithm course",
				2,
				"FIT2022#DSA"
			));
    	
    	enrollmentRepository.save(new Enrollment(
    				1L,
    				2L
    			));
    	enrollmentRepository.save(new Enrollment(
				2L,
				3L
			));
    	enrollmentRepository.save(new Enrollment(
				3L,
				1L
			));
    }

}
