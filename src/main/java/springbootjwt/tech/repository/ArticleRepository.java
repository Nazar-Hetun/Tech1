package springbootjwt.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootjwt.tech.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
