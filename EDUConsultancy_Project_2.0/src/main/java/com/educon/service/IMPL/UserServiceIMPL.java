package com.educon.service.IMPL;

import com.educon.dto.UserDTO;
import com.educon.dto.UserSaveDTO;
import com.educon.dto.UserUpdateDTO;
import com.educon.entity.User;
import com.educon.repo.UserRepo;
import com.educon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public String addUser(UserSaveDTO userSaveDTO) {
        User user = new User(
                userSaveDTO.getUsername(),
                userSaveDTO.getEmail(),
                userSaveDTO.getPassword(),
                userSaveDTO.getUsertype()
        );

        userRepo.save(user);

        return user.getUsername();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = new UserDTO(
                    user.getUserid(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getUsertype()
            );
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO) {
        if (userRepo.existsById(userUpdateDTO.getUserid())) {
            User user = userRepo.findById(userUpdateDTO.getUserid()).orElse(null);

            if (user != null) {
                user.setUsername(userUpdateDTO.getUsername());
                user.setEmail(userUpdateDTO.getEmail());
                user.setPassword(userUpdateDTO.getPassword());
                user.setUsertype(userUpdateDTO.getUsertype());

                userRepo.save(user);
                return user.getUsername();
            }
        }

        System.out.println("User ID not found");
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        } else {
            System.out.println("User ID not found");
            return false;
        }
    }
}
