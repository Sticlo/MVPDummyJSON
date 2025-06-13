package com.example.mvpdummyjson;

import com.example.mvpdummyjson.client.DummyJsonClient;
import com.example.mvpdummyjson.dto.LoginRequest;
import com.example.mvpdummyjson.dto.LoginResponse;
import com.example.mvpdummyjson.dto.UserResponse;
import com.example.mvpdummyjson.entity.LoginLog;
import com.example.mvpdummyjson.repository.LoginLogRepository;
import com.example.mvpdummyjson.service.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AuthServiceTest {

    @Test
    void loginStoresLog() {
        DummyJsonClient client = mock(DummyJsonClient.class);
        LoginLogRepository repository = mock(LoginLogRepository.class);
        AuthService service = new AuthService(client, repository);

        LoginRequest request = new LoginRequest();
        request.setUsername("test");
        request.setPassword("pass");

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setAccessToken("a1");
        loginResponse.setRefreshToken("r1");

        UserResponse user = new UserResponse();
        user.setId(1);
        user.setUsername("test");

        when(client.login(any())).thenReturn(loginResponse);
        when(client.me(anyString())).thenReturn(user);

        UserResponse result = service.loginAndFetchMe(request);
        assertEquals(user, result);

        ArgumentCaptor<LoginLog> captor = ArgumentCaptor.forClass(LoginLog.class);
        verify(repository).save(captor.capture());
        assertEquals("test", captor.getValue().getUsername());
    }
}
