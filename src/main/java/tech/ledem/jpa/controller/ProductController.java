package tech.ledem.jpa.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.ledem.jpa.service.ProductService;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "product", produces = APPLICATION_JSON_VALUE)
public class ProductController {
      private  ProductService productService;

    @GetMapping
    public Iterable search(@RequestParam(required = false) String name,@RequestParam(required = false) String sentiment){
        return this.productService.searchl(name, sentiment);
    }
}
