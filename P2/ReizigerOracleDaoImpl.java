// V1C - Julian Kunst

package InleverOpdrachten.P2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDAO implements ReizigerDao {
    private List<Reiziger> reizigers = new ArrayList<Reiziger>();

    public List<Reiziger> findAll() {
        return reizigers;
    }

    public List<Reiziger> findByGBdatum(String GBdatum) {
        List<Reiziger> reizigers = new ArrayList<Reiziger>();
        OVChipkaartOracleDAOImpl impl = new OVChipkaartOracleDAOImpl();
        
        try {
        	Connection conn = getConnection();
        	Statement stat = conn.createStatement();
        	String query = "SELECT * FROM REIZIGER WHERE GEBORTEDATUM = TO_DATE('" + GBdatum + "', 'DD-MM-YYYY')";
        	ResultSet rs = stat.executeQuery(query);
        	
        	while(rs.next()) {
        		Reiziger r = new Reiziger();
        		r.setNaam(rs.getString("VOORLETTERS") + " " + rs.getString("ACHTERNAAM"));
        		r.setReizigerID(rs.getInt("REIZIGERID"));
        		
        		for(OVChipkaart OVChip : impl.findByReiziger(r.getReizigerID())) {
        			r.addOV(OVChip);
        		}
        		reizigers.add(r);
        	}
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return reizigers;
    }

    public Reiziger save(Reiziger r) {
        try {
        	int rIDInt = 0;
        	Connection conn = getConnection();
        	Statement stat = conn.createStatement();
        	String query = "SELECT * FROM REIZIGER ORDER BY REIZIGERID";
        	ResultSet rs = stat.executeQuery(query);
        	
        	while(rs.next()) {
        		rIDInt = rs.getInt("REIZIGERID");
        	}
        	rIDInt += 1;
        	r.setReizigerID(rIDInt);
        	
        	String voorletter = r.getNaam();
        	voorletter = Character.toString(voorletter.charAt(0));
        	String[] naam = r.getNaam().split(" ");
        	String achternaam = naam[1];
        	
        	String inquery = "INSERT INTO REIZIGER(REIZIGERID, VOORLETTERS, ACHTERNAAM) VALUES('" + rIDInt + "','" + voorletter + "','" + achternaam + "')";
        	
        	Statement instat = conn.createStatement();
        	instat.executeQuery(inquery);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return r;
    }

    public Reiziger update(Reiziger r) {
       try {
    	   Connection conn = getConnection();
    	   Statement stat = conn.createStatement();
    	   
    	   String voorletter = r.getNaam();
    	   voorletter = Character.toString(voorletter.charAt(0));
    	   String[] naam = r.getNaam().split(" ");
    	   String achternaam = naam[1];
       } catch(Exception e) {
    	   e.printStackTrace();
       }
    }

    public boolean delete(Reiziger r) {
        if (this.reizigers.contains(r)) {
            this.reizigers.remove(r);
            return true;
        }
        return false;
    }

    public void closeConnection() {
    }
}
