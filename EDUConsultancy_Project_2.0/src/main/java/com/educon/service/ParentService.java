package com.educon.service;

import com.educon.dto.ParentDTO;
import com.educon.dto.ParentSaveDTO;
import com.educon.dto.ParentUpdateDTO;

import java.util.List;

public interface ParentService {
    String addParent(ParentSaveDTO parentSaveDTO);

    List<ParentDTO> getAllParents();

    String updateParent(ParentUpdateDTO parentUpdateDTO);

    boolean deleteParent(int id);
}
