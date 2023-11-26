package kz.diploma.core.service;

import kz.diploma.core.data.dto.ModuleDto;

import java.util.List;

public interface ModuleService {
    void save(ModuleDto materialDto);

    List<ModuleDto> findAllByCourseId(Long courseId);
}