package se2.group2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

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
	@Transient
	public boolean enrolled = false;
	
	
	
	public Course() {
		super();
	}

	public Course(Long id, String name, Long teacherId, String desc, int semester, String enrollKey) {
		super();
		this.id = id;
		this.name = name;
		this.teacherId = teacherId;
		this.desc = desc;
		this.semester = semester;
		this.enrollKey = enrollKey;
	}
	
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
