package kz.diploma.core.data.mapper;

import kz.diploma.core.data.dto.ModuleDto;
import kz.diploma.core.data.entity.ModuleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModuleMapper {
    ModuleDto toDto(ModuleEntity materialEntity);

    ModuleEntity toEntity(ModuleDto materialDto);

    List<ModuleDto> toDtoList(List<ModuleEntity> materialEntity);
}
