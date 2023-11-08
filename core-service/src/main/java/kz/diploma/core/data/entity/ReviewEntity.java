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
@Table(name = "reviews")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "course_id")
    private Long course;

    @JoinColumn(name = "user_id")
    private Long user;

    @Column(name = "rating")
    private int rating;

    @Column(name = "review")
    private String review;
}
