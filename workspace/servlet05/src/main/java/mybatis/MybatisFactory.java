package mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactory {
	private static SqlSessionFactory factory;

	/*
	 * static { String resource = "mybatis/config.xml"; InputStream inputStream; try
	 * { inputStream = Resources.getResourceAsStream(resource); factory = new
	 * SqlSessionFactoryBuilder().build(inputStream);
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); // diconnect할 처리가
	 * 없는 개꿀 } }
	 */
	public static SqlSessionFactory getInstance() {
		
		
		if (factory == null) {
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				factory = new SqlSessionFactoryBuilder().build(inputStream);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				// diconnect할 처리가 없는 개꿀
			}
		}
		return factory;
	}
}
