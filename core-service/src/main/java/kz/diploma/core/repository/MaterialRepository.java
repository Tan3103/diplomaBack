package kz.diploma.core.repository;

import kz.diploma.core.data.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
    List<MaterialEntity> findByModuleId(Long moduleId);
}
