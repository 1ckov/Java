package tradingtool.server;

import java.util.ArrayList;
import java.util.TreeMap;

import tradingtool.fachlogik.Enum_Handelsplatz;
import tradingtool.fachlogik.Enum_Waehrung;
import tradingtool.fachlogik.Handelsplaetze;
import tradingtool.fachlogik.ISINs;
import tradingtool.fachlogik.Kurs;
import tradingtool.fachlogik.Kursreihe;
import tradingtool.fachlogik.Waehrungen;
import tradingtool.server.backend.DB;
import tradingtool.server.backend.Tools;

public class ServerImplementierung {

	public static ISINs getISINs(DB db,boolean nur_indizes) {
		String sql="";
		ISINs isins=new ISINs();
		ArrayList<TreeMap<String, String>> db_daten=null;
		if (nur_indizes) {
			sql="SELECT * FROM kursreihe WHERE ist_index=1 ORDER BY name ASC;";
			db.setSQL(sql);
		}
		else {
			sql="SELECT * FROM kursreihe ORDER BY name ASC;";
			db.setSQL(sql);			
		}
		db_daten=db.lesenJava();
		if ((db_daten==null)||(db_daten.size()==0))
			throw new RuntimeException("Keine Daten vorhanden!");
		for(TreeMap<String, String> datensatz:db_daten) {
			String isin_db=datensatz.get("isin");
			String name=datensatz.get("name");
			Enum_Handelsplatz handelsplatz=Enum_Handelsplatz.vonZahl(Integer.parseInt(datensatz.get("handelsplatz")));
			Enum_Waehrung waehrung=Enum_Waehrung.vonZahl(Integer.parseInt(datensatz.get("waehrung")));
			boolean ist_index=false;
			if ("1".equals(datensatz.get("ist_index")))
				ist_index=true;
			Kursreihe kr=new Kursreihe(isin_db,name,handelsplatz,waehrung,ist_index);
			Tools.addDatumswerte(db,kr);
			isins.getKursreihen().add(kr);
		}
		return isins;
	}
	
	public static ISINs getISINvonName(DB db, String name) {
		String sql="";
		ISINs isins=new ISINs();
		ArrayList<TreeMap<String, String>> db_daten=null;
		sql="SELECT * FROM kursreihe WHERE name LIKE '%"+name+"%' ORDER BY name ASC;";
		db.setSQL(sql);
		db_daten=db.lesenJava();
		if ((db_daten==null)||(db_daten.size()==0))
			throw new RuntimeException("Keine Daten vorhanden!");
		for(TreeMap<String, String> datensatz:db_daten) {
			String isin=datensatz.get("isin");
			String name_db=datensatz.get("name");
			Enum_Handelsplatz handelsplatz=Enum_Handelsplatz.vonZahl(Integer.parseInt(datensatz.get("handelsplatz")));
			Enum_Waehrung waehrung=Enum_Waehrung.vonZahl(Integer.parseInt(datensatz.get("waehrung")));
			boolean ist_index=false;
			if ("1".equals(datensatz.get("ist_index")))
				ist_index=true;
			Kursreihe kr=new Kursreihe(isin,name_db,handelsplatz,waehrung,ist_index);
			Tools.addDatumswerte(db,kr);
			isins.getKursreihen().add(kr);
		}
		return isins;
	}
	
	public static ISINs getIndexKomponenten(DB db, String isin) {
		String sql="";
		ISINs isins=new ISINs();
		ArrayList<TreeMap<String, String>> db_daten=null;
		sql="SELECT * FROM kursreihe WHERE kursreihe.isin IN (SELECT isin_komponente FROM indexkomponente WHERE isin_index=?) ORDER BY kursreihe.name ASC;";
		db.setSQL(sql);
		db.setString(isin);
		db_daten=db.lesenJava();
		if ((db_daten==null)||(db_daten.size()==0))
			throw new RuntimeException("Keine Daten vorhanden!");
		for(TreeMap<String, String> datensatz:db_daten) {
			String isin_db=datensatz.get("isin");
			String name=datensatz.get("name");
			Enum_Handelsplatz handelsplatz=Enum_Handelsplatz.vonZahl(Integer.parseInt(datensatz.get("handelsplatz")));
			Enum_Waehrung waehrung=Enum_Waehrung.vonZahl(Integer.parseInt(datensatz.get("waehrung")));
			boolean ist_index=false;
			if ("1".equals(datensatz.get("ist_index"))) ist_index=true;
			Kursreihe kr=new Kursreihe(isin_db,name,handelsplatz,waehrung,ist_index);
			Tools.addDatumswerte(db,kr);
			isins.getKursreihen().add(kr);
		}
		return isins;
	}
	
