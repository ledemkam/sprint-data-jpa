package tech.ledem.jpa.service;


import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import tech.ledem.jpa.entity.Product;
import tech.ledem.jpa.entity.Sentiment;
import tech.ledem.jpa.entity.User;
import tech.ledem.jpa.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public Iterable<Product> searchl(String name, String sentiment) {
        if (Strings.isNotEmpty(name)){
            return this.productRepository.findByNameContainingOrderByPriceDesc(name);
        }
        if (Strings.isNotEmpty(sentiment)){
            return this.productRepository.findBySentimentsTextContaining(sentiment);
        }
        return this.productRepository.findAll();
    }

    public void initializeProducts(){
        //one genere les produits et utilisateur de maniere aleatoire
        Faker faker = new Faker();
       final List<Product> products = IntStream.range(30, 100).mapToObj(index ->
       {
              User user = User.builder()
                     .name(faker.name().fullName())
                     .build();
          final List<Sentiment> sentiments =   IntStream.range(2, 5).mapToObj(i ->
                              Sentiment.builder().user(user).text(faker.lorem().sentence()).build())
                     .collect(Collectors.toList());

              return Product.builder()
                        .sentiments(sentiments)
                     .name("Product " + index)
                     .price(index * 100)
                     .build();
       })
                .collect(Collectors.toList());

         productRepository.saveAll(products);//tout les produits sont crees et sauvegarder dans la base de donnees

    }

}
