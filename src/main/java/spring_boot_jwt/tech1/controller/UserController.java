package spring_boot_jwt.tech1.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_jwt.tech1.dto.UserResponseDto;
import spring_boot_jwt.tech1.mapper.UserMapper;
import spring_boot_jwt.tech1.model.Article;
import spring_boot_jwt.tech1.model.User;
import spring_boot_jwt.tech1.service.UserService;

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
    public List<UserResponseDto> findAllNamesWhereArticlesGreaterThenThree() {
        List<User> users = userService.findAllNamesWhereArticlesGreaterThenThree();
        return users.stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }







}
