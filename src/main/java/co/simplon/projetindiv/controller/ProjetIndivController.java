package co.simplon.projetindiv.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.projetindiv.model.Car;

@CrossOrigin("*")
@RestController
public class ProjetIndivController {

	private List<Car> toutesMesVoitures = new ArrayList<Car>( Arrays.asList(
			new Car("Honda", "Civic", "essence", 4, "bleu", 11_300),
			new Car("Mercedes", "Class A", "gazole", 4, "blanche", 18_900),
			new Car("Mercedes", "Class C", "essence", 5, "rouge", 29_600),
			new Car("Honda", "Jazz", "hybride", 5, "noir", 31_200),
			new Car("Renault", "Scenic", "essence", 7, "noir", 52_000),
			new Car("Renault", "Espace", "gazole", 7, "jaune", 66_000),
			new Car("Renault", "Clio", "gazole", 4, "gris", 12_500),
			new Car("Volkswagen", "Polo", "gazole", 4, "blanche", 11_600),
			new Car("Volkswagen", "Golf", "essence", 5, "rouge", 15_800),
			new Car("Volkswagen", "Up", "électrique", 4, "verte", 13_800)));
	
	
	// retourne le nom du projet
	@RequestMapping("/nom")
	public String nomProjet() {
		return "Liste des véhicules disponibles";
	}

	// retourne un objet de la classe model par son id avec message NOTFOUND si
	// objet pas trouvé
	@RequestMapping("/carById")
	public ResponseEntity<Car> trouverVoitureViaId(@RequestParam(value = "id") int id) {
		for (Car car : toutesMesVoitures) {
			if (car.getId() == id) {
				return ResponseEntity.ok(car);
			}
		}
		return ResponseEntity.notFound().build();
	}

	// retourne un objet de la classe model par sa marque avec message NOTFOUND si
	// objet pas trouvé
	@RequestMapping("/carsByMarque")
	public List<Car> trouverVoitureViaMarque(@RequestParam(value = "marque") String marque) {
		List<Car> rechercheMarque = new ArrayList<Car>();
		for (Car car : toutesMesVoitures) {
			if (car.getMarque().toLowerCase().equals(marque.toLowerCase())) {
				
				rechercheMarque.add(car); 
			}
		}
		return rechercheMarque;
	}

	// retourne 1 liste d'objets de la classe model
	@RequestMapping("/listevoitures")
	public List<Car> getCarList() {
		return toutesMesVoitures;
	}

	//ajoute un objet dans ma liste d'objets
	@PostMapping("/nouvellevoiture")
	public List<Car> ajouterVoiture(
	@RequestParam(value="marque") String marque, 
	@RequestParam(value="modele") String modele,
	@RequestParam(value="carburant") String carburant, 
	@RequestParam(value="nbrePlaces") int nbrePlaces, 
	@RequestParam(value="couleur") String couleur, 
	@RequestParam(value="prix") double prix)
			{
		Car maVoiture = new Car(marque, modele, carburant, nbrePlaces, couleur, prix);
		toutesMesVoitures.add(maVoiture);
		return toutesMesVoitures;
	}
} 


