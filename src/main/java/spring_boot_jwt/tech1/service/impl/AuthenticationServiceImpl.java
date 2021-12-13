package spring_boot_jwt.tech1.service.impl;

import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_boot_jwt.tech1.dto.UserRequestDto;
import spring_boot_jwt.tech1.mapper.ArticleMapper;
import spring_boot_jwt.tech1.model.Role;
import spring_boot_jwt.tech1.model.User;
import spring_boot_jwt.tech1.service.AuthenticationService;
import spring_boot_jwt.tech1.service.RoleService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final ArticleMapper articleMapper;
    private final RoleService roleService;


    @Override
    public User register(UserRequestDto userRequestDto) {
        User user = new User();
        user.setLogin(userRequestDto.getLogin());
        user.setPassword(userRequestDto.getPassword());
        user.setName(userRequestDto.getName());
        user.setAge(userRequestDto.getAge());
        user.setArticles(userRequestDto.getArticles().stream()
                .map(articleMapper::mapToModel)
                .collect(Collectors.toList()));
        Role userRole = roleService.getRoleByName("USER");
        user.setRoles(Set.of(userRole));
        return user;
    }
}
