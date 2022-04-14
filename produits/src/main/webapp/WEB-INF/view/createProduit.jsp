<%@ page language="java" contentType="text/html; charset=windows-1256" 
		 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
	src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<head>
<meta charset="windows-1256">
<title>Créer un Produit</title>
</head>
<body>
	<div class="container mt-5">
		<div class="card-body">
			<form action="saveProduit" method="post">
				<div class="form-group">
					Nom produit : <input type="text" name="nomProduit"
						class="form-control" />
				</div>
				<div class="form-group">
					Prix produit : <input type="text" name="prixProduit"
						class="form-control" />
				</div>
				<div class="form-group">
					<label class="control-label">date création :</label> <input
						type="date" name="date" class="form-control" />

					<!-- <input type="submit" value="ajouter"> -->
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</div>

			</form>
		</div>
		${msg}
	
	<br />
	<br />
	<a href="ListeProduits">Liste Produits</a>
	</div>
</body>
</html>