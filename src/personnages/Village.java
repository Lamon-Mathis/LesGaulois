package personnages;

import java.util.Iterator;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;

	public Village(String nom, int NB_VILLAGEOIS_MAX, Gaulois chef) {
		this.nom = nom;
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
		this.chef = chef;

	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
			gaulois.setVillage(this);

		}
	}

	public Gaulois trouverVillageois(int numero) {
		if (numero - 1 > nbVillageois) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		} else {
			return villageois[numero - 1];
		}
	}

	public void afficherVillageois(Village village) {
		System.out.println("Dans le village " + "\"" + village.getNom()+ "\" du chef" + village.getChef() + "vivent les légendaires gaulois :");
		for (Gaulois gaulois : villageois) {
			System.out.println("- "+ gaulois);
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", 30, abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

	}

}
