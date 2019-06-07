// V1C - Julian Kunst

package InleverOpdrachten.P3;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args){
        try{
            ReizigerOracleDaoImpl rImpl = new ReizigerOracleDaoImpl();
            OVChipkaartOracleDAOImpl OVImpl = new OVChipkaartOracleDAOImpl();
            ProductOracleDAOImpl prImpl = new ProductOracleDAOImpl();
            
            System.out.println("findByReiziger()");
            for(OVChipkaart OV : OVImpl.findByReiziger(2)) {
            	System.out.println(OV.getKaartNum());
            }
            
            OVChipkaart OV1 = new OVChipkaart();
            OV1.setKaartNum(77777);
            OV1.setKlasse(1);
            OV1.setReizigerID(2);
            OV1.setSaldo(25.50);
            OVImpl.saveOVChip(OV1);
            
            OVChipkaart OV2 = new OVChipkaart();
            OV2.setKaartNum(88888);
            OV2.setKlasse(2);
            OV2.setReizigerID(2);
            OV2.setSaldo(69.69);
            OVImpl.saveOVChip(OV2);
            
            Product pr1 = new Product();
            pr1.setProductNaam("mooiProduct");
            pr1.setBeschrijving("Whoa... wat een beschrijving");
            pr1.setPrijs(20.35);
            pr1.setProductNum(27);
            prImpl.save(pr1);
            
            Product pr2 = new Product();
            pr2.setProductNaam("veelMooierProduct");
            pr2.setBeschrijving("Whoa... dit is ook een beschrijving?");
            pr2.setPrijs(500.69);
            pr2.setProductNum(69);
            prImpl.save(pr2);
            
            OVImpl.linkProduct(OV1, pr1);
            
            for(OVChipkaart OV : OVImpl.findByReiziger(2)) {
            	System.out.println(OV.getKaartNum());
            }
            
            System.out.println("OV kaarten met product 27");
            for(OVChipkaart OV : prImpl.findOVChipkaartByProductNum(27)) {
            	System.out.println(OV);
            }

            Reiziger r1 = new Reiziger("Henk", java.sql.Date.valueOf("1990-12-23"));
            Reiziger r2 = new Reiziger("Bob", java.sql.Date.valueOf("1969-06-16"));

            Reiziger r3 = new Reiziger();
            r3.setNaam("Frank");
            Date datum = java.sql.Date.valueOf(("2001-03-30"));
            r3.setGbDatum(datum);

            rImpl.save(r1);
            rImpl.save(r2);
            rImpl.save(r3);

            System.out.println("findAll()");
            for (Reiziger r : rImpl.findAll()){
                System.out.println(r.getNaam());
            }

            System.out.println("update()");
            r2.setNaam("Karel");
            rImpl.update(r2);

            System.out.println("findAllByGBdatum");
            for (Reiziger r : rImpl.findByGBdatum(datum.toString())){
                System.out.println(r.getNaam());
            }

            System.out.println("delete");
            rImpl.delete(r3);

            System.out.println("findAll");
            for (Reiziger r : rImpl.findAll()){
                System.out.println(r.getNaam());
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }}