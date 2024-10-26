package com.educon.controller;

import com.educon.dto.TeacherDTO;
import com.educon.dto.TeacherSaveDTO;
import com.educon.dto.TeacherUpdateDTO;
import com.educon.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping(path = "/save")
    public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO)
    {
        String teachername = teacherService.addTeacher(teacherSaveDTO);
        return teachername;
    }

    @GetMapping("/getAllTeachers")
    public List<TeacherDTO> getAllTeachers()
    {
        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();
        return allTeachers;
    }


    @PutMapping(path = "/update")
    public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO)
    {
        String teachername = teacherService.updateTeacher(teacherUpdateDTO);
        return teachername;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteTeacher(@PathVariable(value = "id")int id)
    {
        boolean deleteTeacher = teacherService.deleteTeacher(id);
        return "Teacher deleted!";
    }

}