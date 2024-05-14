package net.javaguides.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public Long teacherId;
	public String desc;
	public int semester;
	public String enrollKey;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getEnrollKey() {
		return enrollKey;
	}
	public void setEnrollKey(String enrollKey) {
		this.enrollKey = enrollKey;
	}
	
	
}
