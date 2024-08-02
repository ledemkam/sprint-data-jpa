package tech.ledem.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Sentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private Instant creation;
    @ManyToOne (cascade = CascadeType.ALL)//plusieurs sentiments peuvent être associés à un utilisateur
    @JoinColumn(name = "user_id")
    private User user;
}
