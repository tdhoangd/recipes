package com.thanhdh.recipes.repositories;

import com.thanhdh.recipes.domain.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileInfoRepository extends JpaRepository<FileInfo, UUID> {
}
