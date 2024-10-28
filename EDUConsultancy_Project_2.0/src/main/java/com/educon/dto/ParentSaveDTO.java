package com.educon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ParentSaveDTO {
    private String parentname;
    private String phone;
    private int studentid; // ID of the student this parent is associated with
}
