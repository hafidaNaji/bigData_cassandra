package net.naji.tp2_cassandra_bddc.web;

import net.naji.tp2_cassandra_bddc.entities.Product;
import net.naji.tp2_cassandra_bddc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product>getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public String saveProduct(@RequestParam String name,@RequestParam double price, @RequestParam int quantity){
        productService.addProduct(name,price,quantity);

        return "Product is saved";
    }

    @PutMapping
    public String editProduct(@RequestParam UUID id, @RequestParam String name, @RequestParam double price, @RequestParam int quantity){
        productService.editProduct(id, name, price, quantity);
        return "Product is updated";
    }
    @DeleteMapping
    public String deleteProduct (@RequestParam UUID id){
        productService.deleteProduct(id);
        return "Product is delected";
    }




}
