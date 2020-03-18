package com.zup.xyinc.controller;

import com.zup.xyinc.dto.PointInterestRequest;
import com.zup.xyinc.model.PointInterest;
import com.zup.xyinc.service.PointInterestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PointInterestControllerTest {
    @Mock
    private PointInterestService pointInterestService;

    @InjectMocks
    private PointInterestController pointInterestController;

    @Test
    void returnAllPointInterestsFromService() {
        List<PointInterest> pointInterests = asList(PointInterest.builder().build());
        doReturn(pointInterests).when(pointInterestService).getAllPointsInterest();

        ResponseEntity<List<PointInterest>> response = pointInterestController.getAllPointInterests();

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(pointInterests);
    }

    @Test
    void returnHttpNoContentWhenListIsEmpty() {
        doReturn(Collections.EMPTY_LIST).when(pointInterestService).getAllPointsInterest();

        ResponseEntity<List<PointInterest>> response = pointInterestController.getAllPointInterests();

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    void getPointInterestsFromGivenCoordinates() {
        List<PointInterest> pointInterests = asList(PointInterest.builder().build());
        doReturn(pointInterests).when(pointInterestService).getPointsByProximity(20L, 10L, 10L);

        ResponseEntity<List<PointInterest>> response = pointInterestController.getPointInterestPerProximity(20L, 10L, 10L);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(pointInterests);
    }

    @Test
    void returnHttpNoContentWhenListIsEmptySearchingWithCoordinates() {
        doReturn(Collections.EMPTY_LIST).when(pointInterestService).getPointsByProximity(20L, 10L, 10L);

        ResponseEntity<List<PointInterest>> response = pointInterestController.getPointInterestPerProximity(20L, 10L, 10L);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    void saveAndReturnPointInterest() {
        PointInterest pointInterest = PointInterest.builder().id(1L).name("Lanchonete").coordinateX(20L).coordinateY(10L).build();
        PointInterestRequest pointInterestRequest = PointInterestRequest.builder().name("Lanchonete").coordinateX(20L).coordinateY(10L).build();
        doReturn(pointInterest).when(pointInterestService).createPointInterest(pointInterestRequest);

        PointInterest ret = pointInterestController.createPointInterest(pointInterestRequest);

        assertThat(ret).isNotNull();
        assertThat(ret.getId()).isEqualTo(1L);
        assertThat(ret.getName().equals("Lanchonete"));
        assertThat(ret.getCoordinateX().equals(20.0));
        assertThat(ret.getCoordinateY().equals(10.0));
    }
}