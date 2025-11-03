package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement;
	private Equipement[] equipements;
	private static final String LE_SOLDAT = "Le soldat ";

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.nbEquipement = 0;
		this.equipements = new Equipement[2];
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	private boolean isInvariantVerified() {
		return this.force >= 0;
	}

//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup > 0;
//		int forceApres = force;
//		force -= forceCoup;
//		
//		if (force < 1) {
//			parler("J'abandonne");
//
//		} else {
//			parler("Aïe");
//
//		}
// 		assert forceApres > force;
//		assert IsInvariantVerified();
//	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne");
		}
		return equipementEjecte;
	}

	private void donnerEquipement(Equipement equipement) {
		assert this.nbEquipement < 2;
		this.equipements[nbEquipement] = equipement;
		System.out.println(LE_SOLDAT + this.getNom() + " s'équipe avec un " + equipement.toString());
		this.nbEquipement++;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println(LE_SOLDAT + this.getNom() + " est déjà bien protégé !");

			break;
		case 1:
			if (this.equipements[0] == equipement) {
				System.out.println(LE_SOLDAT + this.getNom() + " possède déjà un " + (this.equipements[0]).toString());
			} else
				donnerEquipement(equipement);
			break;

		case 0:
			donnerEquipement(equipement);
			break;
		default:
			break;
		}

	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(2);
		for (Equipement equipement : Equipement.values()) {
			System.out.println("-" + equipement);

		}

		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}
}
