package beans;
import java.io.Serializable;
import java.util.ArrayList;

public class Verein implements Serializable{

	private static String Name="";
	private final static ArrayList<Spiel> Spiele= new ArrayList<Spiel>();
	private final static int AnzahlTore=0;
	private final static int GegenTore=0;

	
	public Verein(String name){
		Name = name;
	}

	public static ArrayList<Spiel> getSpiele() {
		return Spiele;
	}

	public String getName(){
		return Name;
	}
	
	public static int getAnzahltore() {
		return AnzahlTore;
	}

	public static int getGegentore() {
		return GegenTore;
	}
	
}
