package com.thanhdh.recipes.web.mappers;

import com.thanhdh.recipes.domain.FileInfo;
import com.thanhdh.recipes.web.model.FileInfoDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface FileInfoMapper {

    FileInfo fileInforDtoToFileInfo(FileInfoDto fileInfoDto);

    FileInfoDto fileInfoToFileInforDto(FileInfo fileInfo);
}
