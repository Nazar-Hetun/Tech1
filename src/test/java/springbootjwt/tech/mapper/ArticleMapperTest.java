package springbootjwt.tech.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springbootjwt.tech.dto.ArticleRequestDto;
import springbootjwt.tech.dto.ArticleResponseDto;
import springbootjwt.tech.model.Article;

class ArticleMapperTest {
    private ArticleMapper articleMapper;
    private static final Long ID = 1L;
    private static final String TEXT = "a";
    private static final String COLOR = "red";

    @BeforeEach
    void setUp() {
        articleMapper = new ArticleMapper();
    }

    @Test
    void mapToModel_Ok() {
        ArticleRequestDto articleRequestDto = new ArticleRequestDto();
        articleRequestDto.setColor(COLOR);
        articleRequestDto.setText(TEXT);

        Article article = articleMapper.mapToModel(articleRequestDto);
        Assertions.assertNotNull(article);
        Assertions.assertEquals(article.getColor().getName(), COLOR);
        Assertions.assertEquals(article.getText(), TEXT);
    }

    @Test
    void mapToDto_Ok() {
        Article article = new Article();
        article.setId(ID);
        article.setColor(Article.Color.RED);
        article.setText(TEXT);

        ArticleResponseDto articleResponseDto = articleMapper.mapToDto(article);
        Assertions.assertNotNull(articleResponseDto);
        Assertions.assertEquals(articleResponseDto.getColor(), COLOR);
        Assertions.assertEquals(articleResponseDto.getText(), TEXT);
    }
}