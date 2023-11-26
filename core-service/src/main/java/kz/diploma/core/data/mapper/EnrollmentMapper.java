package kz.diploma.core.data.mapper;

import kz.diploma.core.data.dto.EnrollmentDto;
import kz.diploma.core.data.dto.MaterialDto;
import kz.diploma.core.data.entity.EnrollmentEntity;
import kz.diploma.core.data.entity.MaterialEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentDto toDto(EnrollmentEntity enrollment);

    EnrollmentEntity toEntity(EnrollmentDto enrollmentDto);

    List<EnrollmentDto> toDtoList(List<EnrollmentEntity> enrollmentEntities);
}