	public static Kursreihe getKursreihe(DB db,String isin,String von,String bis) {
		String sql="SELECT * FROM kursreihe WHERE isin=?;";
		db.setSQL(sql);
		db.setString(isin);
		ArrayList<TreeMap<String, String>>  db_daten=db.lesenJava();
		if ((db_daten==null)||(db_daten.size()==0))
			throw new RuntimeException("Keine Daten zu dieser ISIN vorhanden!");
		String name=db_daten.get(0).get("name");
		Enum_Handelsplatz handelsplatz=Enum_Handelsplatz.vonZahl(Integer.parseInt(db_daten.get(0).get("handelsplatz")));
		Enum_Waehrung waehrung=Enum_Waehrung.vonZahl(Integer.parseInt(db_daten.get(0).get("waehrung")));
		boolean ist_index=false;
		if ("1".equals(db_daten.get(0).get("ist_index"))) ist_index=true;
		Kursreihe kr=new Kursreihe(isin,name,handelsplatz,waehrung,ist_index);
		getKurse(db,kr,von,bis);
		return kr;
	}
	
	private static void getKurse(DB db, Kursreihe kr,String von,String bis) {
		String sql="";
		if ((von==null)||(bis==null)) {
			sql="SELECT * FROM kurs WHERE isin=? ORDER BY datum ASC;";
			db.setSQL(sql);
			db.setString(kr.getISIN());			
		}
		else {
			sql="SELECT * FROM kurs WHERE isin=? AND datum>=? AND datum<=? ORDER BY datum ASC;";
			db.setSQL(sql);
			db.setString(kr.getISIN());	
			db.setString(Tools.konvertiere_DatumDinUS(von));
			db.setString(Tools.konvertiere_DatumDinUS(bis));
		}
		ArrayList<TreeMap<String, String>> db_daten=db.lesenJava();
		ArrayList<Kurs> kurs_daten=new ArrayList<>();
		for(TreeMap<String, String> datensatz:db_daten) {
			String datum=datensatz.get("datum");
			String open=datensatz.get("open");
			String close=datensatz.get("close");
			String high=datensatz.get("high");
			String low=datensatz.get("low");
      Kurs k=new Kurs(datum,open,close,high,low);
      k.setVolumen(Long.parseLong(datensatz.get("volumen")));
      kurs_daten.add(k);
		}
		kr.setKurse(kurs_daten);
	}

	public static Waehrungen getWaehrungen(DB db) {
		Waehrungen waehrungen=new Waehrungen();
		db.setSQL("SELECT * FROM waehrung ORDER BY id ASC;");
		ArrayList<TreeMap<String, String>>  db_daten=db.lesenJava();
		if ((db_daten==null)||(db_daten.size()==0))
			throw new RuntimeException("Keine Daten vorhanden!");
		for(TreeMap<String, String> datensatz:db_daten) {
			waehrungen.add(datensatz.get("id"),datensatz.get("name"));
		}
		return waehrungen;
	}

	public static Handelsplaetze getHandelsplaetze(DB db) {
		Handelsplaetze handelsplaetze=new Handelsplaetze();
		db.setSQL("SELECT * FROM handelsplatz ORDER BY id ASC;");
		ArrayList<TreeMap<String, String>>  db_daten=db.lesenJava();
		if ((db_daten==null)||(db_daten.size()==0))
			throw new RuntimeException("Keine Daten vorhanden!");
		for(TreeMap<String, String> datensatz:db_daten) {
			handelsplaetze.add(datensatz.get("id"),datensatz.get("name"));
		}
		return handelsplaetze;
	}
}