package com.educon.service.IMPL;

import com.educon.dto.ParentDTO;
import com.educon.dto.ParentSaveDTO;
import com.educon.dto.ParentUpdateDTO;
import com.educon.entity.Parent;
import com.educon.entity.Student;
import com.educon.repo.ParentRepo;
import com.educon.repo.StudentRepo;
import com.educon.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentServiceIMPL implements ParentService {

    @Autowired
    private ParentRepo parentRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String addParent(ParentSaveDTO parentSaveDTO) {
        Student student = studentRepo.getById(parentSaveDTO.getStudentid());

        Parent parent = new Parent(
                parentSaveDTO.getParentname(),
                parentSaveDTO.getPhone(),
                student
        );

        parentRepo.save(parent);
        return parent.getParentname();
    }

    @Override
    public List<ParentDTO> getAllParents() {
        List<Parent> parents = parentRepo.findAll();
        List<ParentDTO> parentDTOList = new ArrayList<>();

        for (Parent parent : parents) {
            ParentDTO parentDTO = new ParentDTO(
                    parent.getParentid(),
                    parent.getParentname(),
                    parent.getPhone(),
                    parent.getStudent().getStudentid()
            );
            parentDTOList.add(parentDTO);
        }

        return parentDTOList;
    }

    @Override
    public String updateParent(ParentUpdateDTO parentUpdateDTO) {
        Parent parent = parentRepo.getById(parentUpdateDTO.getParentid());
        parent.setParentname(parentUpdateDTO.getParentname());
        parent.setPhone(parentUpdateDTO.getPhone());

        Student student = studentRepo.getById(parentUpdateDTO.getStudentid());
        parent.setStudent(student);

        parentRepo.save(parent);
        return parent.getParentname();
    }

    @Override
    public boolean deleteParent(int id) {
        if (parentRepo.existsById(id)) {
            parentRepo.deleteById(id);
            return true;
        } else {
            System.out.println("Parent ID Not Found");
            return false;
        }
    }
}
