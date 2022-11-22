package dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.UserDTO;
import mybatis.MybatisFactory;

public class UserDAO {
	private SqlSession sql;//preparedstatement의 역할!
		
	void connect() {
		SqlSessionFactory factory = MybatisFactory.getInstance();
		sql = factory.openSession(true);
	}
	
	public String whatName() {
		connect();
		String name = sql.selectOne("user.select_name");
		return name;
	}
	public int checkMoney() {
		connect();
		int money = sql.selectOne("user.select_money");
		return money;
	}
	
	//전체 사용자이름 조회 메소드
	public List<String> select_name_all() {
		connect();
		List<String> list = sql.selectList("user.name_all");
		 //https://mybatis.org/mybatis-3/java-api.html 
		 //sqlsession 부분 
		 //매퍼의 반환 형식은 List이다!!
		return list;
	}
	
	//전체 사용자정보를 조회 메소드
	public List<UserDTO> select_user_list() {
		connect();
		List<UserDTO> list = sql.selectList("user.user_list");
		return list;
	}
	
}
