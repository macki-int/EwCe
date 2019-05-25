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

    public PriceCalculationAlgorithm(String algorithm, BigDecimal finalPrice, Date date) {
        this.algorithm = algorithm;
        this.finalPrice = finalPrice;
        this.date = date;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setDate(Date date){
        this.date=date;
    }

    public Date getDate(){
        return date;
    }
}
