package com.gym.service;
 
import java.sql.SQLException;
import java.util.List;
 
import com.gym.dao.UserDao;
import com.gym.vo.GymVO;
 
public class UserService {
    private UserDao dao;
     
    public UserService() {
        this.dao=new UserDao();
    }
     
    public GymVO userAll(int userid) { //�� ���� ��ȸ
        GymVO gym = null;
        try {
            gym = this.dao.userSelectAll(userid);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return gym;
    }
     
    public List<GymVO> userBody(int userid) { //�� ��ü���� ��ȸ
        List<GymVO> list = null;
        try {
            list = this.dao.userSelectPhysic(userid);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
         
    }
    
    public List<GymVO> rankVisit() { //�⼮�� ���� ��ȸ
        List<GymVO> list = null;
        try {
            list = this.dao.rankVisit();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
         
    }


	
     
 
}