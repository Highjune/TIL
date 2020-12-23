package com.gym.service;
 
import java.sql.SQLException;
 
import com.gym.dao.MembershipDao;
 
public class MembershipService {
    private MembershipDao dao;
     
    public MembershipService() {
        this.dao=new MembershipDao();
    }
     
    public int login(int userid, String passwd) {
           int number = -2;
           try {
               number= this.dao.login(userid, passwd);
           } catch (SQLException e) {
               System.out.println(e);
           }
           return number;
       }
    public boolean logout(String userid) {
            
           return false;
       }
 
}