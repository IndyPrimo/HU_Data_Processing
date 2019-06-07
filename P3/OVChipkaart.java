// V1C - Julian Kunst

package InleverOpdrachten.P3;

import java.util.ArrayList;
import java.util.Date;

public class OVChipkaart {
	private int kaartNum;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private int reizigerID;
	private ArrayList<Product> producten = new ArrayList<Product>();
	
	public OVChipkaart() {}
	
	public int getKaartNum() {
		return this.kaartNum;
	}
	
	public void setKaartNum(int kN) {
		this.kaartNum = kN;
	}
	
	public Date getGeldigTot() {
		return this.geldigTot;
	}
	
	public void setGeldigTot(Date gT) {
		this.geldigTot = gT;
	}
	
	public int getKlasse() {
		return this.klasse;
	}
	
	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}
	
	public void setSaldo(double sal) {
		this.saldo = sal;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setReizigerID(int rID) {
		this.reizigerID = rID;
	}
	
	public int getReizigerID() {
		return reizigerID;
	}
	
	public void voegProductToe(Product pr) {
		if (!this.producten.contains(pr)) {
			this.producten.add(pr);
		}
	}
}
