package springbootjwt.tech.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import springbootjwt.tech.dto.UserRequestDto;
import springbootjwt.tech.dto.UserResponseDto;
import springbootjwt.tech.model.User;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User>,
        RequestDtoMapper<UserRequestDto, User> {
    private final ArticleMapper articleMapper;

    public UserMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public User mapToModel(UserRequestDto dto) {
        User user = new User();
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setArticles(dto.getArticles().stream()
                .map(articleMapper::mapToModel)
                .collect(Collectors.toList()));
        return user;
    }

    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setArticles(user.getArticles().stream()
                .map(articleMapper::mapToDto)
                .collect(Collectors.toList()));
        return userResponseDto;
    }
}
