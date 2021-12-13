package spring_boot_jwt.tech1.service.impl;

import org.springframework.stereotype.Service;
import spring_boot_jwt.tech1.model.Article;
import spring_boot_jwt.tech1.repository.ArticleRepository;
import spring_boot_jwt.tech1.service.ArticleService;

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
