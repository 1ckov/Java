package tradingtool.server.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	private PreparedStatement ps=null;
	private Connection con=null;
	private int counter_prepared=1;

	public DB(){
		try {
			if (Boolean.parseBoolean(Parameter.get("db_connect_pool"))) connectPool();
			if (con==null) connectJDBC();
		} catch (Exception e) {
			throw new RuntimeException("Der DB-Zugang ist nicht vorhanden!");
		} 
	}
	
	private void connectPool(){
		try { 
			InitialContext ctx=new InitialContext();
			DataSource myDataSource=(DataSource)ctx.lookup(Parameter.get("db_pool"));
			con=myDataSource.getConnection();		
		} catch (Exception e) {
			System.out.println("connectPool: "+e.getMessage());
		} 
	}
	
	private void connectJDBC() throws SQLException {
		String kommando=
				"jdbc:mysql://localhost/"+Parameter.get("db")+
				"?user="+Parameter.get("db_user")+
				"&password="+Parameter.get("db_pass")+
				"&serverTimezone=UTC";
		con = DriverManager.getConnection(kommando);
	}
	
	public void setSQL(String sql){
		try {
			counter_prepared=1;
			ps=con.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL-Fehler: "+e.getMessage());
		} 
	}
	
	public void close(){
		finalize();
	}
	
	public void setString(char c){
		try {
			setString(""+c);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB setString '"+c+"': "+e.getMessage());
		}
	}
	public void setString(String s){
		try {
			ps.setString(counter_prepared++,s);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB setString '"+s+"': "+e.getMessage());
		}
	}

	public void setInt(char c){
		try {
			setInt(Integer.parseInt(""+c));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB setInt '"+c+"': "+e.getMessage());
		}
	}
	public void setInt(String s){
		try {
			setInt(Integer.parseInt(s));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB setInt '"+s+"': "+e.getMessage());
		}
	}
	public void setInt(int i){
		try {
			ps.setInt(counter_prepared++,i);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB setInt '"+i+"': "+e.getMessage());
		}
	}
	
	public void setLong(char c){
		try {
			setLong(Long.parseLong(""+c));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB setLong '"+c+"': "+e.getMessage());
		}
	}
	public void setLong(String s){
		try {
			setLong(Long.parseLong(s));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB setLong '"+s+"': "+e.getMessage());
		}
	}
	public void setLong(long l){
		try {
			ps.setLong(counter_prepared++,l);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB setLong '"+l+"': "+e.getMessage());
		}
	}

	public void setDouble(String s){
		try {
			setDouble(Double.parseDouble(s));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB setDouble '"+s+"': "+e.getMessage());
		}
	}
	public void setDouble(double d){
		try {
			ps.setDouble(counter_prepared++,d);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB setDouble '"+d+"': "+e.getMessage());
		}
	}
	
	public void schreiben(){
		try {
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB schreiben: "+e.getMessage());
		}
	}
	
	public ArrayList<TreeMap<String, String>> lesenJava() {
		try {
			return konvertiereJava(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB lesenJava: "+e.getMessage());
		}
	}

	public String lesenXML() {
		try {
			return konvertiereXML(ps.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB lesenXML: "+e.getMessage());
		}
	}
	
	// TODO lesenJSON
	
	public static ArrayList<TreeMap<String, String>> konvertiereJava(ResultSet rs) throws SQLException {
		ArrayList<TreeMap<String, String>> daten=new ArrayList<>();
		int anz_spalten=rs.getMetaData().getColumnCount();
		if (anz_spalten==0) return daten;
		while (rs.next()) {
			TreeMap<String, String> datensatz=new TreeMap<>();
			for (int i=1;i<=anz_spalten;i++) {
				String name=rs.getMetaData().getColumnLabel(i);
				String wert=rs.getString(name);
				if (wert!=null)
					datensatz.put(name,wert);					
				else
					datensatz.put(name,"");					
			}
			daten.add(datensatz);
		}
		return daten;
	}

	public static String konvertiereXML(ResultSet rs) throws SQLException {
		StringBuffer sb=new StringBuffer();
		int anz_spalten=rs.getMetaData().getColumnCount();
		if (anz_spalten==0) return "<daten/>\n";
		sb.append("<daten>\n");
		while (rs.next()) {
			sb.append("<datensatz>\n");
			for (int i=1;i<=anz_spalten;i++) {
				String name=rs.getMetaData().getColumnLabel(i);
				String wert=rs.getString(name);
				if (wert!=null)
					sb.append("<"+name+">"+wert+"</"+name+">\n");
				else
					sb.append("<"+name+"></"+name+">\n");
			}
			sb.append("</datensatz>\n");
		}
		sb.append("</daten>\n");
		return sb.toString();
	}
	
	@Override
	public void finalize(){
		try {
			ps.close();
		} catch (Exception e) {}
		ps=null;
		try {
			con.close();
		} catch (Exception e) {}
		con=null;
	}
}