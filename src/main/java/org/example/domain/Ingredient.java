package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "weight", nullable = false)
    private int weight;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(targetEntity = Dish.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}
