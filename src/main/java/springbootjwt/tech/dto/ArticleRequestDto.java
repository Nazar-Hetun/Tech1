package springbootjwt.tech.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArticleRequestDto {
    @NotBlank
    private String text;
    @NotBlank
    private String color;
}
