package tradingtool.server;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

import javax.ws.rs.Path;

public class Dienste {
	private ArrayList<Dienst> dienste=new ArrayList<>(); 

	public Dienste(Class<?> c) {
		for(Method m:c.getMethods()){
			Path pfad=m.getAnnotation(javax.ws.rs.Path.class);
			Beschreibung beschreibung=m.getAnnotation(Beschreibung.class);
			if ((pfad!=null)&&(beschreibung!=null)) {
				dienste.add(new Dienst(pfad.value(),beschreibung.value()));				
			}
		}
		Collections.sort(dienste);
	}

	public ArrayList<Dienst> getDienste() {
		return dienste;
	}
	
	private class Dienst implements Comparable<Dienst>{
		private String pfad;
		@SuppressWarnings("unused")
		private String beschreibung;
		
		public Dienst(String pfad,String beschreibung) {
			this.pfad=pfad;
			this.beschreibung=beschreibung;
		}

		@Override
		public int compareTo(Dienst o) {
			return pfad.compareTo(o.pfad);
		}
	}
}