package kz.diploma.core.repository;

import kz.diploma.core.data.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    List<CourseEntity> findByTitle(String title);

    List<CourseEntity> findByDescription(String author);

    List<CourseEntity> findByTitleAndDescription(String title, String description);
}
