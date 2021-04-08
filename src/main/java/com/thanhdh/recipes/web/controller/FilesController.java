package com.thanhdh.recipes.web.controller;

import com.thanhdh.recipes.services.FilesStorageService;
import com.thanhdh.recipes.web.model.FileInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/files")
public class FilesController {

    private final FilesStorageService filesStorageService;

    @PostMapping("/upload")
    public ResponseEntity<FileInfoDto> uploadFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(filesStorageService.save(file));
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = filesStorageService.load(filename);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
