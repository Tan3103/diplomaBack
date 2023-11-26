package kz.diploma.core.service.impl;

import kz.diploma.core.data.dto.MaterialDto;
import kz.diploma.core.data.mapper.MaterialMapper;
import kz.diploma.core.repository.MaterialRepository;
import kz.diploma.core.service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    @Override
    @Transactional
    public void save(MaterialDto materialDto) {
        materialRepository.save(materialMapper.toEntity(materialDto));
    }

    @Override
    public List<MaterialDto> findAllByModuleId(Long moduleId) {
        return materialMapper.toDtoList(materialRepository.findByModuleId(moduleId));
    }
}