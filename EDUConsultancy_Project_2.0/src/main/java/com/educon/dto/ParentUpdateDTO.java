package com.educon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ParentUpdateDTO {
    private int parentid;
    private String parentname;
    private String phone;
    private int studentid; // Updated reference to the Student ID if needed
}
