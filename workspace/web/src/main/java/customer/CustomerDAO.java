package customer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.HanulFactory;

public class CustomerDAO {
	
	private SqlSession sql;
	
	
	
	//****************************CRUD*****************************
	//Create (insert) , Read (select) , Update (update) , Delete (delete)
	
	
	private void connect() {
		SqlSessionFactory factory = HanulFactory.getInstance();
		sql = factory.openSession(true);		
	}
	//전체 고객목록 조회 메소드
	public List<CustomerDTO> customer_list() {
		connect();
		List<CustomerDTO> list = sql.selectList("customer.list");
		return list;
	}
	



	public CustomerDTO customer_info(int id) {
		connect();
		CustomerDTO dto = sql.selectOne("customer.info",id);
		return dto;
	}
	public void customer_update(CustomerDTO dto) {
		connect();
		sql.update("customer.update",dto);
		
		
	}
	public void customer_insert(CustomerDTO dto) {
		connect();
		sql.insert("customer.insert",dto);
		
	}
	public void customer_delete(int id) {
		connect();
		sql.delete("customer.delete",id);
		
	}

}
