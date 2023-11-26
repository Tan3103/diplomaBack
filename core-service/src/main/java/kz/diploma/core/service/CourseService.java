package kz.diploma.core.service;

import kz.diploma.core.data.dto.CourseDto;
import kz.diploma.core.data.entity.CourseEntity;

import java.util.List;

public interface CourseService {

    List<CourseEntity> findAll(String title, String description);

    CourseDto findById(Long id);

    void save(CourseDto courseDto);

    void update(Long id, CourseEntity course);

    void deleteById(Long id);
}