package springbootjwt.tech.security;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springbootjwt.tech.model.Role;
import springbootjwt.tech.model.User;
import springbootjwt.tech.service.UserService;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByLogin(login);

        if (userOptional.isPresent()) {
            org.springframework.security.core.userdetails.User.UserBuilder builder
                    = org.springframework.security
                    .core.userdetails.User.withUsername(login);
            builder.password(userOptional.get().getPassword());
            builder.roles(userOptional.get().getRoles()
                    .stream()
                    .map(Role::getName)
                    .toArray(String[]::new));
            return builder.build();
        }
        throw new UsernameNotFoundException("User with login " + login + " not found.");
    }
}
