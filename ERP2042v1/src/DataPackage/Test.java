package DataPackage;

import java.io.*;
import java.util.ArrayList;

public class Test {

    public static void main(String [] args) {
	Model theModel = new Model();
	//System.out.println(theModel.getUsers());
	ArrayList users = theModel.getUsers();
	System.out.println(users.get(1));
	theModel.setLog((String)users.get(1), "TEST", "This is a test");
	System.out.println(theModel.getLog(1, (String)users.get(1), "TEST"));
    }
}
