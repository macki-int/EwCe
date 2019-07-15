package pl.mj.EwCe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mj.EwCe.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
