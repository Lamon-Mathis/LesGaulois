package personnages.test_fonctionnel;

import java.util.Iterator;

import objets.Chaudron;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Gaulois obelix = new Gaulois("Ob�lix", 16);
		Romain brutus = new Romain("Brutus", 14);
		Chaudron chaudron = new Chaudron(0, 0);
		Druide panoramix = new Druide("Panoramix", 2, chaudron);
		panoramix.fabriquerPotion(4, 3);
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		for (int i = 0; i < 3; i++) {
			asterix.frapper(brutus);
			
		}
	}
}
