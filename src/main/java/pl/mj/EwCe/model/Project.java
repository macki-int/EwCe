package pl.mj.EwCe.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PriceCalculationAlgorithm> priceCalculationAlgorithms;

    public Project (){

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
