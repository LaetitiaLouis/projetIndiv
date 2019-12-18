package co.simplon.projetindiv.model;

public class Car {

	private int id;
	private String marque;
	private String modele;
	private String carburant;
	private int nbrePlaces;
	private String couleur;
	private double prix;
	
	private static int globalId = 0;
	
	
	
	public Car(String marque, String modele, String carburant, int nbrePlaces, String couleur, double prix) {
		this.id = globalId++;
		this.marque = marque;
		this.modele = modele;
		this.carburant = carburant;
		this.nbrePlaces = nbrePlaces;
		this.couleur = couleur;
		this.prix = prix;
	
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public int getNbrePlaces() {
		return nbrePlaces;
	}

	public void setNbrePlaces(int nbrePlaces) {
		this.nbrePlaces = nbrePlaces;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
	
	
	
	
	