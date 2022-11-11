package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> listAllUsers();

    UserDTO findByUserName(String username);
//    why username instead of primary key?
//    bcz when we updated user/ we pass based on username
    void save(UserDTO user);

    void deleteByUserName(String username);

    UserDTO update(UserDTO user);

    void delete(String username);

    List<UserDTO>listAllByRole(String role);
}
