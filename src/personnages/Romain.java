package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement;
	private Equipement[] equipements;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.nbEquipement=0;
		this.equipements= new Equipement[2];
		assert IsInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	private boolean IsInvariantVerified() {
		return this.force >= 0;
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup>0;
		int force2=force;
		force -= forceCoup;
		assert force2>force;
		if (force < 1) {
			parler("J'abandonne");

		} else {
			parler("Aïe");

		}
		assert IsInvariantVerified();
	}
	
	private void donnerEquipement(Equipement equipement) {
		assert this.nbEquipement<2;
		this.equipements[nbEquipement]=equipement;
		System.out.println("Le soldat " + this.getNom() + " s'équipe avec un " + equipement.toString());
		this.nbEquipement++;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case (2):
			System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé !");
			
			break;
		case (1):
			if (this.equipements[0]==equipement) {
				System.out.println("Le soldat " + this.getNom() + " possède déjà un " + (this.equipements[0]).toString());
			}
			else donnerEquipement(equipement);
			break;
			
		case(0):
			donnerEquipement(equipement);
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(2);
		for (Equipement equipement : Equipement.values() ) {
			System.out.println("-" + equipement);
			
		}
		
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);

        

	}
}
