package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	private boolean estChef;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.village = null;
		this.estChef = false;
	}
	

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " \"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Gaulois " + nom + " :";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup((force * effetPotion) / 3);
		if (effetPotion > 1) {
			effetPotion--;
		}

	}

	@Override
	public String toString() {
		return nom;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		System.out.println(asterix);
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}


	public void setVillage(Village village) {
		this.village = village;
	}


	public void setEstChef(boolean estChef) {
		this.estChef = estChef;
	}
	
	public void sePresenter() {
		if (estChef) {
			this.parler("Bonjour, je m'appelle " + this.getNom() + ". Je suis le chef du village " + village.getNom() + ".");
		} else if (village!=null) {
			this.parler("Bonjour, je m'appelle " + this.getNom() + ". J'habite le village " + village.getNom() + ".");
		} else {
			this.parler("Bonjour, je m'appelle " + this.getNom() + ". Je voyage de villages en villages.");

		}
	}

}
