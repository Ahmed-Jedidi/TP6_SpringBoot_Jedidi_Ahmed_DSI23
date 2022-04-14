package com.ahmed.produits.repos;

import java.util.List;

//JpaRepository dispose ALL THE NECESSARY OPERATION  FOR DATA (CRUD)
//param are the ENTITY and the type of its Primary key
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahmed.produits.entities.Categorie;
import com.ahmed.produits.entities.Produit;


@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	List<Produit> findByNomProduit(String nom);
	
	
	//List<Produit> findByNomProduitLike(String nomProduit);
	//////////////////////////OU BIEN//////////////////////////////////
	List<Produit> findByNomProduitContains(String nom);
	
	
	//@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
	//List<Produit> findByNomPrix (String nom, Double prix);
	//////////////////////////OU BIEN//////////////////////////////////
	@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
	List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	
	@Query("select p from Produit p where p.categorie = ?1")
	List<Produit> findByCategorie (Categorie categorie);
	
	
	List<Produit> findByCategorieIdCat(Long id);
	
	
	List<Produit> findByOrderByNomProduitAsc();
	
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduitsNomsPrix ();
}