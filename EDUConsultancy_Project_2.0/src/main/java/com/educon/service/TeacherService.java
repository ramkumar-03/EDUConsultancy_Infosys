package com.educon.service;

import com.educon.dto.TeacherDTO;
import com.educon.dto.TeacherSaveDTO;
import com.educon.dto.TeacherUpdateDTO;

import java.util.List;

public interface TeacherService {
    String addTeacher(TeacherSaveDTO teacherSaveDTO);

    List<TeacherDTO> getAllTeachers();

    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

    boolean deleteTeacher(int id);
}