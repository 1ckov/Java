package tradingtool.fachlogik;

import java.util.TreeMap;

public class Waehrungen {
	private TreeMap<Integer,String> waehrungen=null;
	
	public Waehrungen() {
		waehrungen=new TreeMap<>();
	}
	
	public void add(String id, String name) {
		waehrungen.put(Integer.parseInt(id), name);
	}
}