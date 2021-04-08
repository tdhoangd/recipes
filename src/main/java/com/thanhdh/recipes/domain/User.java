package com.thanhdh.recipes.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Builder
    public User(UUID id, Long version, Timestamp created, Timestamp updated, boolean isDeleted,
                String name, String email, String userImage, String password,
                String confirmPassword, boolean isVerified, int failTimes, boolean isBanned,
                UUID dirStorageId) {
        super(id, version, created, updated, isDeleted);
        this.name = name;
        this.email = email;
        this.userImage = userImage;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.isVerified = isVerified;
        this.failTimes = failTimes;
        this.isBanned = isBanned;
        this.dirStorageId = dirStorageId;
    }

    private String name;

    @Column(unique = true)
    private String email;
    private String userImage;
    private String password;

    @Transient
    private String confirmPassword;

    private boolean isVerified;
    private int failTimes;
    private boolean isBanned;

    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(unique = true)
    private UUID dirStorageId;

}
