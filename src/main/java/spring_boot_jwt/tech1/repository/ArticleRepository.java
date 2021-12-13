package spring_boot_jwt.tech1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot_jwt.tech1.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
