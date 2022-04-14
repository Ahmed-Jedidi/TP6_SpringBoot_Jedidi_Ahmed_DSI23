package com.ahmed.produits;

/*import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.produits.entities.Produit;
import com.ahmed.produits.service.ProduitService;

@SpringBootApplication
public class ProduitsApplication implements CommandLineRunner{
	
	/*@Autowired
	ProduitService produitService;*/
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		//System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(ProduitsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*produitService.saveProduit(new Produit("PC Dell", 2600.0, new Date()));
	produitService.saveProduit(new Produit("PC Asus", 2800.0, new Date()));
	produitService.saveProduit(new Produit("Imprimante Epson", 900.0, new Date()));*/
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
	}
	
}
