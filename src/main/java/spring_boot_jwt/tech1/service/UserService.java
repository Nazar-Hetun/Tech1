package spring_boot_jwt.tech1.service;

import java.util.List;
import java.util.Optional;
import spring_boot_jwt.tech1.model.Article;
import spring_boot_jwt.tech1.model.User;

public interface UserService {
    List<User> getAllUsersWithAgeGreaterThen(Integer age);

    User add(User user);

    List<User> findAllWhereArticleColorEquals(Article.Color color);

    List<User> findAllNamesWhereArticlesGreaterThenThree();

    Optional<User> findByLogin(String login);
}
