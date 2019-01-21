package beans;
import java.io.Serializable;
import java.util.ArrayList;

public class Tabelle implements Serializable{

	ArrayList<Verein> Tabelle = new ArrayList<Verein>();
	
	public Tabelle(){
		
	}
	
	public void addTeam(Verein team){
		Tabelle.add(team);
	}
	
	public String toString(){
		String ausgabe="";
		for(int i = 0; i < Tabelle.size();i++){
			ausgabe += "\n";
			ausgabe += Tabelle.get(i).getName();
			ausgabe += "\t" + Tabelle.get(i).getAnzahltore();
		}
		return "";
	}
	
	public void sort() {
		//Tabelle.sort(arg0);
	}
	
}
