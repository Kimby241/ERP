package DataPackage;

import java.util.ArrayList;
import java.util.Iterator;

public class Prospect extends ProcessusComponent {
	
    ArrayList devisComponents = new ArrayList();
	
    String firstname;
    String lastname;
    String phone;
	
    public Prospect(String firstname, String lastname, String phone){
	this.firstname = firstname;
	this.lastname = lastname;
	this.phone = phone;
    }
	
    public String getName() { return (firstname + " " + lastname); }
    public String getPhone() { return phone; }
	
    public void add(ProcessusComponent newProcessusComponent) {
	devisComponents.add(newProcessusComponent);
    }
	
    public void remove(ProcessusComponent newProcessusComponent) {
	devisComponents.remove(newProcessusComponent);
    }
	
    public ProcessusComponent getComponent(int componentIndex) {
	return (ProcessusComponent)devisComponents.get(componentIndex);
    }

    public void displayProcessusInfo(){
	System.out.println("Prospect : " + getName() + ":" + getPhone() + "\n");
	Iterator processusIterator = devisComponents.iterator();
	while(processusIterator.hasNext()) { 
	    ProcessusComponent processusInfo = (ProcessusComponent) processusIterator.next();
	    processusInfo.displayProcessusInfo();
	}
    }
}
