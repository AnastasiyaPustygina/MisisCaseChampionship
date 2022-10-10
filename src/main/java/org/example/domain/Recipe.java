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
@Table(name = "recipe")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "recipe-entity-graph", attributeNodes = {@NamedAttributeNode("dish")})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text")
    private String text;

    @OneToOne(targetEntity = Dish.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", unique = true, nullable = false)
    private Dish dish;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "person_recipe", joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> person;

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", dish=" + dish +
                '}';
    }
}
