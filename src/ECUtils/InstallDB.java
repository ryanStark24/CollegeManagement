package ECUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class InstallDB  implements ECConst{
	public static void main(String[] args) {
		createDB();
		for(String sql : SQLS){
			runSQL(sql);			
		}
	}
	
	public static void createDB(){
		try (Connection con = DriverManager.getConnection("jdbc:mysql://"+DB_HOST, DB_USER, DB_PASS)) {
			String sql;
			
			sql = "create database if not exists  " +DB_NAME;
                        PreparedStatement st = con.prepareStatement(sql);
                   
                   st.execute();
			
            
                          System.out.println(DB_NAME + " created");
		} catch (Exception e) {
		}
              
                
               
	}
	public static void runSQL(String sql){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://"+DB_HOST+":3306/"+DB_NAME, DB_USER, DB_PASS);
			PreparedStatement st = con.prepareStatement(sql);
			st.executeUpdate();
			con.close();
			System.out.println("sql completed!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
