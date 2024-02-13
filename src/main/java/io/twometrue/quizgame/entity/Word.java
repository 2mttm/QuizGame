package io.twometrue.quizgame.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String italian;
    private String italianPast;
//    private final String english;
    private String russian;

    public Word(String italian, String italianPast, String russian) {
        this.italian = italian;
        this.italianPast = italianPast;
        this.russian = russian;
    }
}