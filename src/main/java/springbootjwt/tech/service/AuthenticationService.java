package springbootjwt.tech.service;

import springbootjwt.tech.dto.UserRequestDto;
import springbootjwt.tech.exception.AuthenticationException;
import springbootjwt.tech.model.User;

public interface AuthenticationService {
    User register(UserRequestDto userRequestDto);

    User login(String login, String password) throws AuthenticationException;
}
