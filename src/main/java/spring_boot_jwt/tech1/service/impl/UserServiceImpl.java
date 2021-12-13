package spring_boot_jwt.tech1.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring_boot_jwt.tech1.model.Article;
import spring_boot_jwt.tech1.model.User;
import spring_boot_jwt.tech1.repository.UserRepository;
import spring_boot_jwt.tech1.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsersWithAgeGreaterThen(Integer age) {
        return userRepository.findAllByAgeGreaterThan(age);
    }

    @Override
    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllWhereArticleColorEquals(Article.Color color) {
        return userRepository.findAllWhereArticleColorEquals(color);
    }

    @Override
    public List<User> findAllNamesWhereArticlesGreaterThenThree() {
        return userRepository.findAllNamesWhereArticlesGreaterThenThree();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
