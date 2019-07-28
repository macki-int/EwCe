package pl.mj.EwCe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pl.mj.EwCe.model.Product;
import pl.mj.EwCe.repository.ProductRepository;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam ("page") int page, @RequestParam("size") int size){
        return productRepository.findAll(PageRequest.of(page,size));
    }

    @GetMapping("/{id]")
    public Product product(@PathVariable long id){
        return productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Nie znaleziono produktu"));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id){
        productRepository.deleteById(id);
    }


}
