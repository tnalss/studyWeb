package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.HanulFactory;

public class MemberDAO {
	private SqlSession sql;
	
	private void connect() {
		SqlSessionFactory factory = HanulFactory.getInstance();
		sql = factory.openSession(true);	
	}
	// 로그인 메소드 선언
	public MemberDTO login(String id, String pw) {
		connect();
		// 쿼리 실행 메소드의 파라미터는 2개만 지정이 가능하기때문에
		// 전달한 데이터에 해당하는 파라미터가 여러개인 경우 데이터객체(DTO)를 사용하거나
		// HashMap을 사용한다!
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("pw", pw);
		// 매퍼에 #{id} 는 해쉬맵의 키에 해당한다!!!!!!!!!!!!
		MemberDTO dto = sql.selectOne("member.login",map);
		sql.close();
		return dto;
	}
	
	//아이디 존재여부 파악
	public int idExist(String id) {
		connect();
		int count = sql.selectOne("member.userid_exist", id );
		
		sql.close();
		return count;
	}
	
	//회원정보신규저장
	public void member_insert(MemberDTO dto) {
		connect();
		sql.insert("member.insert",dto);
		sql.close();
	}
	public void member_update(MemberDTO dto) {
		connect();
		sql.insert("member.update",dto);
		sql.close();
	}
	
	
}
