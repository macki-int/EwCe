package pl.mj.EwCe.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mj.EwCe.model.PriceCalculationAlgorithm;
import pl.mj.EwCe.repository.PriceCalculationAlgorithmRepository;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceCalculationAlgorithmController {
    private PriceCalculationAlgorithmRepository priceCalculationAlgorithmRepository;

    public PriceCalculationAlgorithmController(PriceCalculationAlgorithmRepository priceCalculationAlgorithmRepository) {
        this.priceCalculationAlgorithmRepository = priceCalculationAlgorithmRepository;
    }

    public List<PriceCalculationAlgorithm> get(){
        return priceCalculationAlgorithmRepository.findAll();
    }
}
