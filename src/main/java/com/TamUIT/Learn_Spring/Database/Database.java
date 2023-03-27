package com.TamUIT.Learn_Spring.Database;

import com.TamUIT.Learn_Spring.Model.Product;
import com.TamUIT.Learn_Spring.Repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                productRepository.deleteAll();
                Product product1 = new Product("iphone 13 pro max", 1000, 2022, "");
                Product product2 = new Product("ipad pro max 2023", 2000, 2023, "");
                logger.info("insert data: "+ productRepository.save(product1));
                logger.info("insert data: "+ productRepository.save(product2));
            }
        };
    }
}
