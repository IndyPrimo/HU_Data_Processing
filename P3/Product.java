// V1C - Julian Kunst

package InleverOpdrachten.P3;

import java.util.ArrayList;

public class Product {
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private int productNum;
	private ArrayList<OVChipkaart> OVChipkaarten = new ArrayList<OVChipkaart>();
	
	public Product() {}
	
	public void setProductNaam(String proNaam) {
		this.productNaam =  proNaam;
	}
	
	public String getProductNaam() {
		return this.productNaam;
	}
	
	public void setBeschrijving(String besch) {
		this.beschrijving = besch;
	}
	
	public String getBeschrijving() {
		return this.beschrijving;
	}
	
	public void setPrijs(double pr) {
		this.prijs = pr;
	}
	
	public double getPrijs() {
		return this.prijs;
	}
	
	public void setProductNum(int proNum) {
		this.productNum = proNum;
	}
	
	public int getProductNum() {
		return this.productNum;
	}
	
	public ArrayList<OVChipkaart> getOVChipkaarten(){
		return this.OVChipkaarten;
	}
	
	public void voegOVToe(OVChipkaart OV) {
		if(!this.OVChipkaarten.contains(OV)) {
			this.OVChipkaarten.add(OV);
		}
	}
}
