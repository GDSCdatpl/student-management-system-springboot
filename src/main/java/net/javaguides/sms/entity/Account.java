package net.javaguides.sms.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long studentId;
    public String username;
    public String password;


    public Account() {

    }


    public Account(Long id, Long studentId, String username, String password) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.username = username;
		this.password = password;
	}

	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public void setId(Long id) {
		this.id = id;
	}




	public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
