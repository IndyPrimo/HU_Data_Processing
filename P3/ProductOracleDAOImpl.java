// V1C - Julian Kunst

package InleverOpdrachten.P3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductOracleDAOImpl extends OracleBaseDAO implements ProductDAO {
	
	public List<Product> findByKaartNum(int kaartNum){
		List<Product> producten = new ArrayList<Product>();
		
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "SELECT * FROM OV_CHIPKAART_PRODUCT OV LEFT JOIN PRODUCT PR ON (OV.PRODUCTNUMMER = PR.PRODUCTNUMMER) WHERE OV.KAARTNUMMER = "
						+ kaartNum;
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				Product pr = new Product();
				pr.setProductNum(rs.getInt("PRODUCTNUMMER"));
				pr.setProductNaam(rs.getString("PRODUCTNAAM"));
				pr.setBeschrijving(rs.getString("BESCHRIJVING"));
				pr.setPrijs(rs.getFloat("PRIJS"));
				producten.add(pr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producten;
	}
	
	public Product save(Product pr) {
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "INSERT INTO PRODUCT(PRODUCTNUMMER, PRODUCTNAAM, BESCHRIJVING, PRIJS) VALUES('"
					+ pr.getProductNum() + "', '"
					+ pr.getBeschrijving() + "', '"
					+ pr.getPrijs() + ")";
			ResultSet rs = stat.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pr;
	}
	
	public Product update(Product pr) {
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "UPDATE PRODUCT SET PRODUCTNUMMER = '"
					+ pr.getProductNum() + "' PRODUCTNAAM = '"
					+ pr.getProductNaam() + "' BESCHRIJVING = '"
					+ pr.getBeschrijving() + "' PRIJS = '"
					+ pr.getPrijs() + "' ";
			ResultSet rs = stat.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pr;
	}
	
	public Product findByProductNum(int proNum) {
		Product foundPr = new Product();
		
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "SELECT * FROM PRODUCT WHERE PRODUCTNUMMER = "
					+ proNum;
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				Product pr = new Product();
				pr.setProductNaam(rs.getString("PRODUCTNAAM"));
				pr.setBeschrijving(rs.getString("BESCHRIJVING"));
				pr.setPrijs(rs.getDouble("PRIJS"));
				pr.setProductNum(rs.getInt("PRODUCTNUMMER"));
				foundPr = pr;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foundPr;
	}
	
	public ArrayList<OVChipkaart> findOVChipkaartByProductNum(int proNum){
		ArrayList<OVChipkaart> kaarten = new ArrayList<OVChipkaart>();
		Product pr = this.findByProductNum(proNum);
		
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "SELECT KAARTNUMMER FROM OV_CHIPKAART_PRODUCT WHERE PRODUCTNUMMER = "
					+ proNum;
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				int kaartNum = rs.getInt("KAARTNUMMER");
				Statement collStat = conn.createStatement();
				String collQuery = "SELECT * FROM OV_CHIPKAART WHERE KAARTNUMMER = "
						+ kaartNum;
				ResultSet collRs = collStat.executeQuery(collQuery);
				
				while(collRs.next()) {
					OVChipkaart OV = new OVChipkaart();
					OV.setKaartNum(kaartNum);
					OV.setGeldigTot(collRs.getDate("GELDIGTOT"));
					OV.setKlasse(collRs.getInt("KLASSE"));
					OV.setSaldo(collRs.getDouble("SALDO"));
					OV.setReizigerID(collRs.getInt("REIZIGERID"));
					pr.voegOVToe(OV);
					kaarten.add(OV);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return kaarten;
	}
	
	public boolean delete(Product pr) {
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			String query = "DELETE FROM PRODUCT WHERE PRODUCTNUMMER = "
					+ pr.getProductNum(); 
			ResultSet rs = stat.executeQuery(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
