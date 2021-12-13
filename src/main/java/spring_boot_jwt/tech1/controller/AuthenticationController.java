package spring_boot_jwt.tech1.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_jwt.tech1.dto.UserRequestDto;
import spring_boot_jwt.tech1.dto.UserResponseDto;
import spring_boot_jwt.tech1.mapper.UserMapper;
import spring_boot_jwt.tech1.model.Article;
import spring_boot_jwt.tech1.model.User;
import spring_boot_jwt.tech1.service.ArticleService;
import spring_boot_jwt.tech1.service.UserService;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final ArticleService articleService;

    @PostMapping("/register")
    public UserResponseDto add(@RequestBody UserRequestDto userRequestDto) {
        User user = userMapper.mapToModel(userRequestDto);
        List<Article> articles = user.getArticles();
        articles.forEach(articleService::save);
        userService.add(user);
        return userMapper.mapToDto(user);
    }

    @GetMapping("/")
    public String get() {
        return "Hello Nazar";
    }
}
