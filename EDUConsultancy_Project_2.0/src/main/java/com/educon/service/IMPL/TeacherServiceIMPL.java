package com.educon.service.IMPL;

import com.educon.dto.TeacherDTO;
import com.educon.dto.TeacherSaveDTO;
import com.educon.dto.TeacherUpdateDTO;
import com.educon.entity.Teacher;
import com.educon.repo.TeacherRepo;
import com.educon.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceIMPL implements TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;
    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {
        Teacher teacher = new Teacher(
                teacherSaveDTO.getTeachername(),
                teacherSaveDTO.getAddress(),
                teacherSaveDTO.getPhone()
        );
        teacherRepo.save(teacher);
        return teacher.getTeachername();
    }
    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> getTeachers = teacherRepo.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for(Teacher teacher:getTeachers)
        {
            TeacherDTO teacherDTO = new TeacherDTO(
                    teacher.getTeacherid(),
                    teacher.getTeachername(),
                    teacher.getAddress(),
                    teacher.getPhone()
            );
            teacherDTOList.add(teacherDTO);
        }
        return teacherDTOList;
    }
    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
        if(teacherRepo.existsById(teacherUpdateDTO.getTeacherid()))
        {
            Teacher teacher = teacherRepo.getById(teacherUpdateDTO.getTeacherid());
            teacher.setTeachername(teacherUpdateDTO.getTeachername());
            teacher.setAddress(teacherUpdateDTO.getAddress());
            teacher.setPhone(teacherUpdateDTO.getPhone());
            teacherRepo.save(teacher);
            return teacher.getTeachername();
        }
        else
        {
            System.out.println("Teacher ID Not Found");
        }
        return null;
    }
    @Override
    public boolean deleteTeacher(int id) {
        if(teacherRepo.existsById(id))
        {
            teacherRepo.deleteById(id);
        }
        else
        {
            System.out.println("Teacher ID Not Found");
        }
        return false;
    }
}
