package com.thanhdh.recipes.services;

import com.thanhdh.recipes.domain.FileInfo;
import com.thanhdh.recipes.exceptions.FileStorageException;
import com.thanhdh.recipes.repositories.FileInfoRepository;
import com.thanhdh.recipes.web.mappers.FileInfoMapper;
import com.thanhdh.recipes.web.model.FileInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class FilesStorageServiceImpl implements FilesStorageService{

    private final Path root = Paths.get("uploads");
    private final FileInfoRepository fileRepository;
    private final FileInfoMapper fileMapper;

    @Override
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new FileStorageException();
        }
    }

    @Override
    public FileInfoDto save(MultipartFile file) {
        try {
            String newFileName =
                UUID.randomUUID().toString() + "." + file.getOriginalFilename().split(
                    "\\.")[1];

            Files.copy(file.getInputStream(), this.root.resolve(newFileName));

            FileInfoDto fileInfoDto = FileInfoDto.builder()
                .name(file.getOriginalFilename())
                .url(newFileName)
                .build();

            FileInfo fileInfo = fileRepository.save(fileMapper.fileInforDtoToFileInfo(fileInfoDto));

            return fileMapper.fileInfoToFileInforDto(fileInfo);
        } catch (Exception e) {
            throw new FileStorageException();
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileStorageException();
            }
        } catch (MalformedURLException e) {
            throw new FileStorageException();
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new FileStorageException();
        }
    }
}
