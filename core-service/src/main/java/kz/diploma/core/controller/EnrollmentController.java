package kz.diploma.core.controller;

import kz.diploma.core.data.dto.EnrollmentDto;
import kz.diploma.core.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping()
    public ResponseEntity<?> enrollmentCourse(@RequestBody EnrollmentDto enrollmentDto) {
        return ResponseEntity.ok(enrollmentService.save(enrollmentDto));
    }

    @GetMapping("/check")
    public ResponseEntity<?> check(@RequestParam("userId") Long userId,
                                   @RequestParam("courseId") Long courseId) {
        return ResponseEntity.ok(enrollmentService.check(userId, courseId));
    }
}
