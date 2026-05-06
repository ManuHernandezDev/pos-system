package com.manuel.pos.controller;

import com.manuel.pos.dto.response.UserResponseDTO;
import com.manuel.pos.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    void shouldReturnUserById() throws Exception {
        //when(userService.getUserById(1L)).thenReturn(new UserResponseDTO());
        //mockMvc.perform(get("/users/1"))
          //      .andExpect(status().isOk());
    }

}
