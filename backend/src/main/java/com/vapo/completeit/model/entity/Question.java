package com.vapo.completeit.model.entity;

import com.vapo.completeit.model.enums.question.Difficulty;
import com.vapo.completeit.model.enums.question.Topic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;


@Table(name = "questions")
@Data
@NoArgsConstructor
@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "content", nullable = false)
    @NotBlank
    private String content;

    @ManyToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "correct_answer_id", referencedColumnName = "id", nullable = false)
    @JoinTable(
            name = "question_answers",
            joinColumns = {
                    @JoinColumn(name = "question_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "answer_id")
            }
    )
    private List<Answer> answers;

    @OneToOne(cascade = CascadeType.ALL) // egy válasz több kérdésnek a válasza
    @JoinColumn(name = "correct_answer_id", referencedColumnName = "id", nullable = false)
    private Answer correctAnswer;

    @Column(name = "difficulty", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Column(name = "topic", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User createdBy;

    @Column(name = "created_at_utc", nullable = false, insertable = false, updatable = false)
    @PastOrPresent
    private Timestamp createdAt;
}