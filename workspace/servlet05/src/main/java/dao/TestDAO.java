package dao;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatis.MybatisFactory;

public class TestDAO {
	private SqlSession sql;
		
	//preparedStatement의 메소드 : SqlSession에서는?
	// executeQuery() : selectOne, selectList("매퍼의namespace.쿼리태그id")
	//executeUpdate() : update, insert, delete
	public Date select_today() {
		connect();
		Date today = sql.selectOne("test.select_today");
		return today;
	}
	public String select_now() {
		connect();
		String now = sql.selectOne("test.select_now");
		return now;
	}
	public int user_count() {
		connect();
		int users = sql.selectOne("user_count");
		return users;
	}
		
	
	void connect() {
		SqlSessionFactory factory = MybatisFactory.getInstance();
		sql = factory.openSession(true);
		/*
		 * String resource = "mybatis/config.xml"; InputStream inputStream; try {
		 * inputStream = Resources.getResourceAsStream(resource); SqlSessionFactory
		 * sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		 * session = sqlSessionFactory.openSession(true);//ps라고 생각//true를 넣어주면
		 * autocommit!
		 * 
		 * } catch (Exception e) { System.out.println(e.getMessage()); //diconnect할 처리가
		 * 없는 개꿀 }
		 */
	}
	
/*	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	
	public Date select_today() {
		Date today = null;
		connect();
		String sql = "SELECT sysdate FROM dual";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();//한줄밖에없지만 커서이동 ㅇㅇ
			today = rs.getDate("sysdate");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			disconnect();
		}
		return today;
	}
	
	
	void connect() {
		Context context;
		try {
			//context.xml에 선언한 Resource 찾기
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/smart");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	void disconnect() {
		if(rs!=null) {try {	rs.close();} catch (Exception e) { }	}
		//만약 rs가 null이면 rs에 close란 메소드를 찾아갈수가없다!
		if(ps!=null) {try {	ps.close();} catch (Exception e) { }	}
		if(conn!=null) {try {	conn.close();} catch (Exception e) { }	}
	}
	
	*/
}
