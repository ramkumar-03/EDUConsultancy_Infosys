package com.educon.service;

import com.educon.dto.EnrollmentDTO;
import com.educon.dto.EnrollmentSaveDTO;
import com.educon.dto.EnrollmentUpdateDTO;

import java.util.List;

public interface EnrollmentService {
    String addEnrollment(EnrollmentSaveDTO entrollmentSaveDTO);

    List<EnrollmentDTO> getAllEnrollments();

    String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO);

    boolean deleteEnrollment(int id);
}