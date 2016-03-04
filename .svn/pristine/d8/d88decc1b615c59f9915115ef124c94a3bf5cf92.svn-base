package DataPackage;


import DataPackage.ProcessusComponent;
import DataPackage.Prospect;

public class Generator {
	
    public static void main(String[] args){
		
	ProcessusComponent prospect1 = new Prospect("Sam", "Quifou", "0123456789");
	ProcessusComponent prospect2 = new Prospect("Ryou", "Zank", "1234567890");
	ProcessusComponent prospect3 = new Prospect("Frank", "Frank", "2345678901");

	ProcessusComponent everyProspect = new Prospect("Every", "Prospect", "Ever");

	everyProspect.add(prospect1);
	everyProspect.add(prospect2);
	everyProspect.add(prospect3);

	ProcessusComponent devis1 = new Devis("Nouveau");
	ProcessusComponent devis2 = new Devis("Nouveau");
	ProcessusComponent devis3 = new Devis("Nouveau");

	prospect1.add(devis1);
	prospect1.add(devis2);
	prospect2.add(devis3);

	ProcessusComponent fact1 = new Facturation("Nouveau");
	ProcessusComponent fact2 = new Facturation("Nouveau");
	ProcessusComponent fact3 = new Facturation("Nouveau");

	devis1.add(fact1);
	devis2.add(fact2);
	devis3.add(fact3);

	DiscJockey crazyLarry = new DiscJockey(everyProspect);
		
	crazyLarry.getProcessusList();
    }
}
