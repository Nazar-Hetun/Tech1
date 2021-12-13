package spring_boot_jwt.tech1.dto;

import java.util.List;
import lombok.Data;

@Data
public class UserRequestDto {
    private String login;
    private String password;
    private String name;
    private Integer age;
    private List<ArticleRequestDto> articles;
}
