package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
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
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(2);
	}
}
