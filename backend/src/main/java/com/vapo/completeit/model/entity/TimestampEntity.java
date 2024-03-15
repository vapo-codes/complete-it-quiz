package com.vapo.completeit.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntity {

    @PastOrPresent
    @Column(name = "created_at_utc", nullable = false, insertable = false, updatable = false)
    private Timestamp createdAt;

    @PastOrPresent
    @Column(name = "modified_at_utc", insertable = false)
    private Timestamp modifiedAt;
}
