package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.DepartmentDTO;
import dto.EmployeeDTO;

public class hrDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private void connect() {
		try {
			Context initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/hr");
			conn = ds.getConnection();
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","0000");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	private void disconnect() {
		if (rs!=null) { try{rs.close();}catch(Exception e) {} }
		if (ps!=null) { try{ps.close();}catch(Exception e) {} }
		if (conn!=null) { try{conn.close();}catch(Exception e) {} }
	}
	
	//사원목록조회
	public ArrayList<EmployeeDTO> employee_list() {
		connect();
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		String sql = "SELECT employee_id, last_name || ' ' || first_name name"
				+ ",salary, department_id, department_name , hire_date"
				+ " FROM employees e LEFT JOIN departments d "
				+ " USING(department_id) ORDER BY 1";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setName(rs.getString("name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setDepartment_id(rs.getInt("department_id"));
				dto.setDepartment_name(rs.getString("department_name"));
				dto.setHire_date(rs.getDate("hire_date"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect();
		}
		return list;
	}

	public ArrayList<DepartmentDTO> department_list() {
		connect();
		ArrayList<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
		String sql = "SELECT DISTINCT department_id, nvl(department_name,'소속없음') department_name"
				+ " FROM employees e LEFT JOIN departments d"
				+ " USING (department_id)"
				+ " ORDER BY 1";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DepartmentDTO dto = new DepartmentDTO();
				dto.setDepartment_id(rs.getInt("department_id"));
				dto.setDepartment_name(rs.getString("department_name"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect();
		}
		return list;
		
	}
	
	//신규사원 insert 메소드
	
	public void employee_insert(EmployeeDTO dto) {
		connect();
		String sql = "INSERT INTO employees "
				+ "(employee_id,last_name,first_name,email,department_id,"
				+ "job_id,salary,hire_date) VALUES (employees_seq.nextval,?,?,"
				+ "?,?,?,?,sysdate)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getLast_name() );
			ps.setString(2, dto.getFirst_name() );
			ps.setString(3, dto.getEmail());
			ps.setInt(4, dto.getDepartment_id());
			ps.setString(5, dto.getJob_id());
			ps.setInt(6, dto.getSalary());
			
			int count = ps.executeUpdate();
			if(count>0)
				System.out.println("삽입 완료");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect();
		}
		
		
	}

	public EmployeeDTO employee_info(int id) {
		connect();
		String sql = "SELECT employee_id, first_name,last_name,first_name||' '||last_name name,"
				+ " department_id, job_id, salary,hire_date,email"
				+ " FROM employees WHERE employee_id=?";
		EmployeeDTO dto = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if( rs.next() ) {
				dto = new EmployeeDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setName(rs.getString("name"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setDepartment_id(rs.getInt("department_id"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setSalary(rs.getInt("salary"));
				dto.setHire_date(rs.getDate("hire_date"));
				dto.setEmail(rs.getString("email"));
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect();
		}
		return dto;
		
	}

	public void employee_fire(int id) {
		connect();
		String sql = "DELETE employees WHERE employee_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if (count>0)
				System.out.println("사번 : " +id + "삭제 완료");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			disconnect();
		}
		
	}
	public void emp_force(int id) {
		connect();
		String sql = "DELETE job_history WHERE employee_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if (count>0)
				System.out.println("history 삭제 완료");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			disconnect();
		}
		
	}

	public void employee_modify(EmployeeDTO dto) {

		connect();
		String sql="UPDATE employees"
				+ " SET first_name=?, last_name=?, email=? , department_id=?,job_id=?,salary=?"
				+ " WHERE employee_id=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getFirst_name());
			ps.setString(2, dto.getLast_name());
			ps.setString(3, dto.getEmail());
			ps.setInt(4, dto.getDepartment_id());
			ps.setString(5, dto.getJob_id());
			ps.setInt(6, dto.getSalary());
			
			//ps.setDate(7, dto.getHire_date()); //무결성때문에 뺌
			ps.setInt(7, dto.getEmployee_id());
			
			int count = ps.executeUpdate();
			
			if(count>0)
				System.out.println("변경완료");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
	
}
