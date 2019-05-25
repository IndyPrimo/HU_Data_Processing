// V1C - Julian Kunst

package InleverOpdrachten.P1;

import java.util.Date;

public class Reiziger{
    private int reizigerID;
    private String naam;
    private Date gbdatum;

    public Reiziger(){

    }

    public Reiziger(String nm, Date dt){
        this.naam = nm;
        this.gbdatum = gbdatum;
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
}
