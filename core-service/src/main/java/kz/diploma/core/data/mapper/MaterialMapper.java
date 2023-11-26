package kz.diploma.core.data.mapper;

import kz.diploma.core.data.dto.MaterialDto;
import kz.diploma.core.data.entity.MaterialEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    MaterialDto toDto(MaterialEntity materialEntity);

    MaterialEntity toEntity(MaterialDto materialDto);

    List<MaterialDto> toDtoList(List<MaterialEntity> materialEntity);
}
