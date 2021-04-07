package com.thanhdh.recipes.domain;

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
@Table(name = "recipe_instructions")
public class RecipeInstruction extends BaseEntity {

    public RecipeInstruction(UUID id, Timestamp created, Timestamp updated, boolean isDeleted,
                             Recipe recipe, Instruction instruction) {
        super(id, created, updated, isDeleted);
        this.recipe = recipe;
        this.instruction = instruction;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    private Recipe recipe;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Instruction instruction;
}
