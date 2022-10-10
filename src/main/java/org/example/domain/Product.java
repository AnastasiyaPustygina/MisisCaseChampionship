package org.example.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
@EqualsAndHashCode(exclude = {"id", "image"})
@NamedEntityGraph(name = "product-entity-graph", attributeNodes = @NamedAttributeNode("image"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "calories_number", nullable = false)
    private int caloriesNumber;

    @Column(name = "glycemic_index", nullable = false)
    private int glycemicIndex;

    @Column(name = "protein_number", nullable = false)
    private int protein;

    @Column(name = "fat_number", nullable = false)
    private int fat;

    @Column(name = "carbohydrate_number", nullable = false)
    private int carbohydrate;

    //картинка у продукта обязательна!
    @OneToOne(targetEntity = Image.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;

    @Override
    public String toString() {
        return "\n Product with id = " + id + ":" + "\n" +
                " name = " + name + '\n' +
                " caloriesNumber = " + caloriesNumber + "\n" +
                " glycemicIndex = " + glycemicIndex + "\n" +
                " protein = " + protein + "\n" +
                " fat = " + fat + "\n" +
                " carbohydrate = " + carbohydrate + "\n";
    }

}
