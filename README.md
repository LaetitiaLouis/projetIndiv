# <span style="color: #778999">ProjetIndiv Springboot </div>

Auteur du projet : Laëtitia LOUIS<br>Date : 19/12/2019

##  <span style="color: #778999">Description du projet </div>
<div align="justify"> Cette application concerne une liste de véhicules disponibles. Il est possible de consulter cette liste, les caractéristiques de chaque véhicule, d'ajouter des véhicules via un formulaire et de faire une recherche de véhicule par id. </div>

## <span style="color: #778999">Description du projet </div> Diagramme de fonctionnement ## 
<img src="Diagramme.jpg">

## <span style="color: #778999"> Présentation des endpoints de l'application ## 
<h3> <span style="color: #778899">"/nom" : </h3>
Affiche le nom de l'application

### <span style="color: #778899">"/listevoitures" </div> ##
Affiche la liste des voitures

### <span style="color: #778899">"/nouvellevoiture/{marque},{modele},{carburant},{nbrePlaces},{couleur},{prix}" </div> ## 
<div align="justify">Permet d'ajouter une voiture et ses caractériqtiques dans la liste de voitures. Cet ajout est rendu possible suite à la saisie par l'utilisateur des 6 paramètres requis dans le formulaire.

### <span style="color: #778899">"/carsById/{id}" </div> ##
Permet de rechercher un véhicule par son id. Lorsque l'id n'existe pas, l'application envoi un message d'erreur 404.

## <span style="color: #778899"> Exemple de Requête : ##
http://localhost:8080/listevoitures<br>
Cette requête affiche la liste des voitures

## <span style="color: #778899"> Exemple de Réponse : ##
```
{
id: 0,
marque: "Honda",
modele: "Civic",
carburant: "essence",
nbrePlaces: 4,
couleur: "bleu",
prix: 11300
},
{
id: 1,
marque: "Mercedes",
modele: "Class A",
carburant: "gazole",
nbrePlaces: 4,
couleur: "blanche",
prix: 18900
},
```
<br>

## <span style="color: #778899">Image page d'accueil ###

<img src="AccueilAppli.jpg">






