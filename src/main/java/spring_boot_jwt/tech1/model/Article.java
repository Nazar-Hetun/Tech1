package spring_boot_jwt.tech1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Color color;



    public enum Color {
        BLACK("black"),
        WHITE("white"),
        GREEN("green"),
        BLUE("blue"),
        RED("red");

        private final String name;

        Color(String name) {
            this.name = name;
        }

        public static Color getColorByName(String name) {
            for (Color color : values()) {
                if (color.name.equals(name)) {
                    return color;
                }
            }
            return null;
        }

    }
}
