package net.javaguides.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.entity.Enrollment;
import net.javaguides.sms.entity.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	List<Enrollment> findByStudentId(Long studentId);
}
