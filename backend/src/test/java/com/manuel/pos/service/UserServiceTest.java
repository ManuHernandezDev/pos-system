package com.manuel.pos.service;

import com.manuel.pos.entity.User;
import com.manuel.pos.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ShouldReturnUserById(){
        User user = new User();
        user.setId(1L);
        user.setName("Manu");

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        var result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals("Manu", result.getName());
    }
    @Test
    void shouldThrowExceptionWhenUserNotFound(){
        when(userRepository.findById(1L))
                .thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> {
            userService.getUserById(1L);
        });
    }

}
