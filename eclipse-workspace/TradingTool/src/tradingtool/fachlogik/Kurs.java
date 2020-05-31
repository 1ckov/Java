package tradingtool.fachlogik;
import java.io.Serializable;
import java.util.Date;

import tradingtool.server.backend.Tools;

import java.text.DecimalFormat;

public class Kurs implements Serializable, Cloneable, Comparable<Kurs>{
	private static final long serialVersionUID = 1L;

	private static final DecimalFormat nks2 = new DecimalFormat("0.00");
	private static final DecimalFormat nks4 = new DecimalFormat("0.0000");
	private static final DecimalFormat nks6 = new DecimalFormat("0.000000");

	private double o=0.0;
	private double c=0.0; // liegen keine Kerzendaten vor, so wird immer der Schlusskurs genommen
	private double h=0.0;
	private double l=0.0;

	private Date datum;
	private long vol;

	public Kurs(String datum,String wert){
		setDatum(datum);
		setVolumen(0);
		this.c=toDouble(wert);
		istKerze();
	}
	public Kurs(String datum,String open,String close,String high, String low){
		this(datum,close);
		this.o=toDouble(open);
		this.h=toDouble(high);
		this.l=toDouble(low);
		istKerze();
	}
	
	public long getVolumen() {
		return vol;
	}
	public void setVolumen(long volumen) {
		if (volumen<0)
			this.vol=0;
		else
			this.vol = volumen;
	}

	public boolean istKerze(){
		boolean kerze=true;
		if((this.o<=0.0)&&(this.h<=0.0)&&(this.l<=0.0)) kerze=false;
		if (this.o>this.h) kerze=false;
		if (this.o<this.l) kerze=false; 
		if (this.c>this.h) kerze=false;
		if (this.c<this.l) kerze=false;
		if (this.h<this.l) kerze=false;
		if(!kerze) {
			this.o=0;
			this.h=0;
			this.l=0;
		}
		return kerze;
	}
	
	public Date getDatum() {
		return datum;
	}
	public String getDatumString() {
		return Tools.datumsformat.format(datum);
	}

	public double getHigh() {
		return h;
	}
	public String getHigh(Enum_Genauigkeit genauigkeit) {
		return toString(h,genauigkeit);
	}
	public double getLow() {
		return l;
	}
	public String getLow(Enum_Genauigkeit genauigkeit) {
		return toString(l,genauigkeit);
	}
	public double getOpen() {
		return o;
	}
	public String getOpen(Enum_Genauigkeit genauigkeit) {
		return toString(o,genauigkeit);
	}
	public double getClose() {
		return c;
	}
	public String getClose(Enum_Genauigkeit genauigkeit) {
		return toString(c,genauigkeit);
	}
	public double getWert() {
		return getClose();
	}
	public String getWert(Enum_Genauigkeit genauigkeit) {
		return getClose(genauigkeit);
	}
	
	public String getGewinnAbsolutString() {
		return getGewinnAbsolutString(Enum_Genauigkeit.ZWEI);
	}
	public String getGewinnAbsolutString(Enum_Genauigkeit genauigkeit) {
		return Kurs.toString(getGewinnAbsolutDouble(),genauigkeit);
	}
	public double getGewinnAbsolutDouble() {
		return getClose()-getOpen();
	}
	
	public String getGewinnProzentualString() {
		return getGewinnProzentualString(Enum_Genauigkeit.ZWEI);
	}
	public String getGewinnProzentualString(Enum_Genauigkeit genauigkeit) {
		return Kurs.toString(getGewinnProzentualDouble(),genauigkeit);
	}
	public double getGewinnProzentualDouble() {
		return ((getClose()/getOpen())-1)*100;
	}
	
	public static String toString(double wert,Enum_Genauigkeit genauigkeit){
		if (genauigkeit==null) return toString(wert);
		String wertString;
		switch(genauigkeit){
		case SECHS:
			wertString=nks6.format(wert);
			break;
		case VIER:
			wertString=nks4.format(wert);
			break;
		default:
			wertString=nks2.format(wert);
			break;
		}
		return wertString.replace(',','.');
	}
	public static String toString(double wert){
		return toString(wert,Enum_Genauigkeit.ZWEI);
	}

	@Override
	public String toString(){
		StringBuffer s=new StringBuffer();
		s.append(getDatumString());
		if (istKerze())
			s.append("-(O:"+getOpen()+",C:"+getClose()+",H:"+getHigh()+",L:"+getLow()+")");
		else
			s.append("-"+getWert());
		if (getVolumen()>0)
			s.append("-"+getVolumen());
		return s.toString();
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		if (o==null) return false;
		if (getClass()!=o.getClass()) return false;
		return hashCode()==o.hashCode();
	}
	
	@Override
	public Kurs clone(){
		Kurs k=new Kurs(getDatumString(),""+o,""+c,""+h,""+l);
		k.setVolumen(this.getVolumen());
		return k;
	}

	@Override
	public int compareTo(Kurs k) {
		if (k==null)
			throw new RuntimeException("Kurs darf nicht NULL sein!");
		if (this.datum.after(k.datum)) return 1;
		if (this.datum.before(k.datum)) return -1;
		return 0;
	}
	
	private void setDatum(String datum){
		this.datum=Tools.konvertiere_StringInDatum(datum);
	}
	
	private double toDouble(String s) {
		if ((s==null)||("".equals(s))) s="0.0";
		s=s.replace(',','.');
		return Double.parseDouble(s);
	}
}
