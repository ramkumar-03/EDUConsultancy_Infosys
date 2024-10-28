package com.educon.controller;

import com.educon.dto.ParentDTO;
import com.educon.dto.ParentSaveDTO;
import com.educon.dto.ParentUpdateDTO;
import com.educon.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping(path = "/save")
    public String saveParent(@RequestBody ParentSaveDTO parentSaveDTO) {
        String parentName = parentService.addParent(parentSaveDTO);
        return "Parent saved: " + parentName;
    }

    @GetMapping("/getAllParents")
    public List<ParentDTO> getAllParents() {
        return parentService.getAllParents();
    }

    @PutMapping(path = "/update")
    public String updateParent(@RequestBody ParentUpdateDTO parentUpdateDTO) {
        String parentName = parentService.updateParent(parentUpdateDTO);
        return "Parent updated: " + parentName;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteParent(@PathVariable(value = "id") int id) {
        boolean isDeleted = parentService.deleteParent(id);
        return isDeleted ? "Parent deleted!" : "Parent not found!";
    }
}
