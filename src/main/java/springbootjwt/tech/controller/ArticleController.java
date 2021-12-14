package springbootjwt.tech.controller;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootjwt.tech.dto.ArticleRequestDto;
import springbootjwt.tech.dto.ArticleResponseDto;
import springbootjwt.tech.mapper.ArticleMapper;
import springbootjwt.tech.model.Article;
import springbootjwt.tech.service.ArticleService;

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
    public ArticleResponseDto add(@RequestBody @Valid ArticleRequestDto articleRequestDto) {
        Article article = articleMapper.mapToModel(articleRequestDto);
        articleService.save(article);
        return articleMapper.mapToDto(article);
    }
}
