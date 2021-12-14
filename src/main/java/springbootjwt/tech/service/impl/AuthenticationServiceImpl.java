package springbootjwt.tech.service.impl;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springbootjwt.tech.dto.UserRequestDto;
import springbootjwt.tech.exception.AuthenticationException;
import springbootjwt.tech.mapper.ArticleMapper;
import springbootjwt.tech.model.Role;
import springbootjwt.tech.model.User;
import springbootjwt.tech.service.AuthenticationService;
import springbootjwt.tech.service.RoleService;
import springbootjwt.tech.service.UserService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final ArticleMapper articleMapper;
    private final RoleService roleService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

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

    @Override
    public User login(String login, String password) throws AuthenticationException {
        Optional<User> user = userService.findByLogin(login);
        String encodedPassword = passwordEncoder.encode(password);
        if (user.isEmpty() || user.get().getPassword().equals(encodedPassword)) {
            throw new AuthenticationException("Incorrect username or password!");
        }
        return user.get();
    }
}
