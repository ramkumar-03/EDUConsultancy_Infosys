package com.educon.dto;

import com.educon.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchDTO {

    private int batchid;
    private String batchname;
    private Course course;
    private String startdate;

}