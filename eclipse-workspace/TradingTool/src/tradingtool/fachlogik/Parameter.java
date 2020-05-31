package tradingtool.fachlogik;

public class Parameter {

	public static final boolean ist_lokal=true;
	public static final String server_url="http://www.frank-dopatka.de:8080/TradingTool/rest/";
	public static final String lokal_url="http://localhost:8080/TradingTool/rest/";

	public static final String eingabe_daten="D:\\TradingTool\\Eingabedaten\\";
	public static final String ausgabe_daten="D:\\TradingTool\\Ausgabedaten\\";
	
	public static final String chrome_treiber="d:\\TradingTool\\Workspace\\TradingTool\\jars\\chromedriver.exe";
	public static final int download_wartezeit=10; // Sekunden 
	
	public static final boolean db_connect_pool=false;
	public static final String db_pool="jdbc/tradingtoolPool";	
	public static final String db="tradingtool";
	public static final String db_user="DBBENUTZER";
	public static final String db_pass="DBKENNWORT";
}
