package com.manuel.pos.service;

import com.manuel.pos.dto.request.UserRequestDTO;
import com.manuel.pos.dto.response.UserResponseDTO;
import com.manuel.pos.entity.Role;
import com.manuel.pos.entity.User;
import com.manuel.pos.repository.RoleRepository;
import com.manuel.pos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO){
        Role role = roleRepository.findById(userRequestDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(role);
        User saved = userRepository.save(user);

        return toResponse(user);
    }

    public UserResponseDTO toResponse(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        return userResponseDTO;
    }
}
