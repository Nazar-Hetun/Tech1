package springbootjwt.tech.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springbootjwt.tech.model.Article;
import springbootjwt.tech.model.User;
import springbootjwt.tech.repository.UserRepository;
import springbootjwt.tech.service.UserService;

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
    public Set<String> findAllNamesWhereArticlesGreaterThenThree() {
        return userRepository.findAllNamesWhereArticlesGreaterThenThree().stream()
                .map(User::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
