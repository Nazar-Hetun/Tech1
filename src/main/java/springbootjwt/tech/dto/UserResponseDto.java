package springbootjwt.tech.dto;

import java.util.List;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private Integer age;
    private List<ArticleResponseDto> articles;
}
