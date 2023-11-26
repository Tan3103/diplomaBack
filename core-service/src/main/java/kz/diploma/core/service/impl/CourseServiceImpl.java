package kz.diploma.core.service.impl;

import kz.diploma.core.data.dto.CourseDto;
import kz.diploma.core.data.dto.ModuleDto;
import kz.diploma.core.data.entity.CourseEntity;
import kz.diploma.core.data.mapper.CourseMapper;
import kz.diploma.core.service.CourseService;
import kz.diploma.core.repository.CourseRepository;
import kz.diploma.core.service.ModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final ModuleService moduleService;

    @Override
    public List<CourseEntity> findAll(String title, String description) {
        if (title != null && description != null) {
            return courseRepository.findByTitleAndDescription(title, description);
        } else if (title != null) {
            return courseRepository.findByTitle(title);
        } else if (description != null) {
            return courseRepository.findByDescription(description);
        } else {
            return courseRepository.findAll();
        }
    }

    @Override
    public CourseDto findById(Long id) {
        CourseDto courseDto = courseMapper.toDto(courseRepository.findById(id).orElse(null));

        if (courseDto != null) {
            List<ModuleDto> moduleDtoList = moduleService.findAllByCourseId(courseDto.getId());

            courseDto.setModuleList(moduleDtoList);
            courseDto.setModuleCount(moduleDtoList.size());
        }
        return courseDto;
    }

    @Override
    @Transactional
    public void save(CourseDto courseDto) {
        CourseEntity courseEntity = courseMapper.toEntity(courseDto);
        courseEntity.setCreatedDate(LocalDateTime.now());
        courseEntity.setModifiedDate(LocalDateTime.now());

        CourseEntity entity = courseRepository.save(courseEntity);

        if (!courseDto.getModuleList().isEmpty()) {
            courseDto.getModuleList().forEach(moduleDto -> {
                moduleDto.setCourseId(entity.getId());
                moduleService.save(moduleDto);
            });
        }
    }

    @Override
    @Transactional
    public void update(Long id, CourseEntity course) {
        course.setId(id);
        courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}