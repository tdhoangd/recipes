package com.thanhdh.recipes.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "instructions")
public class Instruction extends BaseEntity {

    @Builder
    public Instruction(UUID id, Long version, Timestamp created, Timestamp updated,
                       boolean isDeleted, Integer stepId, String description, String imageUrl) {
        super(id, version, created, updated, isDeleted);
        this.stepId = stepId;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    private Integer stepId;
    private String description;
    private String imageUrl;
}
