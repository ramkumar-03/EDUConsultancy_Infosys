package com.educon.service;

import com.educon.dto.UserDTO;
import com.educon.dto.UserSaveDTO;
import com.educon.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUsers();

    String updateUser(UserUpdateDTO userUpdateDTO);

    boolean deleteUser(int id);
}
