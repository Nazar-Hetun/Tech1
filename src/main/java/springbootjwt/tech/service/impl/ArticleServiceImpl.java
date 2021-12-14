package springbootjwt.tech.service.impl;

import org.springframework.stereotype.Service;
import springbootjwt.tech.model.Article;
import springbootjwt.tech.repository.ArticleRepository;
import springbootjwt.tech.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }
}
