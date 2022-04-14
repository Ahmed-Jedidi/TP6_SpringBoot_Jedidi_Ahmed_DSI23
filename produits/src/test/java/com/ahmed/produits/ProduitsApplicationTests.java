package com.ahmed.produits;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ahmed.produits.service.ProduitService;

import java.util.Date;
import java.util.List;

import com.ahmed.produits.entities.Categorie;
import com.ahmed.produits.entities.Produit;
import com.ahmed.produits.repos.ProduitRepository;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	/*@Test
	void contextLoads() {
	}*/
	
	@Autowired
	ProduitService produitService;
	
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Produit> prods = produitService.getAllProduitsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	/*@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC Asus", 6000.999 , new Date());
		produitRepository.save(prod);
	}*/

	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(16L);
		;
	}

	@Test
	public void testListerTousProduits() {
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	
	/**/
	@Test
	public void testFindProduitByNom()
	{
		List<Produit> prods = produitRepository.findByNomProduit("PC Asus");
		
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindProduitByNomContains()
	{
		List<Produit> prods = produitRepository.findByNomProduitContains("PC");
		
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Produit> prods = produitRepository.findByNomPrix("PC DELL", 1000.5);
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}
	
	
	
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Produit> prods = produitRepository.findByCategorie(cat);
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}
	
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}
	
	
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Produit> prods =

	produitRepository.findByOrderByNomProduitAsc();
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}
	
	
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Produit> prods = produitRepository.trierProduitsNomsPrix();
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}

}
