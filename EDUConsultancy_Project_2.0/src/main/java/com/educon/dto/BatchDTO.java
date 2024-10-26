package com.educon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchDTO {

    private int batchid;
    private String batchname;
    private int courseId;        // Only the ID of the course
    private String courseName;   // Only the name of the course
    private String startdate;

}
