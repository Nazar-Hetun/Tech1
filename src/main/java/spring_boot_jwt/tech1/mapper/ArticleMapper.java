package spring_boot_jwt.tech1.mapper;

import org.springframework.stereotype.Component;
import spring_boot_jwt.tech1.dto.ArticleRequestDto;
import spring_boot_jwt.tech1.dto.ArticleResponseDto;
import spring_boot_jwt.tech1.model.Article;

@Component
public class ArticleMapper implements RequestDtoMapper<ArticleRequestDto, Article>,
        ResponseDtoMapper<ArticleResponseDto, Article>{

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
        articleResponseDto.setColor(article.getColor().name());
        articleResponseDto.setText(article.getText());
        return articleResponseDto;
    }
}
