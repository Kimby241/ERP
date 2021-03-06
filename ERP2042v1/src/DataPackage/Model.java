package DataPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Model {
    //TODO: Change pathfile to the given arborenscence in the subject
    private final String usersFile = "users.txt";

    /* fileType :
       - 0 : Users file
       - 1 : Log file for Prospect
       - 2 : Log file for Devis
    */
    public String getFilePath(int fileType, String user, String client) {
	String filePath;
	if (fileType == 0) {
	    filePath = "./" + usersFile;
	}
	else if (fileType == 1) {
	    filePath = "./" + user + "/" + client + "/Prospect/log.txt";
	}
	else if (fileType == 2) {
	    filePath = "./" + user + "/" + client + "/Devis/log.txt";
	}
	else {
	    filePath = null;
	}

	return filePath;
    }
    
    public void createFileAndPath(File targetFile) {
	try {
	    File parent = targetFile.getParentFile();
	    if(!parent.exists() && !parent.mkdirs()){
		throw new IllegalStateException("Couldn't create dir: " + parent);
	    }
	      
	    if (targetFile.createNewFile()){
		System.out.println("File is created!");
	    } else {
		System.out.println("File already exists.");
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public ArrayList readFile(FileReader fileReader) {
	try {
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    String line = null;
	    ArrayList users = new ArrayList();

	    while((line = bufferedReader.readLine()) != null) {
		users.add(line);
	    }

	    bufferedReader.close();         
	    return users;
	}
	catch(FileNotFoundException ex) {
	    System.out.println("Unable to open file '" + usersFile + "'");                
	}
	catch(IOException ex) {
	    System.out.println("Error reading file '" + usersFile + "'");                  
	}

	return null;
    }

    public String getCurrentDate() {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	return "[" + dateFormat.format(date) + "] ";
    }

    public ArrayList getUsers() {
	try {
	    FileReader fileReader = new FileReader(usersFile);
	    return this.readFile(fileReader);
	} catch (IOException e) {
	    e.printStackTrace();
	}

	return null;
    }

    /* LOG */
    public void setLog(String user, String client, String content) {
	//TODO : user real client name
	String filePath = this.getFilePath(1, user, client);
	File targetFile = new File(filePath);
	this.createFileAndPath(targetFile);
	try {
	    FileWriter writer = new FileWriter(filePath, true);
	    writer.write(this.getCurrentDate() + content + "\n");
	    writer.close();
    	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public ArrayList getLog(int type, String user, String client) {
	try {
	    //TODO: use real client name
	    String filePath = this.getFilePath(type, user, client);
	    FileReader fileReader = new FileReader(filePath);
	    return this.readFile(fileReader);
	} catch (IOException e) {
	    e.printStackTrace();
	}

	return null;
    }

    /*
    public String getProspect(String user, String client) {
	String filePath = this.getFilePath(
    }
    */
}
