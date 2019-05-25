package pl.mj.EwCe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mj.EwCe.model.PriceCalculationAlgorithm;

public interface PriceCalculationAlgorithmRepository extends JpaRepository <PriceCalculationAlgorithm, Long> {
}
