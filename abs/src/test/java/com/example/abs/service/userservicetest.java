package com.example.abs.service;

import com.example.abs.entity.user;
import com.example.abs.repository.userrepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private userrepository userRepository;

    @InjectMocks
    private userservice userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        List<user> mockUsers = Arrays.asList(new user(), new user());
        when(userRepository.findAll()).thenReturn(mockUsers);
        assertEquals(2, userService.getAllUsers().size());
    }

    @Test
    void testCreateUser() {
        user u = new user();
        u.setName("Test User");
        when(userRepository.save(u)).thenReturn(u);
        assertEquals("Test User", userService.createUser(u).getName());
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }
}
