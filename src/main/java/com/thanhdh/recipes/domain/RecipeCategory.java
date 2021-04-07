package com.thanhdh.recipes.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "recipe_categories")
public class RecipeCategory extends BaseEntity {

    @Builder
    public RecipeCategory(UUID id, Timestamp created, Timestamp updated, boolean isDeleted,
                          Recipe recipe, Category category) {
        super(id, created, updated, isDeleted);
        this.recipe = recipe;
        this.category = category;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    private Recipe recipe;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;
}
