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
		cstmt.execute();  //매우 중요.   //5.
		ResultSet rs = (ResultSet)cstmt.getObject(1);
		List<Employee> list = new ArrayList<Employee>();
		while(rs.next()) {   //6. //next()가 이루어지는 수만큼 emp가 생성.
			Employee emp = new Employee(); 
			emp.setEmpno(rs.getString("empno"));
			emp.setName(rs.getString("name"));
			emp.setDname(rs.getString("dname"));
			emp.setNum(rs.getInt("num"));
			emp.setBonus(rs.getInt("bonus"));
			emp.setFamilyBonus(rs.getInt(7)); //가족수당(famailybonus)에 대한 컬럼이 없어서 순서로 들고옴.
			emp.setNightBonus(rs.getInt("nightbonus"));
			emp.setDefaultSalary(rs.getInt("defsalary"));
			list.add(emp); //하나하나 값 입력된 employee를 list로 추가.
		}
		DBClose.close(conn, cstmt, rs);   //7.
		return list;
	}

	@Override
	public Employee select(String empno) throws SQLException {
		Connection conn = DBConnection.getConnection("config/oracle.properties"); //3.
		String sql = "{ call employee_select_sp(?, ?) }"; //첫?는 들어가는 것. 둘째?는 나오는 것
		CallableStatement cstmt = conn.prepareCall(sql);   //4.
		cstmt.setString(1, empno);
		cstmt.registerOutParameter(2, OracleTypes.CURSOR); //커서를 지원하는 library는 oracle밖에 없기 때문에 OracleTypes형으로 써야 된다. 
		cstmt.execute();  //매우 주의.    //5.
		ResultSet rs = (ResultSet)cstmt.getObject(2);//자바는 cursor타입이 없으므로 object(객체)로 받고 나서 resultset으로 형변환.
		//cf) object(부모) -> ResultSet(자식) 으로의 형변환이 가능한지는 instanceof로 물어봐야 되는데, 가능하니까 굳이 물어보지 말자.
		
		rs.next(); //첫번째 레코드를 읽기 위해 next. 원래는 if조건문으로 해야 되지만.
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





