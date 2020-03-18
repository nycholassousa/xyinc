package com.zup.xyinc.repository;

import com.zup.xyinc.model.PointInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointInterestRepository extends JpaRepository<PointInterest, Long> {

    @Query("select distinct p from PointInterest p where sqrt(power(p.coordinateX - :coordinateX, 2) + power(p.coordinateY - :coordinateY, 2)) <= :maxDistance")
    List<PointInterest> findAllByCoordinate(@Param("coordinateX") Long coordinateX, @Param("coordinateY") Long coordinateY, @Param("maxDistance") Double maxDistance);
}
