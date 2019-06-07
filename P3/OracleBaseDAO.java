// V1C - Julian Kunst

package InleverOpdrachten.P3;

import java.sql.*;

public class OracleBaseDAO {
	private Connection conn = null;
	
    protected Connection getConnection(){
    	String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    	String user = "OVDP";
    	String pass = "Julian";
    	
    	if (conn == null) {
    		try {
    			conn = DriverManager.getConnection(url, user, pass);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	return conn;
    }

    public void closeConnection(){
    	try {
    		conn.close();
    		conn = null;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
