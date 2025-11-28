package com.example.desafio.service.authentication.login.user;

import com.example.desafio.dto.request.authentication.UserLoginDto;
import com.example.desafio.service.authentication.implementations.CustomUserDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LoginUserServiceTest {
    @Mock
    private AuthenticationManager authenticationManager;

    private LoginUserService loginUserService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        loginUserService=new LoginUserService(authenticationManager);
    }

    @Test
    void loginUserSuccess(){
        UserLoginDto userLoginDto=new UserLoginDto("teste@gmail.com","teste123");
        CustomUserDetails customUserDetails=mock(CustomUserDetails.class);
        when(customUserDetails.getEmail()).thenReturn("teste@gmail.com");

        Authentication authMock=mock(Authentication.class);
        when(authMock.getPrincipal()).thenReturn(customUserDetails);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authMock);

        CustomUserDetails result=loginUserService.loginUser(userLoginDto);

        assertNotNull(result);
        assertEquals("teste@gmail.com",result.getEmail());

        verify(authenticationManager,times(1))
                .authenticate(any(UsernamePasswordAuthenticationToken.class));
    }

    @Test
    void loginUserFailurePerEmailError(){
       UserLoginDto userLoginDto=new UserLoginDto("emailError","12345");

       when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).
               thenThrow(new BadCredentialsException("user not found"));

       assertThrows(BadCredentialsException.class,()->loginUserService.loginUser(userLoginDto));
    }

    @Test
    void loginUserFailurePerPasswordError(){
        UserLoginDto userLoginDto=new UserLoginDto("teste@gmail.com","passwordError");
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new BadCredentialsException("password error"));

        assertThrows(BadCredentialsException.class,()->loginUserService.loginUser(userLoginDto));
    }
}