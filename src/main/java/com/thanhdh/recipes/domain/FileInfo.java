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
@Table(name = "fileinfo")
public class FileInfo extends BaseEntity {

    @Builder
    public FileInfo(UUID id, Long version, Timestamp created, Timestamp updated,
                    boolean isDeleted, String name, String url) {
        super(id, version, created, updated, isDeleted);
        this.name = name;
        this.url = url;
    }

    private String name;
    private String url;
}
