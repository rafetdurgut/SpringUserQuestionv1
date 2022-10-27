package com.example.springnewproject.service;

import com.example.springnewproject.dtos.UserDTO;
import com.example.springnewproject.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService  {

    UserDTO getUser(Long id);

    List<UserDTO> getAllUsers();

    UserDTO saveUser(UserDTO user);

    Map<String, Object> userListByPage(int offset, int size);
}
