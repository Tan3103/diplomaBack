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
    private Long moduleId;
    private String title;
    private String step;
    private String content;
    private String type;
}
