package kz.diploma.core.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "materials")
public class MaterialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "module_id")
    private Long moduleId;

    @Column(name = "title")
    private String title;

    @Column(name = "step")
    private String step;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private String type;
}
