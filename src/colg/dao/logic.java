package colg.dao;
import ECUtils.BaseDAO;
import static ECUtils.BaseDAO.*;
import static ECUtils.ECConst.SQLS;
import static ECUtils.InstallDB.runSQL;
import colg.bean.admin;
import colg.bean.student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class logic {
    
    
    
    public static boolean check()
    {
        boolean b=false;
        Connection con=null;
       
        String st1=null;
        try {
            con=getCon();
           String sql="select * from user";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
           while(rs.next())
           {
                st1=rs.getString("user_name");
             
          }
        } catch (Exception e) {
           for(String sql1 : SQLS)
                    runSQL(sql1);
           
        }
        finally
        {
            closeCon(con);
        }
        if(st1==null)
            b=true;
        return b;
    }
    public static Boolean check_pass(admin a1)
   {
       Boolean var=false;
       Connection con=null;
       try {
           con=getCon();
            String sql="select * from user";
            PreparedStatement pr=con.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            while(rs.next())
            {
                if(a1.getUser_name().equals(rs.getString("user_name"))&&a1.getPassword().equals(rs.getString("password")))
                {
                   
                        var=true;
                    
                }
            } 
            
       }catch (Exception e) {
           e.printStackTrace();
       }
       finally
       {
           closeCon(con);
       }
       return var;
   }
    public static void enter(admin s) {
        Connection con=null;
        try {
            con=getCon();
            String sql="insert into user (user_name,password,ques,ans) values (?,?,?,?)";
         PreparedStatement st=(PreparedStatement) con.prepareStatement(sql);
         int i=1;
         st.setString(i++, s.getUser_name());
         st.setString(i++, s.getPassword());
           st.setString(i++, s.getQues());
             st.setString(i++, s.getAns());
        
         st.executeUpdate();
         } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeCon(con);
        }
    }
    public static admin forgot()
    {
        admin b=null;
        Connection con=null;
       
        String st1=null;
        try {
            con=getCon();
           String sql="select * from user";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
           while(rs.next())
           {
               b=new admin();
               b.setAns(rs.getString("ans"));
               b.setQues(rs.getString("ques"));
               
            
           }
        } catch (Exception e) {
             e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
        
        return b;
    }
    public static void updatepass(admin a)
    {
      
        Connection con=null;
      
        try {
            con=getCon();
           String sql="update user set password=? ";
            PreparedStatement st=con.prepareStatement(sql);
            int i=1;
            st.setString(i++,a.getPassword());
            st.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
        
    }
    
   
}
