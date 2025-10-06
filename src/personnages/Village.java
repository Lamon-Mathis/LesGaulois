package personnages;
import personnages.Gaulois;

public class Village {
	private static final int NB_VILLAGEOIS_MAX = 30;
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] chef = new Gaulois[0];
	private Gaulois[] villageois;
	
	public Village(String nom, int nbVillageois) {
		this.nom = nom;
		this.nbVillageois = nbVillageois;
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
		
	}
	
	public String getNom() {
		return nom;
	}

	public Gaulois[] getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois<NB_VILLAGEOIS_MAX) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
			gaulois.setVillage(this);
			
		}
	}
	public Gaulois trouverVillageois(int numero) {
		if (numero-1>nbVillageois) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
		else {
			return villageois[numero-1];
		}
	}

	
	
}
