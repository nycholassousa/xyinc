package com.zup.xyinc.component;

import com.zup.xyinc.model.PointInterest;
import com.zup.xyinc.repository.PointInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private PointInterestRepository pointInterestRepository;

    @Override
    public void run(ApplicationArguments args) {
        pointInterestRepository.save(PointInterest.builder().name("Lanchonete").coordinateX(27L).coordinateY(12L).build());
        pointInterestRepository.save(PointInterest.builder().name("Posto").coordinateX(31L).coordinateY(18L).build());
        pointInterestRepository.save(PointInterest.builder().name("Joalheria").coordinateX(15L).coordinateY(12L).build());
        pointInterestRepository.save(PointInterest.builder().name("Floricultura").coordinateX(19L).coordinateY(21L).build());
        pointInterestRepository.save(PointInterest.builder().name("Pub").coordinateX(12L).coordinateY(8L).build());
        pointInterestRepository.save(PointInterest.builder().name("Supermercado").coordinateX(23L).coordinateY(6L).build());
        pointInterestRepository.save(PointInterest.builder().name("Churrascaria").coordinateX(28L).coordinateY(2L).build());
    }
}
