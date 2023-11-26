package kz.diploma.core.service.impl;

import kz.diploma.core.data.dto.ModuleDto;
import kz.diploma.core.data.entity.ModuleEntity;
import kz.diploma.core.data.mapper.ModuleMapper;
import kz.diploma.core.repository.ModuleRepository;
import kz.diploma.core.service.MaterialService;
import kz.diploma.core.service.ModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository materialRepository;
    private final ModuleMapper materialMapper;
    private final MaterialService materialService;

    @Override
    @Transactional
    public void save(ModuleDto materialDto) {
        ModuleEntity entity = materialRepository.save(materialMapper.toEntity(materialDto));

        if (!materialDto.getMaterialList().isEmpty()) {
            materialDto.getMaterialList().forEach(material -> {
                material.setModuleId(entity.getId());
                materialService.save(material);
            });
        }
    }

    @Override
    public List<ModuleDto> findAllByCourseId(Long courseId) {
        return materialMapper.toDtoList(materialRepository.findByCourseId(courseId));
    }
}