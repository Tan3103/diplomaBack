package kz.diploma.core.service.impl;

import kz.diploma.core.data.dto.EnrollmentDto;
import kz.diploma.core.data.entity.EnrollmentEntity;
import kz.diploma.core.data.mapper.EnrollmentMapper;
import kz.diploma.core.service.EnrollmentService;
import kz.diploma.core.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public List<EnrollmentEntity> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public EnrollmentEntity findById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public EnrollmentDto save(EnrollmentDto course) {
        EnrollmentEntity entity = enrollmentMapper.toEntity(course);
        entity.setEnrollmentDate(LocalDate.now());


        return enrollmentMapper.toDto(enrollmentRepository.save(entity));
    }

    @Override
    public Boolean check(Long userId, Long courseId) {
        Optional<EnrollmentEntity> entity = enrollmentRepository.findByCourseIdAndUserId(courseId, userId);
        return entity.isPresent();
    }

    @Override
    @Transactional
    public void update(Long id, EnrollmentEntity enrollment) {
        enrollment.setId(id);
        enrollmentRepository.save(enrollment);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }
}