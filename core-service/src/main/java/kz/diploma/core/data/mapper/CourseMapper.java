package kz.diploma.core.data.mapper;

import kz.diploma.core.data.dto.CourseDto;
import kz.diploma.core.data.entity.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDto(CourseEntity courseEntity);

    CourseEntity toEntity(CourseDto courseDto);
}
