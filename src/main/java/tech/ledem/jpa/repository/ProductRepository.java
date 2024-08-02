package tech.ledem.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import tech.ledem.jpa.entity.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    //select * from product where name = param : avec sprint data jpa
    //on peut creer des methodes qui vont etre implementer automatiquement
    //par spring data jpa voir direct ci dessous:
    Iterable<Product> findByName(String name);

    Iterable<Product> findByNameContainingOrderByPriceDesc(String name);

    Iterable<Product> findByPriceAfter(int price);

    List<Product> findBySentimentsTextContaining(String text);

}
