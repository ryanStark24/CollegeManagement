
package colg.dao;

import ECUtils.BaseDAO;
import static ECUtils.BaseDAO.closeCon;
import static ECUtils.BaseDAO.getCon;
import colg.bean.student;
import colg.bean.teachers;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;

public class TeachersDao extends BaseDAO{
     public static void insert(teachers s)
    {
        Connection con=null;
        try {
            con=getCon();
            String sql="insert into teachers(user_name,phone_no,email,deprt,quali,id) values (?,?,?,?,?,?)";
         PreparedStatement st =  (PreparedStatement) con.prepareStatement(sql);
         int i=1;
         st.setString(i++, s.getName());
         st.setString(i++, s.getP_no());
         st.setString(i++, s.getEmail());
         st.setString(i++, s.getDeprt());
         st.setString(i++, s.getQuali());
         st.setString(i++, s.getId());
         st.executeUpdate();
         } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeCon(con);
        }
    }
    public static void delete(teachers s)
    {
        Connection con=null;
        try {
            con=getCon();
            String sql="delete from teachers where id=?";
         java.sql.PreparedStatement st=(java.sql.PreparedStatement) con.prepareStatement(sql);
         int i=1;
         st.setString(i++, s.getId());
         st.executeUpdate();
         } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeCon(con);
        }
    }
    public static void update(teachers s1) {
        Connection con=null;
        try {
            con=getCon();
            String sql="update teachers set deprt= ?, user_name= ?, phone_no= ?, email= ? ,quali=? where id = ? ";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
            int i=1;
            st.setString(i++, s1.getDeprt());
            st.setString(i++, s1.getName());
            st.setString(i++, s1.getP_no());
            st.setString(i++, s1.getEmail());
            st.setString(i++, s1.getQuali());
            st.setString(i++, s1.getId());
            
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeCon(con);
        }
    }
public static LinkedList<teachers> search(teachers sc)
    {
    LinkedList<teachers> res=new LinkedList<teachers>();
            Connection con=null;
            try {
                con=getCon();
               String sql = "select * from teachers where id like ?";
                PreparedStatement pr=(PreparedStatement) con.prepareStatement(sql);
                pr.setString(1,sc.getId()+"%" );
                ResultSet rs=pr.executeQuery();
                while(rs.next()){
			teachers p1 = new teachers();
                        p1.setEmail(rs.getString("email"));
                        p1.setName(rs.getString("user_name"));
                        p1.setP_no(rs.getString("phone_no"));
                        p1.setDeprt(rs.getString("deprt"));
                        p1.setQuali(rs.getString("quali"));
                        p1.setId(rs.getString("id"));
                        res.add(p1);
		}
            } catch (Exception e){
                e.printStackTrace();
            }
            finally
            {
                closeCon(con);
            }
    return res;
}
public static teachers searchById(String s1){
    teachers res=new teachers();
            Connection con=null;
            try {
                con=getCon();
                String sql ="select * from teachers where id=?";
                PreparedStatement pr=(PreparedStatement) con.prepareStatement(sql);
                int i = 1;
		
                pr.setString(i++,s1);
                
               ResultSet rs=pr.executeQuery();
                while(rs.next()){
			//student p1 = new student();
                        res.setEmail(rs.getString("email"));
                        res.setName(rs.getString("user_name"));
                        res.setP_no(rs.getString("phone_no"));
                        res.setDeprt(rs.getString("deprt"));
                       res.setQuali(rs.getString("quali"));
                       res.setId(rs.getString("id"));
                        
		}
            } catch (Exception e){
                e.printStackTrace();
            }
            finally
            {
                closeCon(con);
            }
    return res;
}

}

