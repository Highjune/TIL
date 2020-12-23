package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.vo.Employee;

import oracle.jdbc.OracleTypes;

public class SalaryMgmtDaoImpl implements SalaryMgmtDao {

	@Override
	public int insert(Employee employee) throws SQLException {
		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3
		String sql = "{ call employee_insert_sp(?,?,?,?,?,?,?) }";
		CallableStatement cstmt = conn.prepareCall(sql);  //4.
		cstmt.setString(1, employee.getEmpno());
		cstmt.setString(2, employee.getName());
		cstmt.setInt(3, employee.getNum());
		cstmt.setString(4, employee.getCode());
		cstmt.setInt(5, employee.getGrade());
		cstmt.setInt(6, employee.getNightcode());
		cstmt.setInt(7, employee.getFamily());
		int row = cstmt.executeUpdate();   //5.
		DBClose.close(conn, cstmt);   //6.
		return row;
	}

	@Override
	public List<Employee> selectAll() throws SQLException {
		Connection conn = DBConnection.getConnection("config/oracle.properties"); //3
		String sql = "{    call employee_selectall_sp(?) }";
		CallableStatement cstmt = conn.prepareCall(sql);  //4.
		cstmt.registerOutParameter(1, OracleTypes.CURSOR);   
		cstmt.execute();  //�ſ� �߿�.   //5.
		ResultSet rs = (ResultSet)cstmt.getObject(1);
		List<Employee> list = new ArrayList<Employee>();
		while(rs.next()) {   //6. //next()�� �̷������ ����ŭ emp�� ����.
			Employee emp = new Employee(); 
			emp.setEmpno(rs.getString("empno"));
			emp.setName(rs.getString("name"));
			emp.setDname(rs.getString("dname"));
			emp.setNum(rs.getInt("num"));
			emp.setBonus(rs.getInt("bonus"));
			emp.setFamilyBonus(rs.getInt(7)); //��������(famailybonus)�� ���� �÷��� ��� ������ ����.
			emp.setNightBonus(rs.getInt("nightbonus"));
			emp.setDefaultSalary(rs.getInt("defsalary"));
			list.add(emp); //�ϳ��ϳ� �� �Էµ� employee�� list�� �߰�.
		}
		DBClose.close(conn, cstmt, rs);   //7.
		return list;
	}

	@Override
	public Employee select(String empno) throws SQLException {
		Connection conn = DBConnection.getConnection("config/oracle.properties"); //3.
		String sql = "{ call employee_select_sp(?, ?) }"; //ù?�� ���� ��. ��°?�� ������ ��
		CallableStatement cstmt = conn.prepareCall(sql);   //4.
		cstmt.setString(1, empno);
		cstmt.registerOutParameter(2, OracleTypes.CURSOR); //Ŀ���� �����ϴ� library�� oracle�ۿ� ���� ������ OracleTypes������ ��� �ȴ�. 
		cstmt.execute();  //�ſ� ����.    //5.
		ResultSet rs = (ResultSet)cstmt.getObject(2);//�ڹٴ� cursorŸ���� �����Ƿ� object(��ü)�� �ް� ���� resultset���� ����ȯ.
		//cf) object(�θ�) -> ResultSet(�ڽ�) ������ ����ȯ�� ���������� instanceof�� ������� �Ǵµ�, �����ϴϱ� ���� ����� ����.
		
		rs.next(); //ù��° ���ڵ带 �б� ���� next. ������ if���ǹ����� �ؾ� ������.
		Employee emp = new Employee();
		emp.setEmpno(empno);
		emp.setName(rs.getString("name"));
		emp.setNum(rs.getInt("num"));
		emp.setNightcode(rs.getInt("nightcode"));
		emp.setFamily(rs.getInt("family"));
		DBClose.close(conn, cstmt, rs);   //7.
		return emp;
	}
}





