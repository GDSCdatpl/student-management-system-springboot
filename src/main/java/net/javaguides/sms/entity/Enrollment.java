package net.javaguides.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollment {
	@Id
	public Long id;
	public Long studentId;
	public Long courseId;
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Enrollment(Long studentId, Long courseId) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
	}
	
	public Enrollment() {}
}
