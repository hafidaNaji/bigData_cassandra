package net.naji.tp2_cassandra_bddc.services;

import net.naji.tp2_cassandra_bddc.entities.Product;
import net.naji.tp2_cassandra_bddc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void addProduct(String name, double price, int quantity){
        Product product=new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        product.setId(UUID.randomUUID());

        productRepository.insert(product);

    }

    public void editProduct(UUID id, String name, double price, int quantity){
        Product product = productRepository.findById(id).orElse(null);

         if(product==null) throw new RuntimeException("Le produit selectionné n'existe pas");

         product.setName(name);
         product.setPrice(price);
         product.setQuantity(quantity);

         productRepository.insert(product);
    }

    public void deleteProduct(UUID id) {
        Product product=productRepository.findById(id).orElse(null);

        if (product==null) throw new RuntimeException("Le produit delectionné n'existe pas");

        productRepository.delete(product);
    }


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
