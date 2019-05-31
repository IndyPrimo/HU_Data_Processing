// V1C - Julian Kunst

package InleverOpdrachten.P2;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args){
        try{
            ReizigerOracleDaoImpl impl = new ReizigerOracleDaoImpl();
            OVChipkaartOracleDAOImpl OVImpl = new OVChipkaartOracleDAOImpl();
            
            OVChipkaart OV1 = new OVChipkaart();
            OV1.setKaartNum(77777);
            OV1.setKlasse(1);
            OV1.setReizigerID(2);
            OV1.setSaldo(25.50);
            OVImpl.saveOVChip(OV1);
            
            for(OVChipkaart OV : OVImpl.findByReiziger(2)) {
            	System.out.println(OV.getKaartNum());
            }

            Reiziger r1 = new Reiziger("Henk", java.sql.Date.valueOf("1990-12-23"));
            Reiziger r2 = new Reiziger("Bob", java.sql.Date.valueOf("1969-06-16"));

            Reiziger r3 = new Reiziger();
            r3.setNaam("Frank");
            Date datum = java.sql.Date.valueOf(("2001-03-30"));
            r3.setGbDatum(datum);

            impl.save(r1);
            impl.save(r2);
            impl.save(r3);

            System.out.println("findAll()");
            for (Reiziger r : impl.findAll()){
                System.out.println(r.getNaam());
            }

            System.out.println("update()");
            r2.setNaam("Karel");
            impl.update(r2);

            System.out.println("findAllByGBdatum");
            for (Reiziger r : impl.findByGBdatum(datum.toString())){
                System.out.println(r.getNaam());
            }

            System.out.println("delete");
            impl.delete(r3);

            System.out.println("findAll");
            for (Reiziger r : impl.findAll()){
                System.out.println(r.getNaam());
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }}