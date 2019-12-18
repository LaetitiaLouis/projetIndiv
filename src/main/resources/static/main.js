$.ajax({
	url: "http://localhost:8080/nom"
}).then(function (data) {
	document.getElementById("nomDuProjet").innerText = data;
});

var liste = [];

$.ajax({
	url: "http://localhost:8080/listevoitures"
}).then(function (data) {
	liste = data;
	chargerListeVoitures();


});

//	charge ma liste de véhicules
function chargerListeVoitures() {
	liste.forEach(function (listeVehicules) {
		let listeVoitures = document.createElement('button');
		listeVoitures.className = "dropdown-item";
		listeVoitures.type = "button";
		listeVoitures.textContent = listeVehicules["marque"] + "   "
			+ listeVehicules["modele"];

		listeVoitures.addEventListener('click', function (event) {
			document.getElementById("contenuCard").innerHTML = "";
			chargerCaracteristiquesVoiture(listeVehicules);

		});

		document.getElementById("dropdown-list").appendChild(listeVoitures);

	});
}


// afficher la marque et le modèle de la voiture
function chargerCaracteristiquesVoiture(listeVehicules) {
	document.getElementById("contenuCard").innerHTML = "";
	let cardTitle = document.createElement('p');
	cardTitle.className = "card-title";
	cardTitle.innerText = listeVehicules["marque"] + "  "
		+ listeVehicules["modele"];
	document.getElementById("contenuCard").appendChild(cardTitle);

	let cardCarburant = document.createElement('p');
	cardCarburant.className = "card-title";
	cardCarburant.textContent = "Type de carburant : " + listeVehicules["carburant"];
	document.getElementById("contenuCard").appendChild(cardCarburant);

	let cardNrePlaces = document.createElement('p');
	cardNrePlaces.className = "card-title";
	cardNrePlaces.textContent = "Nombre de places : " + listeVehicules["nbrePlaces"];
	document.getElementById("contenuCard").appendChild(cardNrePlaces);

	let cardCouleur = document.createElement('p');
	cardCouleur.className = "card-title";
	cardCouleur.textContent = "Couleur : " + listeVehicules["couleur"];
	document.getElementById("contenuCard").appendChild(cardCouleur);

	let cardPrix = document.createElement('p');
	cardPrix.className = "card-title";
	cardPrix.textContent = "Prix : " + listeVehicules["prix"] + " €";
	document.getElementById("contenuCard").appendChild(cardPrix);
}

//Ajouter véhicule
$("#submit").click(function () {

	$.post("/nouvellevoiture",
		{
			marque: $("#marque").val(),
			modele: $("#modele").val(),
			carburant: $("#carburant").val(),
			nbrePlaces: $("#nbrePlaces").val(),
			couleur: $("#couleur").val(),
			prix: $("#prix").val()
		});
});

function marqueInconnu() {
	document.location.href = "404error.html";
	//console.log("KO");
}

// // function chercherParMarque() {

// let buttonSearch = document.getElementById("butonsearch");
// let rechercheVoiture = document.getElementById("submitSearch");
// buttonSearch.addEventListener('click', function (e) {

// 	$.ajax({
// 		url: "http://localhost:8080/carsByMarque?marque=" + rechercheVoiture.value
// 	}).then(function (data) {
// 		liste = data;

// 		liste.forEach(function (item) {
// 			//argerListeVoitures();
// 			chargerCaracteristiquesVoiture();
// 		});
// 	});
// });


//recherche par id
	let buttonSearch = document.getElementById("butonsearch");
	let rechercheId = document.getElementById("submitSearch");
	buttonSearch.addEventListener('click', function (event) {

		//document.getElementById("contenuCard").innerHTML = "";

		$.ajax({
			url: "http://localhost:8080//carById?id=" + rechercheId.value,
			success: (chargerCaracteristiquesVoiture),
			error: (marqueInconnu)
		});
	});








