package com.thanhdh.recipes.services;

import com.thanhdh.recipes.web.model.FileInfoDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesStorageService {

    public  void init();

    public FileInfoDto save(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
}
