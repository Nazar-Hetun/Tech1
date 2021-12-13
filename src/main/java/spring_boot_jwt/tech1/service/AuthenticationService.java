package spring_boot_jwt.tech1.service;

import spring_boot_jwt.tech1.dto.UserRequestDto;
import spring_boot_jwt.tech1.model.User;

public interface AuthenticationService {
    User register(UserRequestDto userRequestDto);
}
