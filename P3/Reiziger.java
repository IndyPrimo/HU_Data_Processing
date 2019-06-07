// V1C - Julian Kunst

package InleverOpdrachten.P3;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Reiziger{
    private int reizigerID;
    private String naam;
    private Date gbdatum;
    private List<OVChipkaart> OVKaarten = new ArrayList<OVChipkaart>();

    public Reiziger(){}

    public Reiziger(String nm, Date d){
        this.naam = nm;
        this.gbdatum = d;
    }
    
    public int getReizigerID() {
    	return reizigerID;
    }

    public void setReizigerID(int reizigerID){
        this.reizigerID = reizigerID;
    }

    public String getNaam(){
        return naam;
    }

    public void setNaam(String nm){
        this.naam = nm;
    }

    public Date getGbDatum(){
        return gbdatum;
    }

    public void setGbDatum(Date d){
        this.gbdatum = d;
    }
    
    public void addOV(OVChipkaart OVChip){
    	if (!this.OVKaarten.contains(OVChip)) {
    		this.OVKaarten.add(OVChip);
    	}
    }
}
