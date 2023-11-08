package kz.diploma.core.service.impl;

import kz.diploma.core.data.dto.CourseDto;
import kz.diploma.core.data.entity.CourseEntity;
import kz.diploma.core.data.mapper.CourseMapper;
import kz.diploma.core.service.CourseService;
import kz.diploma.core.repository.CourseRepository;
import kz.diploma.core.service.MaterialService;
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
    private final MaterialService materialService;

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
    public CourseEntity findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(CourseDto courseDto) {
        CourseEntity courseEntity = courseMapper.toEntity(courseDto);
        courseEntity.setCreatedDate(LocalDateTime.now());
        courseEntity.setModifiedDate(LocalDateTime.now());

        CourseEntity entity = courseRepository.save(courseEntity);

        if (!courseDto.getMaterialList().isEmpty()) {
            courseDto.getMaterialList().forEach(materialDto -> {
                materialDto.setCourseId(entity.getId());
                materialService.save(materialDto);
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