// V1C - Julian Kunst

package InleverOpdrachten.P2;

import java.util.Date;

public class OVChipkaart {
	private int kaartNum;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private int reizigerID;
	
	public void setKaartNum(int kN) {
		this.kaartNum = kN;
	}
	
	public int getKaartNum() {
		return this.kaartNum;
	}
	
	public void setGeldigTot(Date gT) {
		this.geldigTot = gT;
	}
	
	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}
	
	public int getKlasse() {
		return this.klasse;
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
}
