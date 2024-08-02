package tech.ledem.jpa;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.ledem.jpa.service.ProductService;

@AllArgsConstructor
@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    private ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);}

		@Override
		public void run (String...args) throws Exception {
			this.productService.initializeProducts();
		}

}
