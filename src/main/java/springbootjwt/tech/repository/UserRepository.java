package springbootjwt.tech.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springbootjwt.tech.model.Article;
import springbootjwt.tech.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAgeGreaterThan(Integer age);

    @Query("select u from User u join u.articles a group by u having count (a) > 3")
    List<User> findAllNamesWhereArticlesGreaterThenThree();

    @Query("select distinct u from User u join u.articles a where a.color = ?1")
    List<User> findAllWhereArticleColorEquals(Article.Color color);

    @Query("select u from User u "
            + "LEFT JOIN FETCH u.articles "
            + "LEFT JOIN FETCH u.roles WHERE u.login = ?1")
    Optional<User> findByLogin(String login);
}
