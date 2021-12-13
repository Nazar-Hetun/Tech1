package spring_boot_jwt.tech1.dto;

import lombok.Data;

@Data
public class ArticleRequestDto {
    private String text;
    private String color;
}
