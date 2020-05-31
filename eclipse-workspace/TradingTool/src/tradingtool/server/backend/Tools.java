package tradingtool.server.backend;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;

import tradingtool.fachlogik.Kursreihe;

public class Tools {
	public static final SimpleDateFormat datumsformat = new SimpleDateFormat("dd.MM.yyyy");
	
	public static String konvertiere_DatumDinUS(String datum) {
		String[] daten=datum.split("\\.");
		if ((daten.length==3)&&(daten[2].length()==2))
				daten[2]="20"+daten[2];
		return daten[2]+"-"+daten[1]+"-"+daten[0];
	}
	
	public static String konvertiere_DatumUSinD(String datum) {
		String[] daten=datum.split("-");
		if ((daten.length==3)&&(daten[0].length()==2))
				daten[0]="20"+daten[0];
		return daten[2]+"."+daten[1]+"."+daten[0];
	}
	
	public static Date konvertiere_StringInDatum(String datum){
		if ((datum==null)||(datum==""))
			throw new RuntimeException("Datum ist ungültig!");
		try{
			if (datum.contains(".")) {
				// deutsch
				String[] daten=datum.split("\\.");
				if ((daten.length==3)&&(daten[2].length()==2))
						daten[2]="20"+daten[2];
				return datumsformat.parse(daten[0]+"."+daten[1]+"."+daten[2]);				
			}
			else {
				// US
				String[] daten=datum.split("-");
				return datumsformat.parse(daten[2]+"."+daten[1]+"."+daten[0]);				
			}
		}
		catch (Exception e){
			throw new RuntimeException("Datum ist ungültig!");
		}
	}
	
	public static String getGestern() {
    DateFormat df=new SimpleDateFormat("dd.MM.yyyy");
		final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE,-1);
    return df.format(cal.getTime());
	}
	
	public static String getHeute() {
    DateFormat df=new SimpleDateFormat("dd.MM.yyyy");
		final Calendar cal = Calendar.getInstance();
    return df.format(cal.getTime());
	}

	public static String getNaechsterTag(String datum) {
		try {
	    DateFormat df=new SimpleDateFormat("dd.MM.yyyy");
			final Calendar cal=Calendar.getInstance();
			cal.setTime(df.parse(datum));
	    cal.add(Calendar.DATE,1);
	    return df.format(cal.getTime());
		} catch (ParseException e) {
			throw new RuntimeException("getNaechsterTag: Fehler bei "+datum);
		}
	}
	
	public static String getErstesDatum(DB db,String isin) {
		String sql="SELECT MIN(datum) as erstes_datum FROM kurs WHERE isin='"+isin+"';";
		db.setSQL(sql);
		ArrayList<TreeMap<String, String>> db_daten = db.lesenJava();
		if ((db_daten==null)||(db_daten.size()==0)) return "";
		return db_daten.get(0).get("erstes_datum");
	}
	
	public static String getLetztesDatum(DB db,String isin) {
		String sql="SELECT MAX(datum) as letztes_datum FROM kurs WHERE isin='"+isin+"';";
		db.setSQL(sql);
		ArrayList<TreeMap<String, String>> db_daten = db.lesenJava();
		if ((db_daten==null)||(db_daten.size()==0)) return "";
		return db_daten.get(0).get("letztes_datum");
	}
	
	public static String getHandelsplatzName(DB db,String id_string) {
		String sql="SELECT name FROM handelsplatz WHERE id="+id_string+";";
		db.setSQL(sql);
		ArrayList<TreeMap<String, String>> db_daten = db.lesenJava();
		if ((db_daten==null)||(db_daten.size()==0)) return "---";
		return db_daten.get(0).get("name");
	}
	
	public static String getWaehrungName(DB db,String id_string) {
		String sql="SELECT name FROM waehrung WHERE id="+id_string+";";
		db.setSQL(sql);
		ArrayList<TreeMap<String, String>> db_daten = db.lesenJava();
		if ((db_daten==null)||(db_daten.size()==0)) return "---";
		return db_daten.get(0).get("name");
	}
	
	public static void addDatumswerte(DB db,Kursreihe kr) {
		try {
			kr.setVon(Tools.konvertiere_StringInDatum(Tools.getErstesDatum(db,kr.getISIN())));				
		}
		catch(Exception e) {}
		try {
			kr.setBis(Tools.konvertiere_StringInDatum(Tools.getLetztesDatum(db,kr.getISIN())));
		}
		catch(Exception e) {}
	}
}