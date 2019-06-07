// V1C - Julian Kunst

package InleverOpdrachten.P3;

import java.util.*;
import java.sql.*;

public class OVChipkaartOracleDAOImpl extends OracleBaseDAO implements OVChipkaartDAO {

	public List<OVChipkaart> findByReiziger(int reizigerID) {
		ProductOracleDAOImpl db = new ProductOracleDAOImpl();
		List<OVChipkaart> OVByR = new ArrayList<OVChipkaart>();
		
		try {
			Connection myConn = getConnection();
			Statement myStat = myConn.createStatement();
			String query = "SELECT * FROM OV_CHIPKAART WHERE REIZIGERID = " + reizigerID;
			ResultSet rs = myStat.executeQuery(query);
			
			while(rs.next()) {
				OVChipkaart OV = new OVChipkaart();
				OV.setSaldo(rs.getFloat("SALDO"));
				OV.setReizigerID(rs.getInt("REIZIGERID"));
				OV.setKaartNum(rs.getInt("KAARTNUMMER"));
				
				for(Product pr : db.findByKaartNum(OV.getKaartNum())) {
					OV.voegProductToe(pr);
				}
				OVByR.add(OV);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OVByR;
	}

	public OVChipkaart saveOVChip(OVChipkaart OVChip) {
		
		String date = "31-12-2019";
		
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "INSERT INTO "
					+ "OV_CHIPKAART(KAARTNUMMERS, KLASSE, SALDO, REIZIGERID, GELDIGTOT)"
					+ "VALUES('" + OVChip.getKaartNum() + "','" + OVChip.getKlasse() + "','" + OVChip.getSaldo() + "','" + OVChip.getReizigerID() + "', TO_DATE('" + date + "', 'DD-MM-YYYY'))";
			ResultSet rs = stat.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OVChip;
	}

	public OVChipkaart updateOVChip(OVChipkaart OVChip) {
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "UPDATE OV_CHIPKAART "
					+ "SET KAARTNUMMER = '" + OVChip.getKaartNum() + "' "
					+ "KLASSE = '" + OVChip.getKlasse() + "' "
					+ "SALDO = '" + OVChip.getSaldo() + "' "
					+ "REIZIGERID = '" + OVChip.getReizigerID() + "' "
					+ "WHERE REIZIGERID = '" + OVChip.getReizigerID() + "'";
			ResultSet rs = stat.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OVChip;
	}
	
	public boolean linkProduct(OVChipkaart OV, Product pr) {
		
		int OVProductID = 11;
		String lastUp = "31-12-2017";
		
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "INSERT INTO OV_CHIPKAART_PRODUCT(OVPRODUCTID, KAARTNUMMER, PRODUCTNUMMER, LASTUPDATE, REISPRODUCTSTATUS) VALUES('"
					+  OVProductID + "', "
					+ OV.getKaartNum() + ", "
					+ pr.getProductNum() + ", "
					+ "TO_DATE('" + lastUp + "', 'DD-MM-YYYY" + ", 'ACTIEF')";
			ResultSet rs = stat.executeQuery(query);
			return true; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteOVChip(OVChipkaart OVChip) {
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "DELETE FROM OV_CHIPKAART "
					+ "WHERE KAARTNUMMER = " + OVChip.getKaartNum();
			ResultSet rs = stat.executeQuery(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
