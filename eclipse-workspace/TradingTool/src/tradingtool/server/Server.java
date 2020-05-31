package tradingtool.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.glassfish.jersey.server.ResourceConfig;

import tradingtool.fachlogik.Fehler;
import tradingtool.server.backend.DB;

@Path("/")
public class Server extends ResourceConfig{
		
	@GET
	@Path("/")
	@Produces("application/json")
	@Beschreibung("Gibt alle Dienste dieses Web-Services aus.")
	public String getDienste(){
		try {
			return Rest.toJSON(new Dienste(this.getClass()));			
		}
		catch (Exception e) {
			return Rest.toJSON(new Fehler(e.getMessage()));
		}
	}

	@GET
	@Path("getISINs") 
	@Produces("application/json")
	@Beschreibung("Gibt die Basisdaten zu allen vorhandenen ISINs aus.")
	public String getISINs() {
		DB db=null;
		try{
			db=new DB();
			return Rest.toJSON(ServerImplementierung.getISINs(db,false));
		}
		catch (Exception e){
			return Rest.toJSON(new Fehler(e.getMessage()));
		}
		finally {
			if (db!=null) db.close();
		}
	}
	
	@GET
	@Path("getIndizes") 
	@Produces("application/json")
	@Beschreibung("Gibt die Basisdaten zu allen vorhandenen Indizes aus.")
	public String getIndizes() {
		DB db=null;
		try{
			db=new DB();
			return Rest.toJSON(ServerImplementierung.getISINs(db,true));
		}
		catch (Exception e){
			return Rest.toJSON(new Fehler(e.getMessage()));
		}
		finally {
			if (db!=null) db.close();
		}
	}
	
	@GET
	@Path("getISINvonName/{name}")
	@Consumes("text/plain")
	@Produces("application/json")
	@Beschreibung("Gibt eine Liste der ISINs zurueck, die den eingegebenen Namen enthalten.")
	public String getISINvonName(
			@PathParam("name")String name) {
		DB db=null;
		try{
			db=new DB();
			return Rest.toJSON(ServerImplementierung.getISINvonName(db,name));
		}
		catch (Exception e){
			return Rest.toJSON(new Fehler(e.getMessage()));
		}
		finally {
			if (db!=null) db.close();
		}
	} 
	
	@GET
	@Path("getIndexKomponenten/{isin}")
	@Consumes("text/plain")
	@Produces("application/json")
	@Beschreibung("Gibt eine Liste der Komponenten aus der vorgegebenen ISIN eines Indexes aus.")
	public String getIndexKomponenten(
			@PathParam("isin")String isin) {
		DB db=null;
		try{
			db=new DB();
			return Rest.toJSON(ServerImplementierung.getIndexKomponenten(db,isin));
		}
		catch (Exception e){
			return Rest.toJSON(new Fehler(e.getMessage()));
		}
		finally {
			if (db!=null) db.close();
		}
	} 

	@GET
	@Path("getKursreihe/{isin}")
	@Consumes("text/plain")
	@Produces("application/json")
	@Beschreibung("Gibt Daten und historische Kurse zu dieser ISIN aus.")
	public String getKursreihe(
			@PathParam("isin")String isin) {
		DB db=null;
		try{
			db=new DB();
			return Rest.toJSON(ServerImplementierung.getKursreihe(db,isin,null,null));
		}
		catch (Exception e){
			return Rest.toJSON(new Fehler(e.getMessage()));
		}
		finally {
			if (db!=null) db.close();
		}
	} 
	
	@GET
	@Path("getKursreihe/{isin}/{von}/{bis}")
	@Consumes("text/plain")
	@Produces("application/json")
	@Beschreibung("Gibt Daten und historische Kurse zu dieser ISIN in dem Datumsintervall zwischen 'von' und 'bis' aus.")
	public String getKursreihe(
			@PathParam("isin")String isin,
			@PathParam("von")String von,
			@PathParam("bis")String bis) {
		DB db=null;
		try{
			db=new DB();
			return Rest.toJSON(ServerImplementierung.getKursreihe(db,isin,von,bis));
		}
		catch (Exception e){
			return Rest.toJSON(new Fehler(e.getMessage()));
		}
		finally {
			if (db!=null) db.close();
		}
	}
	
	@GET
	@Path("getWaehrungen") 
	@Produces("application/json")
	@Beschreibung("Gibt alle Waehrungen aus.")
	public String getWaehrungen() {
		DB db=null;
		try{
			db=new DB();
			return Rest.toJSON(ServerImplementierung.getWaehrungen(db));
		}
		catch (Exception e){
			return Rest.toJSON(new Fehler(e.getMessage()));
		}
		finally {
			if (db!=null) db.close();
		}
	}
	
	@GET
	@Path("getHandelsplaetze") 
	@Produces("application/json")
	@Beschreibung("Gibt alle Handelsplaetze aus.")
	public String getHandelsplaetze() {
		DB db=null;
		try{
			db=new DB();
			return Rest.toJSON(ServerImplementierung.getHandelsplaetze(db));
		}
		catch (Exception e){
			return Rest.toJSON(new Fehler(e.getMessage()));
		}
		finally {
			if (db!=null) db.close();
		}
	}
}