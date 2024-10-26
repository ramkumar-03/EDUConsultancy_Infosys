package com.educon.service;

import com.educon.dto.BatchDTO;
import com.educon.dto.BatchSaveDTO;
import com.educon.dto.BatchUpdateDTO;

import java.util.List;

public interface BatchService {
    String addBatch(BatchSaveDTO batchSaveDTO);


    List<BatchDTO> getAllBatches();

    String updateBatch(BatchUpdateDTO batchUpdateDTO);

    boolean deleteBatch(int id);
}