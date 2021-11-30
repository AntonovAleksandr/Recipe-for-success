package com.example.tdddevelopment.data.mapper;
import com.example.tdddevelopment.data.dto.StepDto;
import com.example.tdddevelopment.data.entity.Step;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StepMapper {
    StepMapper INSTANCE = Mappers.getMapper(StepMapper.class);
    StepDto stepToDto(Step step);
    List<StepDto> stepToDto(Iterable<Step> steps);
    Step dtoToStep(StepDto dto);
    List<Step> dtoToStep(Iterable<StepDto> dtoIterable);
}