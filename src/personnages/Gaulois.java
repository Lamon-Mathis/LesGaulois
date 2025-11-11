package personnages;

import java.util.Objects;
import objets.Equipement;
import villagegaulois.Musee;
import villagegaulois.Trophee;

public class Gaulois {
	private String nom;
	// private int force;
	private int effetPotion = 1;
	private Village village;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private static final String BONJOUR = "Bonjour je m'appelle ";

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " \"" + texte + "\"");
	}

//	private String prendreParole() {
//		return "Le Gaulois " + nom + " :";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
//		romain.recevoirCoup((force * effetPotion) / 3);
//		if (effetPotion > 1) {
//			effetPotion--;
//		}
//
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] recompense = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; recompense != null && i < recompense.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = recompense[i];
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

	public void sePresenter() {
		if (this.village == null) {
			this.parler(BONJOUR + this.getNom() + ". Je voyage de villages en villages.");

		} else if (Objects.equals(this.getNom(), (village.getChef()).getNom())) {
			this.parler(BONJOUR + this.getNom() + ". Je suis le chef du village " + village.getNom() + ".");
		} else {
			this.parler(BONJOUR + this.getNom() + ". J'habite le village " + village.getNom() + ".");
		}
	}

	public void faireUneDonnation(Musee musee) {
		String texte = "Je donne au musee tous mes trophées :\n";
		if (this.nbTrophees != 0) {
			for (int i = 0; i < this.nbTrophees; i++) {
				if (this.trophees[i] != null) {

					Trophee don = new Trophee(this, this.trophees[i]);
					musee.donnerTrophees(this, don);
					texte += "- " + (this.trophees[i]).toString() + "\n";
				}
			}
		} else {
			texte = "Je n'ai pas de trophees...";
		}
		parler(texte);
	}

}
