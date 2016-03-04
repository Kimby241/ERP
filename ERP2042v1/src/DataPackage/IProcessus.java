/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPackage;

import java.util.List;
import java.util.Map;
/**
 *
 * @author Kim
 */
public interface IProcessus {
    public void add(Processus processus);  
    public void remove(Processus processus);  
    public Processus getComposant(String id);
    public String getNom();  
    public String getID();
    //Map<String, Processus> getAllComposants();
    List<Processus> getAllComposants();
}
