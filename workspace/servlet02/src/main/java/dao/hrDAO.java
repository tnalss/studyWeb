package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Department;
import dto.DepartmentDTO;
import dto.EmployeeDTO;

public class hrDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","0000");
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
	
	
	
	
}