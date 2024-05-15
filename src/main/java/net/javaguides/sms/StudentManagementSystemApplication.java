package net.javaguides.sms;

import net.javaguides.sms.entity.Account;
import net.javaguides.sms.repository.AccountRepository;
import net.javaguides.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

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
        studentAccount.setPassword("student");

        Account teacherAccount = new Account();
        teacherAccount.setUsername("teacher");
        teacherAccount.setPassword("teacher");

        accountRepository.save(adminAccount);
        accountRepository.save(studentAccount);
        accountRepository.save(teacherAccount);



    }

}
