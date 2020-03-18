package com.zup.xyinc.controller;

import com.zup.xyinc.dto.PointInterestRequest;
import com.zup.xyinc.model.PointInterest;
import com.zup.xyinc.service.PointInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/point")
public class PointInterestController {

    @Autowired
    private PointInterestService pointInterestService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<PointInterest>> getAllPointInterests() {
        return responseEntity(pointInterestService.getAllPointsInterest());
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public PointInterest createPointInterest(@Valid @RequestBody PointInterestRequest pointInterestRequest) {
        return pointInterestService.createPointInterest(pointInterestRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/x/{coordinateX}/y/{coordinateY}/distance/{maxDistance}", produces = "application/json")
    public ResponseEntity<List<PointInterest>> getPointInterestPerProximity(@PathVariable Long coordinateX, @PathVariable Long coordinateY, @PathVariable Long maxDistance) {
        return responseEntity(pointInterestService.getPointsByProximity(coordinateX, coordinateY, maxDistance));
    }

    private ResponseEntity<List<PointInterest>> responseEntity(List<PointInterest> response) {
        final HttpStatus httpStatus = response.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(response, httpStatus);
    }
}
