package kz.diploma.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Long id;
    private Long courseId;
    private String title;
    private String description;
    private String language;
    private List<MaterialDto> materialList;
}
