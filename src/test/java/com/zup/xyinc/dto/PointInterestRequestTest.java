package com.zup.xyinc.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PointInterestRequestTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testNegativeCoordinate() {
        PointInterestRequest pointInterestRequest = PointInterestRequest.builder().name("Casa").coordinateX(-1L).coordinateY(-1L).build();

        Set<ConstraintViolation<PointInterestRequest>> violations = validator.validate(pointInterestRequest);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(2);
    }

    @Test
    void testEmptyName() {
        PointInterestRequest pointInterestRequest = PointInterestRequest.builder().name("").coordinateX(0L).coordinateY(0L).build();

        Set<ConstraintViolation<PointInterestRequest>> violations = validator.validate(pointInterestRequest);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(1);
    }

    @Test
    void testNullCoordinates() {
        PointInterestRequest pointInterestRequest = PointInterestRequest.builder().name("Casa").build();

        Set<ConstraintViolation<PointInterestRequest>> violations = validator.validate(pointInterestRequest);
        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(2);
    }

    @Test
    void testCorrectRequest() {
        PointInterestRequest pointInterestRequest = PointInterestRequest.builder().name("Casa").coordinateX(0L).coordinateY(0L).build();

        Set<ConstraintViolation<PointInterestRequest>> violations = validator.validate(pointInterestRequest);
        assertThat(violations).isEmpty();
    }
}