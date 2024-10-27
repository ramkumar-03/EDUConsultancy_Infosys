package com.educon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;  // Add this import
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", length = 11)
    private int studentid;

    @Column(name = "student_name", length = 45)
    private String studentname;

    @Column(name = "address", length = 60)
    private String address;

    @Column(name = "phone", length = 12)
    private String phone;

    @OneToMany(mappedBy = "student")
    @JsonIgnore  // Prevent serialization of this field
    private Set<Enrollment> enrollments;

    public Student() {
    }

    public Student(int studentid, String studentname, String address, String phone) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.address = address;
        this.phone = phone;
    }

    public Student(String studentname, String address, String phone) {
        this.studentname = studentname;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return this.studentid; // Replace 'studentId' with your actual field name
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", studentname='" + studentname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
