package controls;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import beans.Verein;
import config.Config;

public class Controller implements Serializable{

	Config c = new Config();
	
	public Controller(){
		
	}
	
	public ArrayList<Verein> getTeams(){
		String teams="";
		ArrayList<Verein> vList = new ArrayList<Verein>();
		
		try {
			ObjectInputStream objectInputStream =
		            new ObjectInputStream(new FileInputStream(c.pathDir+c.getPathTeams()));

		//if (objectInputStream.readObject() != null) {
			vList  = (ArrayList<Verein>) objectInputStream.readObject();
			
			for(int i = 0; i < vList.size();i++) {
				
				System.out.println(vList.get(i).getName()+" Anzahl Tore: "+vList.get(i).getAnzahltore());
	        
			}
		//}
		        		        
//	        boolean cont=true;
//	        while(cont){
//	        	if (objectInputStream.readObject()!= null) {
//	           Verein obj = (Verein) objectInputStream.readObject();
//	           if(obj != null) {
//	              vList.add(obj);
//	           System.out.println(obj.getName());
//		        System.out.println(obj.getAnzahltore());
//	           }else
//	              cont = false;
//	        	}
//	        }
	        objectInputStream.close();
			
			return vList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public void addTeam(String teamName){
		
		try {
//			File f = new File(c.getPathTeams());
//			FileOutputStream fWriter;
//			fWriter = new FileOutputStream(f);
//			BufferedOutputStream bOutputStream= new BufferedOutputStream(fWriter);
//			ObjectOutputStream bWriter = new ObjectOutputStream(bOutputStream);
//			
			Verein team = new Verein(teamName);
			
			//bWriter.writeObject(team);
			//bWriter.close();
			
			ObjectOutputStream objectOutputStream =
		            new ObjectOutputStream(new FileOutputStream(c.pathDir+c.getPathTeams()));

			//ArrayList<Verein> t = getTeams()==null?new ArrayList<Verein>():getTeams();
			ArrayList<Verein> t = new ArrayList<Verein>();
			t.add(new Verein(teamName));
			
			//t.add(new Verein("test1"));
//			for(int i=0;i<getTeams().size();i++) {
//				objectOutputStream.writeObject(getTeams().get(i));	
//			}
			objectOutputStream.writeObject(t);
			
			objectOutputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String createGameplan(){
		return "";
	}
	
}
