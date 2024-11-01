package com.educon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", length = 11)
    private int userid;

    @Column(name = "username", length = 45, nullable = false, unique = true)
    private String username;

    @Column(name = "email", length = 60, nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", length = 10, nullable = false)
    private UserType usertype;

    public User() {
    }

    public User(int userid,String username, String email, String password, UserType usertype) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
    }

    public User(String username, String email, String password, UserType usertype) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
    }

    public int getId() {
        return this.userid; // Replace 'studentId' with your actual field name
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public void setUsertype(String Usertype) {
        this.usertype = usertype;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", usertype=" + usertype +
                '}';
    }

    // Enum for UserType
    public enum UserType {
        STUDENT, PARENT, TEACHER, ADMIN
    }
}
