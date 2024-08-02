package tech.ledem.jpa.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int price;
    @OneToMany(cascade = CascadeType.ALL)//un produit peut avoir plusieurs sentiments

    private List<Sentiment> sentiments;
}
