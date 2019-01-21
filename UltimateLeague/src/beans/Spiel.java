package beans;

public class Spiel {

	Verein VereinAuswaerts=null,VereinHeim=null;
	int AnzahlToreAuswaerts = 0, AnzahlToreHeim = 0;
	
	
	public Spiel(Verein VereinA, Verein VereinB,int ToreA, int ToreB){
		this.VereinAuswaerts = VereinA;
		this.VereinHeim = VereinB;
		this.AnzahlToreHeim = ToreA;
		this.AnzahlToreAuswaerts = ToreB;
	}


	public Verein getVereinAuswaerts() {
		return VereinAuswaerts;
	}


	public void setVereinAuswaerts(Verein vereinAuswaerts) {
		VereinAuswaerts = vereinAuswaerts;
	}


	public Verein getVereinHeim() {
		return VereinHeim;
	}


	public void setVereinHeim(Verein vereinHeim) {
		VereinHeim = vereinHeim;
	}


	public int getAnzahlToreAuswaerts() {
		return AnzahlToreAuswaerts;
	}


	public void setAnzahlToreAuswaerts(int anzahlToreAuswaerts) {
		AnzahlToreAuswaerts = anzahlToreAuswaerts;
	}


	public int getAnzahlToreHeim() {
		return AnzahlToreHeim;
	}


	public void setAnzahlToreHeim(int anzahlToreHeim) {
		AnzahlToreHeim = anzahlToreHeim;
	}
	

	
	
}
