package se2.group2;

import se2.group2.entity.Account;
import se2.group2.repository.AccountRepository;
import se2.group2.entity.Course;
import se2.group2.entity.Enrollment;
import se2.group2.entity.Student;
import se2.group2.entity.Teacher;
import se2.group2.repository.CourseRepository;
import se2.group2.repository.EnrollmentRepository;
import se2.group2.repository.StudentRepository;
import se2.group2.repository.TeacherRepository;
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


    @Autowired
    private AccountRepository accountRepository;


    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



        Account adminAccount = new Account();
        adminAccount.setUsername("admin");
        adminAccount.setPassword("admin");

        Account studentAccount = new Account();
        studentAccount.setUsername("student");
        studentAccount.setStudentId(1L);
        studentAccount.setPassword("student");

        Account teacherAccount = new Account();
        teacherAccount.setUsername("teacher");
        teacherAccount.setPassword("teacher");

        accountRepository.save(adminAccount);
        accountRepository.save(studentAccount);
        accountRepository.save(teacherAccount);




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
