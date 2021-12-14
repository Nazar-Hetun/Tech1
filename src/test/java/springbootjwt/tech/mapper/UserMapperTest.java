package springbootjwt.tech.mapper;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import springbootjwt.tech.dto.ArticleRequestDto;
import springbootjwt.tech.dto.ArticleResponseDto;
import springbootjwt.tech.dto.UserRequestDto;
import springbootjwt.tech.dto.UserResponseDto;
import springbootjwt.tech.model.Article;
import springbootjwt.tech.model.User;

class UserMapperTest {
    private UserMapper userMapper;
    private ArticleMapper articleMapper;
    private static final Long ID = 1L;
    private static final Integer AGE = 20;
    private static final String LOGIN = "nazar";
    private static final String PASSWORD = "nqwerty";
    private static final String NAME = "Nazar";
    private static final String TEXT1 = "a";
    private static final String TEXT2 = "b";
    private static final String COLOR_GREEN = "green";
    private static final String COLOR_BLACK = "black";

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void setUp() {
        articleMapper = Mockito.mock(ArticleMapper.class);
        userMapper = new UserMapper(articleMapper);
    }

    @Test
    void mapToModel_Ok() {
        Article article1 = new Article();
        article1.setText(TEXT1);
        article1.setColor(Article.Color.GREEN);

        Article article2 = new Article();
        article2.setText(TEXT2);
        article2.setColor(Article.Color.BLACK);

        List<Article> articles = List.of(article1, article2);

        ArticleRequestDto articleRequestDto1 = new ArticleRequestDto();
        articleRequestDto1.setText(TEXT1);
        articleRequestDto1.setColor(COLOR_GREEN);

        ArticleRequestDto articleRequestDto2 = new ArticleRequestDto();
        articleRequestDto2.setText(TEXT2);
        articleRequestDto2.setColor(COLOR_BLACK);

        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setLogin(LOGIN);
        userRequestDto.setPassword(PASSWORD);
        userRequestDto.setName(NAME);
        userRequestDto.setAge(AGE);
        userRequestDto.setArticles(List.of(articleRequestDto1, articleRequestDto2));

        Mockito.when(articleMapper.mapToModel(any())).thenReturn(article1).thenReturn(article2);

        User user = userMapper.mapToModel(userRequestDto);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getLogin(), LOGIN);
        Assertions.assertEquals(user.getPassword(), PASSWORD);
        Assertions.assertEquals(user.getName(), NAME);
        Assertions.assertEquals(user.getAge(), AGE);
        Assertions.assertEquals(user.getArticles(), articles);
    }

    @Test
    void mapToDto() {
        Article article1 = new Article();
        article1.setText(TEXT1);
        article1.setColor(Article.Color.GREEN);

        Article article2 = new Article();
        article2.setText(TEXT2);
        article2.setColor(Article.Color.BLACK);

        ArticleResponseDto articleResponseDto1 = new ArticleResponseDto();
        articleResponseDto1.setText(TEXT1);
        articleResponseDto1.setColor(COLOR_GREEN);

        ArticleResponseDto articleResponseDto2 = new ArticleResponseDto();
        articleResponseDto2.setText(TEXT2);
        articleResponseDto2.setColor(COLOR_BLACK);

        List<ArticleResponseDto> articles = List.of(articleResponseDto1, articleResponseDto2);

        User user = new User();
        user.setId(ID);
        user.setName(NAME);
        user.setAge(AGE);
        user.setArticles(List.of(article1, article2));
        user.setLogin(LOGIN);
        user.setPassword(PASSWORD);

        Mockito.when(articleMapper.mapToDto(any()))
                .thenReturn(articleResponseDto1)
                .thenReturn(articleResponseDto2);

        UserResponseDto userResponseDto = userMapper.mapToDto(user);
        Assertions.assertNotNull(userResponseDto);
        Assertions.assertEquals(userResponseDto.getId(), ID);
        Assertions.assertEquals(userResponseDto.getName(), NAME);
        Assertions.assertEquals(userResponseDto.getAge(), AGE);
        Assertions.assertEquals(userResponseDto.getArticles(), articles);
    }
}