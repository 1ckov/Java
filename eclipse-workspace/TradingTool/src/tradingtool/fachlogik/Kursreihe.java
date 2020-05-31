package tradingtool.fachlogik;
import java.util.ArrayList;
import java.util.Date;

public class Kursreihe {
	private ArrayList<Kurs> kurse=new ArrayList<>();
	private int kurse_anzahl=0;
	private String isin="";
	private String name="";
	private boolean ist_index=false;
	private Date von=null;
	private Date bis=null;
	private Enum_Waehrung waehrung=null;
	private Enum_Handelsplatz handelsplatz=null;
	
	public Kursreihe(String isin,String name,Enum_Handelsplatz handelsplatz,Enum_Waehrung waehrung,boolean ist_index){
		if ((isin==null)||isin.length()!=12)
			throw new RuntimeException("ISIN ungueltig!");
		if ((name==null)||name.length()<2)
			throw new RuntimeException("Name ungueltig!");
		this.isin=isin;
		this.name=name;
		this.ist_index=ist_index;
		this.handelsplatz=handelsplatz;
		this.waehrung=waehrung;
	}
	
	public ArrayList<Kurs> getAlleKurse() {
		return kurse;
	}
	
	public void setKurse(ArrayList<Kurs> kurse) {
		this.kurse=kurse;
		if (kurse.size()==0) {
			setVon(null);
			setBis(null);
			kurse_anzahl=0;
		}
		else {
			setVon(kurse.get(0).getDatum());
			setBis(kurse.get(kurse.size()-1).getDatum());
			kurse_anzahl=kurse.size();
		}
	}
	public void setVon(Date von) {
		this.von=von;
	}
	public void setBis(Date bis) {
		this.bis=bis;
	}
	
	public String getISIN() {
		return isin;
	}
	public String getName() {
		return name;
	}
	public Date getVon() {
		return von;
	}
	public Date getBis() {
		return bis;
	}
	public Enum_Waehrung getWaehrung() {
		return waehrung;
	}
	public Enum_Handelsplatz getHandelsplatz() {
		return handelsplatz;
	} 
	public boolean binIndex() {
		return ist_index;
	}

	public int getAnzahlKurse() {
		return kurse_anzahl;
	}
}