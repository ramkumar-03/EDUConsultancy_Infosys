package com.educon.dto;

import com.educon.entity.User.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDTO {
    private int userid;
    private String username;
    private String email;
    private String password;
    private UserType usertype;
}
