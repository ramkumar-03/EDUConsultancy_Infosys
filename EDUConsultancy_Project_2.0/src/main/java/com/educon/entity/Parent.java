package com.educon.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parent_id", length = 11)
    private int parentid;

    @Column(name = "parent_name", length = 45, nullable = false)
    private String parentname;

    @Column(name = "phone", length = 12, nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false, unique = true)
    private Student student;

    public Parent(){
    }

    public Parent(String parentname, String phone, Student student) {
        this.parentname = parentname;
        this.phone = phone;
        this.student = student;
    }

    public int getId(){
        return this.parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStudent(Student student) {
        this.student=student;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "parentid=" + parentid +
                ", parentname='" + parentname + '\'' +
                ", phone='" + phone + '\'' +
                ", student=" + student +
                '}';
    }


}
