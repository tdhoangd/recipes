package com.thanhdh.recipes.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileInfoDto {

    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime created;

    @Null
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime updated;

    @Null
    @JsonIgnore
    private boolean isDeleted;

    @NotBlank
    private String name;

    @NotBlank
    private String url;
}
