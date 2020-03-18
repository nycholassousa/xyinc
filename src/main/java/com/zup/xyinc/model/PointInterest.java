package com.zup.xyinc.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class PointInterest {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "coordinate_x", nullable = false)
    private Long coordinateX;

    @Column(name = "coordinate_y", nullable = false)
    private Long coordinateY;

}
