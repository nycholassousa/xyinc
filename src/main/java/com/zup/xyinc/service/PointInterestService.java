package com.zup.xyinc.service;

import com.zup.xyinc.dto.PointInterestRequest;
import com.zup.xyinc.model.PointInterest;
import com.zup.xyinc.repository.PointInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointInterestService {

    @Autowired
    private PointInterestRepository pointInterestRepository;

    public PointInterest createPointInterest(PointInterestRequest pointInterestRequest) {
        PointInterest pointInterest = PointInterest.builder()
                .name(pointInterestRequest.getName())
                .coordinateX(pointInterestRequest.getCoordinateX())
                .coordinateY(pointInterestRequest.getCoordinateY())
                .build();

        return pointInterestRepository.save(pointInterest);
    }

    public List<PointInterest> getAllPointsInterest() {
        return pointInterestRepository.findAll();
    }

    public List<PointInterest> getPointsByProximity(Long coordinateX, Long coordinateY, Long maxDistance) {
        return pointInterestRepository.findAllByCoordinate(coordinateX, coordinateY, maxDistance.doubleValue());
    }
}
