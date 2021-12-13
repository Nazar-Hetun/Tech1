package spring_boot_jwt.tech1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_jwt.tech1.dto.ArticleRequestDto;
import spring_boot_jwt.tech1.dto.ArticleResponseDto;
import spring_boot_jwt.tech1.mapper.ArticleMapper;
import spring_boot_jwt.tech1.model.Article;
import spring_boot_jwt.tech1.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    public ArticleController(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @PostMapping
    public ArticleResponseDto add(ArticleRequestDto articleRequestDto) {
        Article article = articleMapper.mapToModel(articleRequestDto);
        articleService.save(article);
        return articleMapper.mapToDto(article);
    }
}
