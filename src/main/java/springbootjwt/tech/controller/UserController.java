package springbootjwt.tech.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springbootjwt.tech.dto.UserResponseDto;
import springbootjwt.tech.mapper.UserMapper;
import springbootjwt.tech.model.Article;
import springbootjwt.tech.model.User;
import springbootjwt.tech.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/by-age")
    public List<UserResponseDto> getAllUsersWithAgeGreaterThen(@RequestParam Integer age) {
        List<User> allUsersWithAgeGreaterThen = userService.getAllUsersWithAgeGreaterThen(age);
        return allUsersWithAgeGreaterThen.stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-color")
    public List<UserResponseDto> findAllWhereArticleColorEquals(@RequestParam String color) {
        List<User> allUsersWhereArticleColorEquals = userService
                .findAllWhereArticleColorEquals(Article.Color.valueOf(color));
        return allUsersWhereArticleColorEquals.stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/more-then-3-articles")
    public Set<String> findAllNamesWhereArticlesGreaterThenThree() {
        return userService.findAllNamesWhereArticlesGreaterThenThree();
    }
}
