package kz.diploma.core.service;

import kz.diploma.core.data.dto.EnrollmentDto;
import kz.diploma.core.data.entity.EnrollmentEntity;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentEntity> findAll();

    EnrollmentEntity findById(Long id);

    EnrollmentDto save(EnrollmentDto course);

    Boolean check(Long userId, Long courseId);

    void update(Long id, EnrollmentEntity course);

    void deleteById(Long id);
}