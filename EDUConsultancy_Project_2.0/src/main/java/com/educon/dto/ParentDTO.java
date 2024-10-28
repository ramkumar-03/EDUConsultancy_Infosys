package com.educon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParentDTO {
    private int parentid;
    private String parentname;
    private String phone;
    private int studentId; // Reference to the associated Student ID
}
