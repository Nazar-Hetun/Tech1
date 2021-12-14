package springbootjwt.tech.mapper;

import org.springframework.stereotype.Component;
import springbootjwt.tech.dto.ArticleRequestDto;
import springbootjwt.tech.dto.ArticleResponseDto;
import springbootjwt.tech.model.Article;

@Component
public class ArticleMapper implements RequestDtoMapper<ArticleRequestDto, Article>,
        ResponseDtoMapper<ArticleResponseDto, Article> {

    @Override
    public Article mapToModel(ArticleRequestDto dto) {
        Article article = new Article();
        article.setColor(Article.Color.getColorByName(dto.getColor()));
        article.setText(dto.getText());
        return article;
    }

    @Override
    public ArticleResponseDto mapToDto(Article article) {
        ArticleResponseDto articleResponseDto = new ArticleResponseDto();
        articleResponseDto.setId(article.getId());
        articleResponseDto.setColor(article.getColor().getName());
        articleResponseDto.setText(article.getText());
        return articleResponseDto;
    }
}
