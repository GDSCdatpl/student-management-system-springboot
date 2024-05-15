package se2.group2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se2.group2.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	List<Enrollment> findByStudentId(Long studentId);
	
	List<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId);
}
