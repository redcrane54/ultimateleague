package config;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document; 
import org.jdom2.Element; 
import org.jdom2.JDOMException; 
import org.jdom2.input.SAXBuilder; 
import org.jdom2.output.XMLOutputter; 

public class Config {

	String pathTable="",pathTeams="";
	public String pathDir="";
	
	
	public String getPathTable() {
		return pathTable;
	}

	public String getPathTeams() {
		return pathTeams;
	}

	public Config() {
		readConfig();
	}
	
	public void readConfig() {
		
		 Document doc = null; 
	
	     File f = new File("C:\\Users\\epenner7169\\Documents\\ulieague112\\UltimateLeague\\src\\config\\config.xml"); 
	
	     try { 
	         // Das Dokument erstellen 
	         SAXBuilder builder = new SAXBuilder(); 
	         doc = builder.build(f); 
	         XMLOutputter fmt = new XMLOutputter(); 
	
	         // Wurzelelement
	         Element element = doc.getRootElement(); 

	
	         // Eine Liste aller direkten Kindelemente der Wurzel
	         List alleKinder = (List) element.getChildren(); 
	         
	         pathDir = ((Element) alleKinder.get(0)).getValue();

	         List Files = element.getChildren("Files"); 
	
	         // Wert eines bestimmten Elementes ausgeben 
	         Element kind = ((Element) Files.get(0)).getChild("Tabelle"); 
	         
	         pathTable=kind.getValue();
	         
	         // Wert eines bestimmten Elementes ausgeben 
	         Element kind2 = ((Element) Files.get(0)).getChild("Vereine"); 
	         
	         pathTeams = kind2.getValue();
	         
	         //System.out.println("Vereinsdatenbankname: " + kind2.getValue()); 
	         
	     } catch (JDOMException e) { 
	         e.printStackTrace(); 
	     } catch (IOException e) { 
	         e.printStackTrace(); 
	     } 
     }	
}
