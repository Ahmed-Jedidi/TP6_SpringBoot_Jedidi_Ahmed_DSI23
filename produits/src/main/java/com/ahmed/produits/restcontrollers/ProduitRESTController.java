package com.ahmed.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.produits.entities.Produit;
import com.ahmed.produits.service.ProduitService;

@RestController
@RequestMapping("/api")
//Les IP qui ont le droits de consommé ce service
@CrossOrigin
public class ProduitRESTController {

	@Autowired
	// Un objet qui implemente cette interface
	ProduitService produitService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Produit> getAllProduits() {
		return produitService.getAllProduits();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Produit createProduit(@RequestBody Produit produit) {
		return produitService.saveProduit(produit);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProduitById(@PathVariable("id") Long id) {
		produitService.deleteProduitById(id);
	}
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
	return produitService.findByCategorieIdCat(idCat);
	}
	
	
	
	

	@RequestMapping(value = "/produitNom/{nomProduit}", method = RequestMethod.GET)
	public List<Produit> findByNomProduitContains(@PathVariable("nomProduit") String nomProduit) {
		return produitService.findByNomProduitContains(nomProduit);
	}
}
