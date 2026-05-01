package com.manuel.pos.service;

import com.manuel.pos.dto.request.UserRequestDTO;
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

    public User saveUser(UserRequestDTO userRequestDTO){
        Role role = roleRepository.findById(userRequestDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(role);

        return userRepository.save(user);
    }
}
