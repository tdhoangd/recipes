package com.thanhdh.recipes.boostrap;

import com.thanhdh.recipes.services.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FileStorageResource implements CommandLineRunner {

    @Resource
    FilesStorageService filesStorageService;

    @Override
    public void run(String... args) throws Exception {
        filesStorageService.deleteAll();
        filesStorageService.init();
    }
}
