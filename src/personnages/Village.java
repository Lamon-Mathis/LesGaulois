package personnages;

public class Village {
	private String nom;
	private Gaulois chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int NB_VILLAGEOIS_MAX, Gaulois chef) {
		this.nom = nom;
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
		this.chef = chef;

		chef.setVillage(this);
		
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
			gaulois.setVillage(this);
			nbVillageois++;

		}
	}

	public Gaulois trouverVillageois(int numero) {
		if (numero > nbVillageois) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		} else {
			return villageois[numero - 1];
		}
	}

	public void afficherVillageois() {
		System.out.println("Dans le village " + "\"" + this.getNom() + "\" du chef" + (this.getChef()).getNom()
				+ "vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());

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
		Gaulois obelix = new Gaulois("ObÃ©lix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublepolemix = new Gaulois("Doublepolémix", 4);

		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();

	}

}
