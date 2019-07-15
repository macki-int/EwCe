package pl.mj.EwCe.model;

import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    public PriceCalculationAlgorithm(String algorithm, BigDecimal finalPrice, Date date) {
        this.algorithm = algorithm;
        this.finalPrice = finalPrice;
        this.date = date;
    }

    public PriceCalculationAlgorithm(){

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
