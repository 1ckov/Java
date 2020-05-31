package tradingtool.server.backend;

import java.io.FileInputStream;
import java.util.Properties;

public class Parameter {
	private static Properties p=null;
	private static String datei="TradingTool.xml";

	static {
		p=new Properties();
		try {
			p.loadFromXML(new FileInputStream(datei));
		} catch (Exception e) {
			System.err.println("Fehler beim Laden der Konfigurationsdatei "+datei);
			System.exit(-1);
		}
	}

	public static String get(String parameter) {
		return p.getProperty(parameter);
	}
}