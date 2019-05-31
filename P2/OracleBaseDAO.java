// V1C - Julian Kunst

package InleverOpdrachten.P2;

import java.sql.*;

public class OracleBaseDAO {
	private Connection myConn = null;
	
    protected Connection getConnection(){
    	String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    	String user = "OVDP";
    	String pass = "Julian";
    	
    	if (myConn == null) {
    		try {
    			myConn = DriverManager.getConnection(url, user, pass);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	return myConn;
    }

    public void closeConnection(){
    	try {
    		myConn.close();
    		myConn = null;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
