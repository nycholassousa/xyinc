package com.zup.xyinc.repository;

import com.zup.xyinc.model.PointInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointInterestRepository extends JpaRepository<PointInterest, Long> {
}
