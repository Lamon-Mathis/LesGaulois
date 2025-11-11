package villagegaulois;

import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Trophee equipementDonne) {
		this.trophees[this.nbTrophee] = equipementDonne;
		this.nbTrophee++;
		
	}
	
	public String extraireInstructionsOCaml() {
		
		StringBuilder instruction = new StringBuilder();
		instruction.append("let musee =  [");
		
		if(this.nbTrophee!=0) {
			for(int i=0; i<this.nbTrophee; i++) {
				if(this.trophees[i]!=null) {
					Trophee trophee = this.trophees[i];
					instruction.append("\"");
					instruction.append(trophee.donnerNom());
					instruction.append("\"");
					instruction.append(",");
					instruction.append("\"");
					instruction.append((trophee.getEquipement()).toString());
					instruction.append("\"");
					instruction.append(";\n");
				}
			}
		}
		
		instruction.append("\n]");
		
		return instruction.toString();
	}

}
