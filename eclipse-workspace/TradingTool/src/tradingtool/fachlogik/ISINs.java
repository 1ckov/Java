package tradingtool.fachlogik;

import java.util.ArrayList;

public class ISINs {
	private ArrayList<Kursreihe> kursreihen=new ArrayList<>();
	
	public ISINs() {
	}
	
	public ISINs(ArrayList<Kursreihe> kursreihen) {
		this.kursreihen=kursreihen;
	}
	
	public ArrayList<Kursreihe> getKursreihen(){
		return kursreihen;
	}
	
	public ArrayList<String> getISINs(){
		ArrayList<String> daten=new ArrayList<>();
		for(Kursreihe kursreihe:kursreihen) {
			daten.add(kursreihe.getISIN());
		}
		return daten;
	}
	
	public ArrayList<String> getNamen(){
		ArrayList<String> daten=new ArrayList<>();
		for(Kursreihe kursreihe:kursreihen) {
			daten.add(kursreihe.getName());
		}
		return daten;
	}
	
	@Override
	public String toString() {
		String s="";
		for(Kursreihe kursreihe:kursreihen) {
			s+=kursreihe.getISIN()+": "+kursreihe.getName()+"\n";
		}
		return s;
	}
}
