package com.thanhdh.recipes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    public BaseEntity(UUID id, Long version, Timestamp created, Timestamp updated, boolean isDeleted) {
        this.id = id;
        this.version = version;
        this.created = created;
        this.updated = updated;
        this.isDeleted = isDeleted;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

    private boolean isDeleted;
}
