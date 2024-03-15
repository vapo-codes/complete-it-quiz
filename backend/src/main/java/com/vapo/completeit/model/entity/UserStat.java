package com.vapo.completeit.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_stats")
@Data
@NoArgsConstructor
public class UserStat {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "correct_answers", nullable = false)
    @PositiveOrZero
    private Integer correctAnswers;

    @Column(name = "wrong_answers", nullable = false)
    @PositiveOrZero
    private Integer wrongAnswers;

    @Column(name = "score", nullable = false)
    @PositiveOrZero
    private Double score;
}