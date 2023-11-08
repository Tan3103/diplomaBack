package kz.diploma.core.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDto {
    private Long id;
    private Long courseId;
    private String title;
    private String content;
    private String type;
}
