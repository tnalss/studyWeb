package customer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.HanulFactory;

public class CustomerDAO {
	
	private SqlSession sql;
	
	
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

}
