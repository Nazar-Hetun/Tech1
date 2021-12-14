package springbootjwt.tech.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springbootjwt.tech.dto.UserLoginDto;
import springbootjwt.tech.dto.UserRequestDto;
import springbootjwt.tech.dto.UserResponseDto;
import springbootjwt.tech.exception.AuthenticationException;
import springbootjwt.tech.mapper.UserMapper;
import springbootjwt.tech.model.Article;
import springbootjwt.tech.model.Role;
import springbootjwt.tech.model.User;
import springbootjwt.tech.security.jwt.JwtTokenProvider;
import springbootjwt.tech.service.ArticleService;
import springbootjwt.tech.service.AuthenticationService;
import springbootjwt.tech.service.UserService;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final UserMapper userMapper;
    private final ArticleService articleService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public UserResponseDto add(@RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.mapToModel(userRequestDto);
        List<Article> articles = user.getArticles();
        articles.forEach(articleService::save);
        userService.add(user);
        return userMapper.mapToDto(user);
    }

    @GetMapping
    public String get() {
        return "Hello";
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserLoginDto userLoginDto)
            throws AuthenticationException {
        User user = authenticationService.login(userLoginDto.getLogin(),
                userLoginDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getLogin(),
                user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toList()));
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
