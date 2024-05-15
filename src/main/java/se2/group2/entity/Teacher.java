package se2.group2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "username")
    public String username;
    @Column(name = "password")
    public String password;

    @Column(name = "is_disabled")
    public boolean isDisabled;

    public Teacher() {}

    public Teacher(Long id, String name, String username, String password, boolean isDisabled) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.isDisabled = isDisabled;
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

    public boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(boolean disabled) {
        isDisabled = disabled;
    }
}
