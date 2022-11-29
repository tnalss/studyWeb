package hr;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.HrFactory;

public class HrDAO {
	SqlSession sql;

	private void connect() {
		SqlSessionFactory factory = HrFactory.getInstance();
		sql = factory.openSession(true);
	}

	// CRUD (Create, Read, Update, Delete)
	// 신규사원 등록
	public void employee_regist(EmployeeDTO dto) {
		connect();
		sql.insert("", dto);
	}

	// 전체사원목록조회
	public List<EmployeeDTO> employee_list() {
		connect();
		List<EmployeeDTO> list = sql.selectList("hr.list");
		sql.close();
		return list;
	}
	
	// 사원이 있는 부서목록조회
	public List<DepartmentDTO> department_list() {
		connect();
		List<DepartmentDTO> dto = sql.selectList("hr.department_list");
		sql.close();
		return dto;
	}
	// 선택한 부서의 사원목록조회
	public List<EmployeeDTO> employee_list(int department_id){
		connect();
		List<EmployeeDTO> list = sql.selectList("hr.list",department_id);
		sql.close();
		return list;
	}

	// 선택한 사원정보 조회
	public EmployeeDTO employee_info(int id) {
		connect();
		EmployeeDTO dto = sql.selectOne("hr.info", id);
		sql.close();
		return dto;
	}

	// 선택한 사원정보 변경
	public void employee_update(EmployeeDTO dto) {
		connect();
		sql.update("hr.update", dto);
		sql.close();
	}
	
	//선택한 사원정보 삭제
	public void employee_delete(int id) {
		connect();
		sql.delete("hr.delete",id);
		sql.close();
	}
	
	
	//전체 부서 목록
	public List<DepartmentDTO> department_list_all() {
		connect();
		List<DepartmentDTO> list = sql.selectList("hr.department_list_all");
		sql.close();
		return list;
	}
	
	
	//전체 업무목록
	
	public List<JobDTO> job_list_all() {
		connect();
		List<JobDTO> list = sql.selectList("hr.job_list_all");
		sql.close();
		return list;
	}
	
	//관리자로 지정할 전체사원 목록
	
	public List<ManagerDTO> manager_list_all() {
		connect();
		List<ManagerDTO> list = sql.selectList("hr.manager_list_all");
		sql.close();
		return list;
	}
	
	
	
	
	
	
}
