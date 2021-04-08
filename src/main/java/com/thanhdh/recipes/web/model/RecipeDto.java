package com.thanhdh.recipes.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeDto {

    @JsonProperty("id")
    private UUID id = null;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    @JsonProperty("createdDate")
    private OffsetDateTime created = null;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    @JsonProperty("lastUpdatedDate")
    private OffsetDateTime updated = null;

    @NotNull
    @NotBlank
    private String recipeTitle;

    private String imageUrl;
//    private List<RecipeCategoryDto>

}
