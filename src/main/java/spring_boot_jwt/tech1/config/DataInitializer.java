package spring_boot_jwt.tech1.config;

import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring_boot_jwt.tech1.model.Article;
import spring_boot_jwt.tech1.model.Role;
import spring_boot_jwt.tech1.model.User;
import spring_boot_jwt.tech1.service.ArticleService;
import spring_boot_jwt.tech1.service.RoleService;
import spring_boot_jwt.tech1.service.UserService;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final ArticleService articleService;
    private final UserService userService;
    private final RoleService roleService;

    @PostConstruct
    private void initialize() {
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName("USER");
        roleService.add(userRole);

        Article nazarArticle1 = new Article();
        nazarArticle1.setText("a");
        nazarArticle1.setColor(Article.Color.GREEN);
        articleService.save(nazarArticle1);

        Article nazarArticle2 = new Article();
        nazarArticle2.setText("b");
        nazarArticle2.setColor(Article.Color.BLACK);
        articleService.save(nazarArticle2);

        Article nazarArticle3 = new Article();
        nazarArticle3.setText("c");
        nazarArticle3.setColor(Article.Color.BLUE);
        articleService.save(nazarArticle3);

        Article nazarArticle4 = new Article();
        nazarArticle4.setText("d");
        nazarArticle4.setColor(Article.Color.RED);
        articleService.save(nazarArticle4);

        User nazar = new User();
        nazar.setName("Nazar");
        nazar.setAge(23);
        nazar.setArticles(List.of(nazarArticle1, nazarArticle2, nazarArticle3, nazarArticle4));
        nazar.setLogin("nazar");
        nazar.setPassword("nqwerty");
        userService.add(nazar);

        Article yuraArticle1 = new Article();
        yuraArticle1.setText("a");
        yuraArticle1.setColor(Article.Color.RED);
        articleService.save(yuraArticle1);

        Article yuraArticle2 = new Article();
        yuraArticle2.setText("b");
        yuraArticle2.setColor(Article.Color.BLACK);
        articleService.save(yuraArticle2);

        User yura = new User();
        yura.setName("Yura");
        yura.setAge(26);
        yura.setArticles(List.of(yuraArticle1, yuraArticle2));
        yura.setLogin("yura");
        yura.setPassword("yqwerty");
        userService.add(yura);

        Article carlArticle1 = new Article();
        carlArticle1.setText("a");
        carlArticle1.setColor(Article.Color.BLUE);
        articleService.save(carlArticle1);

        Article carlArticle2 = new Article();
        carlArticle2.setText("b");
        carlArticle2.setColor(Article.Color.BLACK);
        articleService.save(carlArticle2);

        User carl = new User();
        carl.setName("Carl");
        carl.setAge(33);
        carl.setArticles(List.of(carlArticle1, carlArticle2));
        carl.setLogin("carl");
        carl.setPassword("cqwerty");
        userService.add(carl);

        Article romanArticle1 = new Article();
        romanArticle1.setText("a");
        romanArticle1.setColor(Article.Color.GREEN);
        articleService.save(romanArticle1);

        User roman = new User();
        roman.setName("Roman");
        roman.setAge(21);
        roman.setArticles(List.of(romanArticle1));
        roman.setLogin("roman");
        roman.setPassword("rqwerty");
        userService.add(roman);

        Article victorArticle1 = new Article();
        victorArticle1.setText("a");
        victorArticle1.setColor(Article.Color.GREEN);
        articleService.save(victorArticle1);

        Article victorArticle2 = new Article();
        victorArticle2.setText("b");
        victorArticle2.setColor(Article.Color.GREEN);
        articleService.save(victorArticle2);

        Article victorArticle3 = new Article();
        victorArticle3.setText("c");
        victorArticle3.setColor(Article.Color.BLUE);
        articleService.save(victorArticle3);

        User viktor = new User();
        viktor.setName("Viktor");
        viktor.setAge(42);
        viktor.setArticles(List.of(victorArticle1, victorArticle2, victorArticle3));
        viktor.setLogin("victor");
        viktor.setPassword("vqwerty");
        userService.add(viktor);
    }
}

