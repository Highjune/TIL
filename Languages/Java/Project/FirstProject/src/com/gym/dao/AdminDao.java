package com.gym.dao;
  
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gym.vo.GymVO;

import oracle.jdbc.OracleTypes;
  
  
// ��üȸ�������ȸ, ������ȸ, ȸ���˻�, ȸ������ ����, ��ü���� ����, ȸ������
  
public class AdminDao {
     
    //ȸ����� admin_insert_sp
    public int adminInsert(GymVO gym) throws SQLException{
        Connection conn = DBConnection.getConnection("config/oracle.properties"); 
        String sql = "{ call admin_insert_sp(?,?,?,?,?,?,?,?,?,?) }";
        CallableStatement cstmt = conn.prepareCall(sql);
        cstmt.setInt(1,gym.getNum());
        cstmt.setString(2, gym.getName());
        cstmt.setString(3, gym.getGender());
        cstmt.setInt(4, gym.getAge());
        cstmt.setString(5, gym.getPhone());
        cstmt.setDouble(6, gym.getHeight());
        cstmt.setDouble(7, gym.getWeight());
        cstmt.setDate(8, gym.getStartd());
        cstmt.setDate(9, gym.getEndd());
        cstmt.setDouble(10, gym.getGoal());
        int row=cstmt.executeUpdate();
        DBClose.close(conn, cstmt);
        return row;
    }   
         
     
    //��üȸ�������ȸ admin_selectAll_sp   
    public List <GymVO> adminSelectAll() throws SQLException{
        GymVO gym = null;
        Connection conn = DBConnection.getConnection("config/oracle.properties"); 
        String sql = "{ call admin_selectAll_sp(?) }";
        CallableStatement cstmt = conn.prepareCall(sql);
        cstmt.registerOutParameter(1, OracleTypes.CURSOR);
        cstmt.execute();   
        ResultSet rs = (ResultSet)cstmt.getObject(1);
        List<GymVO> list = new ArrayList<GymVO> ();
        while(rs.next()) {
            gym = new GymVO();
            gym.setNum(rs.getInt("num"));           
            gym.setName(rs.getString("name"));          
            gym.setGender(rs.getString("gender"));          
            gym.setAge(rs.getInt("age"));           
            gym.setPhone(rs.getString("phone"));            
            gym.setGigan(rs.getString("gigan"));            
            list.add(gym);
        }
        DBClose.close(conn, cstmt, rs);
        return list;
    }
     
      
    //������ȸ admin_select_gender_sp   
    public List <GymVO> adminSelectGender(String gender) throws SQLException{
        GymVO gym = null;
        Connection conn = DBConnection.getConnection("config/oracle.properties"); 
        String sql = "{ call admin_select_gender_sp(?, ?) }";
        CallableStatement cstmt = conn.prepareCall(sql);
        cstmt.setString(1, gender);
        cstmt.registerOutParameter(2, OracleTypes.CURSOR);
        cstmt.execute();   
        ResultSet rs = (ResultSet)cstmt.getObject(2);
        List<GymVO> list = new ArrayList<GymVO> ();
        while(rs.next()) {
            gym = new GymVO();
            gym.setNum(rs.getInt("num"));           
            gym.setName(rs.getString("name"));          
            gym.setGender(rs.getString("gender"));          
            gym.setAge(rs.getInt("age"));           
            gym.setPhone(rs.getString("phone"));            
            gym.setStartd2(rs.getString("startd"));         
            gym.setEndd2(rs.getString("endd"));         
            list.add(gym);
        }
        DBClose.close(conn, cstmt, rs);     
        return list;
    }
      
      
    //ȸ���˻� admin_search_sp
    public GymVO adminSearch(int num) throws SQLException{
       // System.out.println(num);
        GymVO gym = null;
        Connection conn = DBConnection.getConnection("config/oracle.properties"); 
        String sql = "{ call admin_search_sp(?, ?) }";
        CallableStatement cstmt = conn.prepareCall(sql);
        cstmt.setInt(1, num);
        cstmt.registerOutParameter(2, OracleTypes.CURSOR);
        cstmt.execute();
        ResultSet rs = (ResultSet)cstmt.getObject(2);      
        if(rs.next()) {
            gym = new GymVO();
            gym.setCheckday(rs.getString("checkday"));
            gym.setName(rs.getString("name")); gym.setGender(rs.getString("gender")); gym.setAge(rs.getInt("age"));
            gym.setPhone( rs.getString("phone")); gym.setHeight(rs.getDouble("height")); gym.setWeight(rs.getDouble("cweight"));
            gym.setGoal(rs.getDouble("goal")); gym.setBmi(rs.getDouble("bmi")); gym.setNum(rs.getInt("num"));
            gym.setRate(rs.getString("rate")); gym.setEndd2(rs.getString("endd")); gym.setStartd2(rs.getString("startd"));
            gym.setCha(rs.getDouble("cha")); 
          //  System.out.println(gym);
        }
       // System.out.println(gym.getName());
        DBClose.close(conn, cstmt, rs);     
        return gym;
    }
      
      
    //ȸ������ ���� origin_update_sp
    public int originUpdate(GymVO gym)  throws SQLException {
        int row = -1;
        Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
        String sql = "{ call admin_UpdateAll_sp(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        CallableStatement cstmt = conn.prepareCall(sql);  
        cstmt.setInt(1, gym.getNum());  
        cstmt.setString(2, gym.getName());  
        cstmt.setString(3, gym.getGender());   
        cstmt.setInt(4, gym.getAge()); 
        cstmt.setString(5, gym.getPhone());   
        cstmt.setDouble(6, gym.getHeight());  
        cstmt.setDouble(7, gym.getWeight());  
        cstmt.setDouble(8, gym.getGoal());  
       // cstmt.setDouble(9, gym.getBmi()); 
        String s=gym.getStartd2();
        Date startd = Date.valueOf(s);
        cstmt.setDate(9, startd); 
        String s1=gym.getEndd2();
        Date endd = Date.valueOf(s1);
        cstmt.setDate(10, endd);  
        row = cstmt.executeUpdate();  
        DBClose.close(conn, cstmt); 
        return row;
    }
      
      
    public GymVO bodySearch(int num) throws SQLException{
    	GymVO gym = null;
    	Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
        String sql = "{ call admin_change_select_sp(?, ?)  }";
        CallableStatement cstmt = conn.prepareCall(sql); 
        cstmt.setInt(1, num);  
        cstmt.registerOutParameter(2, OracleTypes.CURSOR);
        cstmt.execute();
        ResultSet rs=(ResultSet)cstmt.getObject(2);
        if(rs.next()) {
        	gym = new GymVO();
            gym.setCheckday(rs.getString("checkday"));
            gym.setWeight(rs.getDouble("weight")); 
            gym.setSerial(rs.getInt("serial"));            
        }
        DBClose.close(conn, cstmt,rs); 

        return gym;
       
    }
    //��ü���� ���� change_update_sp
    public int changeUpdate(GymVO gym)  throws SQLException {
        int row = -1;
        Connection conn = DBConnection.getConnection("config/oracle.properties");
        String sql = "{ call admin_change_update_sp(?, ?)  }";
        CallableStatement cstmt = conn.prepareCall(sql);
        cstmt = conn.prepareCall(sql); 
        cstmt.setInt(1,gym.getSerial());
        cstmt.setDouble(2,gym.getWeight());
//        String dStr = gym.getCheckday();
//        Date d = Date.valueOf(dStr);     
//        cstmt.setDate(3,d);
        row = cstmt.executeUpdate();
        DBClose.close(conn, cstmt); 
        return row;
    }
      
      
    //ȸ������ admin_delete_sp 
    public int originalDelete(int num) throws SQLException {
        int row = -1;
        Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
        String sql = "{ call admin_delete_sp (?)  }";
        CallableStatement cstmt = conn.prepareCall(sql); 
        cstmt.setInt(1, num);
        row = cstmt.executeUpdate();
        DBClose.close(conn, cstmt);  //6.
        return row;
    }
}