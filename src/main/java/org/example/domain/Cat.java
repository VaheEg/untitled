package org.example.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CAT")
public class Cat {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CAT_ID_SEQUENCE"
    )
    @SequenceGenerator(name = "CAT_ID_SEQUENCE")
    private final Integer Id;

    @Column(name = "fact", nullable = false)
    private String fact;

    @Column(name = "length", nullable = false)
    private Integer length;
}
