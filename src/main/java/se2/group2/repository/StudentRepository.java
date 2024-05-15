package se2.group2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se2.group2.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
