package edu.iot.common.database;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Session {
	static private SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "config/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

}
