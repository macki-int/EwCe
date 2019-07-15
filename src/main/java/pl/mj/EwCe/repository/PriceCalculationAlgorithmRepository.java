package pl.mj.EwCe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mj.EwCe.model.PriceCalculationAlgorithm;

@Repository
public interface PriceCalculationAlgorithmRepository extends JpaRepository <PriceCalculationAlgorithm, Long> {
}
