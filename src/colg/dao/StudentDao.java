
package colg.dao;

import ECUtils.BaseDAO;
import colg.bean.student;

import java.sql.*;
import java.util.LinkedList;

public class StudentDao extends BaseDAO{
    public static void insert(student s,String deprt)
    {
        Connection con=null;
        try {
            con=getCon();
            String sql="insert into " + deprt + "(user_name,phone_no,email,sem,id) values (?,?,?,?,?)";
         PreparedStatement st=(PreparedStatement) con.prepareStatement(sql);
         int i=1;
         st.setString(i++, s.getName());
         st.setString(i++, s.getP_no());
         st.setString(i++, s.getEmail());
         st.setString(i++, s.getSem());
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
    public static void delete(student s,String deprt)
    {
        Connection con=null;
        try {
            con=getCon();
            String sql="delete from " + deprt + " where id=?";
         PreparedStatement st=(PreparedStatement) con.prepareStatement(sql);
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
    public static void update(student s1,String branch ) {
        Connection con=null;
        try {
            con=getCon();
            String sql="update " + branch  + " set user_name= ?, phone_no= ?, email= ?, sem= ? where id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            int i=1;
            st.setString(i++, s1.getName());
            st.setString(i++, s1.getP_no());
            st.setString(i++, s1.getEmail());
            st.setString(i++, s1.getSem());
            st.setString(i++, s1.getId());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeCon(con);
        }
    }
    public static LinkedList<student> search(student s1,String sc){
    LinkedList<student> res=new LinkedList<student>();
            Connection con=null;
            try {
                con=getCon();
                String sql ="select * from "+sc+" where id like ?";
                PreparedStatement pr=con.prepareStatement(sql);
                int i = 1;
		
                pr.setString(i++,s1.getId()+"%");
                
               ResultSet rs=pr.executeQuery();
                while(rs.next()){
			student p1 = new student();
                        p1.setEmail(rs.getString("email"));
                        p1.setName(rs.getString("user_name"));
                        p1.setP_no(rs.getString("phone_no"));
                        p1.setSem(rs.getString("sem"));
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
    public static student searchById(String s1,String sc){
    student res=new student();
            Connection con=null;
            try {
                con=getCon();
                String sql ="select * from "+sc+" where id=?";
                PreparedStatement pr=con.prepareStatement(sql);
                int i = 1;
		
                pr.setString(i++,s1);
                
               ResultSet rs=pr.executeQuery();
                while(rs.next()){
			//student p1 = new student();
                        res.setEmail(rs.getString("email"));
                        res.setName(rs.getString("user_name"));
                        res.setP_no(rs.getString("phone_no"));
                        res.setSem(rs.getString("sem"));
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
