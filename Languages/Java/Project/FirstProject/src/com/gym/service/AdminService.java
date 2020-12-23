package com.gym.service;
  
import java.sql.SQLException;
import java.util.List;
  
import com.gym.dao.AdminDao;
import com.gym.vo.GymVO;
  
public class AdminService {
    private AdminDao dao;
      
    public AdminService() {
        this.dao=new AdminDao();
          
    }
    public int create(GymVO gym) { //ȸ�����  dao�� ��������
        int row=-1;
        try {
            row = this.dao.adminInsert(gym);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return row;
    }
    public List<GymVO> readAll() { //ȸ����ȸ->��üȸ��
        List<GymVO> list = null;
        try {
            list = this.dao.adminSelectAll();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
      
    public List<GymVO> readGender(String gender) { //ȸ�� ��ȸ-> ������
        List<GymVO> list = null;
        try {
            list = this.dao.adminSelectGender(gender);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
          
    }
    public GymVO read(int num) { //ȸ����ȸ->ȸ���˻�
        GymVO gym=null;
        try {
            gym = this.dao.adminSearch(num);
          
        } catch (SQLException e) {
            System.out.println(e);
        }
        return gym;
          
    }
    public GymVO readBody(int num) { //ȸ����ȸ->ȸ���˻�
        GymVO gym=null;
        try {
            gym = this.dao.bodySearch(num);
           
        } catch (SQLException e) {
            System.out.println(e);
        }
        return gym;
          
    }
    
    public int originalUpdate(GymVO gym) { //ȸ����������
        int row = -1;
        try {
            row = this.dao.originUpdate(gym);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return row;
          
    }
    public int changeUpdate(GymVO gym) { //��ü���� ����
        int row = -1;
        try {
            row = this.dao.changeUpdate(gym);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return row;
          
    }
    public int delete(int num) { //ȸ������ 
        int row = -1;
        try {
            row = this.dao.originalDelete(num);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return row;
    }
     
              
  
}