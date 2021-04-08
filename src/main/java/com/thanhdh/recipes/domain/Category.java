package com.thanhdh.recipes.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Builder
    public Category(UUID id, Long version, Timestamp created, Timestamp updated,
                    boolean isDeleted, String name, boolean isDefault) {
        super(id, version, created, updated, isDeleted);
        this.name = name;
        this.isDefault = isDefault;
    }

    private String name;

    @Column(columnDefinition = "boolean default false")
    private boolean isDefault;
}
