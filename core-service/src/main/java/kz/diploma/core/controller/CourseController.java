package kz.diploma.core.controller;

import kz.diploma.core.data.dto.CourseDto;
import kz.diploma.core.data.dto.EnrollmentDto;
import kz.diploma.core.data.entity.CourseEntity;
import kz.diploma.core.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/search")
    public List<CourseEntity> searchCourse(@RequestParam(required = false) String title,
                                           @RequestParam(required = false) String description) {
        return courseService.findAll(title, description);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @PostMapping
    public void createCourse(@RequestBody CourseDto courseDto) {
        courseService.save(courseDto);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody CourseEntity updatedCourse) {
        courseService.update(id, updatedCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }
}
