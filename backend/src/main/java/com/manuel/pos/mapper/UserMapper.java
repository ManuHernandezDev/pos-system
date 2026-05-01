package com.manuel.pos.mapper;

import com.manuel.pos.dto.response.UserResponseDTO;
import com.manuel.pos.entity.User;

public class UserMapper {
    public static UserResponseDTO toResponse(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        return userResponseDTO;
    }
}
