package com.example.tdddevelopment.data.mapper;

import com.example.tdddevelopment.data.dto.StorageElementDto;
import com.example.tdddevelopment.data.entity.StorageElement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StorageElementMapper {
    StorageElementMapper INSTANCE = Mappers.getMapper(StorageElementMapper.class);
    StorageElementDto storageElementToDto(StorageElement storageElement);
    List<StorageElementDto> storageElementToDto(Iterable<StorageElement> storageElements);
    StorageElement dtoToStorageElement(StorageElementDto dto);
    List<StorageElement> dtoToStorageElement(Iterable<StorageElementDto> dtoIterable);
}
