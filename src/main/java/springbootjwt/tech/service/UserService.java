package springbootjwt.tech.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import springbootjwt.tech.model.Article;
import springbootjwt.tech.model.User;

public interface UserService {
    List<User> getAllUsersWithAgeGreaterThen(Integer age);

    User add(User user);

    List<User> findAllWhereArticleColorEquals(Article.Color color);

    Set<String> findAllNamesWhereArticlesGreaterThenThree();

    Optional<User> findByLogin(String login);
}
