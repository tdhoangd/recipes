package com.thanhdh.recipes.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity{

    @Builder
    public Recipe(UUID id, Timestamp created, Timestamp updated, boolean isDeleted,
                  String recipeTitle, String imageUrl, boolean isPrivate,
                  List<RecipeCategory> recipeCategories, List<RecipeInstruction> recipeInstructions) {
        super(id, created, updated, isDeleted);
        this.recipeTitle = recipeTitle;
        this.imageUrl = imageUrl;
        this.isPrivate = isPrivate;
        this.recipeCategories = recipeCategories;
        this.recipeInstructions = recipeInstructions;
    }

    @Column(length = 50, columnDefinition = "varchar(50)", nullable = false)
    private String recipeTitle;

    private String imageUrl;

    @Column(columnDefinition = "boolean default true")
    private boolean isPrivate;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecipeCategory> recipeCategories;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecipeInstruction> recipeInstructions;
}
