package com.example.springnewproject.service.serviceImp;

import com.example.springnewproject.dtos.UserDTO;
import com.example.springnewproject.model.User;
import com.example.springnewproject.repository.UserRepository;
import com.example.springnewproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO getUser(Long id) {
        User user = userRepository.getReferenceById(id);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream().map(user->modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
        return  userDTOS;
    }

    @Override
    public UserDTO saveUser(UserDTO user) {
        User u = modelMapper.map(user, User.class);
        u.setCreatedAt(LocalDateTime.now());
        userRepository.save(u);
        return  modelMapper.map(u, UserDTO.class);
    }

    @Override
    public Map<String, Object> userListByPage(int offset, int size) {
        Pageable page = PageRequest.of(offset, size);
        Page<User> userPage = userRepository.findAll(page);
        List<UserDTO> users = new ArrayList<UserDTO>();
        users = userPage.getContent().stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
        System.out.println(users);
        Map<String, Object> response = new HashMap<>();
        response.put("Users", users);
        response.put("currentPage", userPage.getNumber());
        response.put("totalItems", userPage.getTotalElements());
        response.put("totalPages", userPage.getTotalPages());
        return response;
    }
}
