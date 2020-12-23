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
    public int create(GymVO gym) { //회원등록  dao에 만들어야함
        int row=-1;
        try {
            row = this.dao.adminInsert(gym);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return row;
    }
    public List<GymVO> readAll() { //회원조회->전체회원
        List<GymVO> list = null;
        try {
            list = this.dao.adminSelectAll();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
      
    public List<GymVO> readGender(String gender) { //회원 조회-> 성별로
        List<GymVO> list = null;
        try {
            list = this.dao.adminSelectGender(gender);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
          
    }
    public GymVO read(int num) { //회원조회->회원검색
        GymVO gym=null;
        try {
            gym = this.dao.adminSearch(num);
          
        } catch (SQLException e) {
            System.out.println(e);
        }
        return gym;
          
    }
    public GymVO readBody(int num) { //회원조회->회원검색
        GymVO gym=null;
        try {
            gym = this.dao.bodySearch(num);
           
        } catch (SQLException e) {
            System.out.println(e);
        }
        return gym;
          
    }
    
    public int originalUpdate(GymVO gym) { //회원정보수정
        int row = -1;
        try {
            row = this.dao.originUpdate(gym);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return row;
          
    }
    public int changeUpdate(GymVO gym) { //신체정보 수정
        int row = -1;
        try {
            row = this.dao.changeUpdate(gym);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return row;
          
    }
    public int delete(int num) { //회원삭제 
        int row = -1;
        try {
            row = this.dao.originalDelete(num);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return row;
    }
     
              
  
}