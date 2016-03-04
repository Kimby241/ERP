package DataPackage;

// http://www.newthinktank.com/2012/10/composite-design-pattern-tutorial/
public abstract class ProcessusComponent {
	
    public void add(ProcessusComponent newProcessusComponent) {
	throw new UnsupportedOperationException();
    }
	
    public void remove(ProcessusComponent newProcessusComponent) {
	throw new UnsupportedOperationException();
    }
		
    public ProcessusComponent getComponent(int componentIndex) {
	throw new UnsupportedOperationException();
    }

    public String getEtat() {
	throw new UnsupportedOperationException();
    }

    public void displayProcessusInfo() {
	throw new UnsupportedOperationException();
    }
}
