package ECUtils;

import java.sql.*;

public class BaseDAO implements  ECConst{
 public static Connection getCon(){
	 Connection con = null;
	 try {
		con = DriverManager.getConnection("jdbc:mysql://"+DB_HOST+":3306/"+DB_NAME, DB_USER, DB_PASS);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;		
 }
 public static void closeCon(Connection con){
	 try {
		 con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
 }

}
