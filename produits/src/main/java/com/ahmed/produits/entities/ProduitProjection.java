package com.ahmed.produits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProd", types = { Produit.class })
public interface ProduitProjection {
	public String getNomProduit();
}