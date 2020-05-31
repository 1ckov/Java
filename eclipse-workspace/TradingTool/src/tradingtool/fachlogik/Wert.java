package tradingtool.fachlogik;

import java.util.Date;

import tradingtool.server.backend.Tools;

public class Wert {
	private Date datum;
	private double wert;
	
	public Wert(Date datum,double wert) {
		this.datum=datum;
		this.wert=wert;
	}
	
	public double getWert() {
		return wert;
	}
	public Date getDatum() {
		return datum;
	}
	
	@Override
	public String toString() {
		return Tools.datumsformat.format(datum)+": "+Kurs.toString(wert,Enum_Genauigkeit.VIER);
	}
}