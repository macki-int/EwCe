package pl.mj.EwCe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class PriceCalculationAlgorithm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String algorithm;
    private BigDecimal finalPrice;
    private Date date;

    private User user;
    private Project project;
    private Product product;


}
