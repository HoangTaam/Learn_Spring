package com.TamUIT.Learn_Spring.Controller;

import com.TamUIT.Learn_Spring.Model.Product;
import com.TamUIT.Learn_Spring.Model.ResponseObject;
import com.TamUIT.Learn_Spring.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Products")
public class ProductController {
    //DI = Dependency Injection
    @Autowired
    private ProductRepository repository;
    @GetMapping("")
    List<Product> getAllProducts() throws Exception {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable long id){
         Optional<Product> foundProduct = repository.findById(id);
         return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query product successfully", foundProduct.get())
                ):
                 ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                         new ResponseObject("error", "Cannot find product with id " + id, "")
                 );
    }
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct){
        List<Product> products = repository.findByProductName(newProduct.getProductName().trim());
        if(products.size() > 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseObject("error", "Product already exists", "")
            );
        }
        Product product = repository.save(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseObject("ok", "Product inserted successfully", product)
        );
    }
    @PutMapping("/update/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product updatedProduct, @PathVariable long id) {
        Product updateProduct = repository.findById(id)
                .map(product -> {
                    product.setProductName(updatedProduct.getProductName());
                    product.setPrice(updatedProduct.getPrice());
                    product.setYear(updatedProduct.getYear());
                    product.setUrl(updatedProduct.getUrl());
                    return repository.save(product);
                }
                ).orElseGet(() -> {
                    updatedProduct.setId(id);
                    return repository.save(updatedProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Product updated successfully", updateProduct)
        );
    }
}
