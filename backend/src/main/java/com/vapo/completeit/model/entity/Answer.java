package com.vapo.completeit.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "content", nullable = false)
    @NotBlank
    private String content;

    @ManyToMany(mappedBy = "answers")
    private List<Question> questions;
}
