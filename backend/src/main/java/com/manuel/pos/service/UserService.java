package com.manuel.pos.service;

import com.manuel.pos.dto.request.UserRequestDTO;
import com.manuel.pos.dto.response.UserResponseDTO;
import com.manuel.pos.entity.Role;
import com.manuel.pos.entity.User;
import com.manuel.pos.exception.ResourceNotFoundException;
import com.manuel.pos.mapper.UserMapper;
import com.manuel.pos.repository.RoleRepository;
import com.manuel.pos.repository.UserRepository;
import com.manuel.pos.config.SecurityConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDTO> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO){
        Role role = roleRepository.findById(userRequestDTO.getRoleId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        user.setRole(role);
        User saved = userRepository.save(user);

        return UserMapper.toResponse(user);
    }
}
