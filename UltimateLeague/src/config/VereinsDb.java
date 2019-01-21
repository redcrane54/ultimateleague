package config;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import beans.Spiel;
import beans.Verein;


//import com.sun.corba.se.impl.orbutil.ObjectWriter;

public class VereinsDb {

	private static String FILENAME_TEAMLIST ="";
	private static String FILENAME_TABLE ="";
	private static String DIRECTORY ="";
	private static String FILEPATH_TEAMS ="";
	private static String FILEPATH_TABLE ="";
	
	File teamsFile = null;
	File tableFile = null;
	File fileDirectory = null;
	
	Config c = new Config();
	
	public VereinsDb() {
		FILENAME_TABLE = c.pathTable;
		FILENAME_TEAMLIST = c.pathTeams;
		DIRECTORY = c.pathDir;
		FILEPATH_TEAMS =DIRECTORY+FILENAME_TEAMLIST;
		FILEPATH_TABLE =DIRECTORY+FILENAME_TABLE;
		teamsFile = new File(FILEPATH_TEAMS);
		tableFile = new File(FILEPATH_TABLE);
		fileDirectory = new File(DIRECTORY);
		initDB();
		
	}
	
//	public void speichern(Verein v) {
//		try {
//		FileWriter fr = new FileWriter(teamsFile);
//		BufferedWriter br = new BufferedWriter(fr);
//		
//		//Objectwriter here
//		br.write("\n"+v.getName());
//		//ObjectWriter or = new ObjectWriter(br);
//		br.close();
//		}catch(IOException e) {
//			System.out.println(e.toString());
//		}
//	}
	
	public void speichern(Spiel s) {
		try {
		FileWriter fr = new FileWriter(tableFile);
		BufferedWriter br = new BufferedWriter(fr);
		
		//Objectwriter here
		br.write("\n"+s.getVereinHeim().getName()+" - "+s.getVereinAuswaerts().getName()+" "+s.getAnzahlToreHeim()+":"+s.getAnzahlToreAuswaerts());
		
		br.close();
		//ObjectWriter or = new ObjectWriter(br);
		}catch(IOException e) {
			System.out.println(e.toString());
		}
	}
	
	public void initDB() {
		try{
			if(!fileDirectory.exists()){
				fileDirectory.mkdir();
			}
			if(!teamsFile.exists()){
				teamsFile.createNewFile();
			}	
			if(!tableFile.exists()){
				tableFile.createNewFile();
			}	
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
	
	public String tabelleAnzeigen(){
		String fileContent="";
		try {
			FileReader fr = new FileReader(tableFile);
			BufferedReader br = new BufferedReader(fr);
			while(br.readLine()!=null) {
				fileContent += br.readLine();
			}
			br.close();
			return fileContent;
		}catch(IOException e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
