// V1C - Julian Kunst

package InleverOpdrachten.P2;

import java.util.*;
import java.sql.*;

public class OVChipkaartOracleDAOImpl extends OracleBaseDAO implements OVChipkaartDAO {

	public List<OVChipkaart> findByReiziger(int reizigerID) {
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
		}
		return OVChip;
	}

	public boolean deleteOVChip(OVChipkaart OVChip) {
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "DELETE FROM OV_CHIPKAART "
					+ "WHERE KAARTNUMMER = " + OVChip.getKaartNum();
			ResultSet rs = stat.executeQuery(query);
			return true;
		}
		return false;
	}

}
