package tradingtool.fachlogik;

import java.util.TreeMap;

public class Handelsplaetze {
	private TreeMap<Integer,String> handelsplatz=null;
	
	public Handelsplaetze() {
		handelsplatz=new TreeMap<>();
	}
	
	public void add(String id, String name) {
		handelsplatz.put(Integer.parseInt(id), name);
	}
}