package kz.diploma.core.service;

import kz.diploma.core.data.dto.MaterialDto;

import java.util.List;

public interface MaterialService {
    void save(MaterialDto materialDto);

    List<MaterialDto> findAllByModuleId(Long moduleId);
}