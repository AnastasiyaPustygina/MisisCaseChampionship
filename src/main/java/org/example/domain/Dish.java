package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedEntityGraph(name = "dish-entity-graph", attributeNodes = {@NamedAttributeNode("image"),
        @NamedAttributeNode("ingredient")})
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(targetEntity = Ingredient.class, mappedBy = "dish", fetch = FetchType.LAZY)
     List<Ingredient> ingredient;


    @ManyToMany(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinTable(name = "dish_category", joinColumns = @JoinColumn(name = "dish_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Category> category;

    //картинка у блюда обязательна!
    @OneToOne(targetEntity = Image.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredient=" + ingredient +
                ", image=" + image +
                '}';
    }
}
