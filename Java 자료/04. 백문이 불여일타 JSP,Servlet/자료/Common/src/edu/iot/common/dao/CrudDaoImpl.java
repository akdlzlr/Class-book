package edu.iot.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import edu.iot.common.database.Session;

public class CrudDaoImpl<M, K> 
				implements CrudDao<M, K>{
	// Mapper의 namepsace와 동일하게 구성
	protected String namespace;	

	public CrudDaoImpl(String name) {
		this.namespace = 
				getClass().getPackage().getName() + "." + name;
	}

	@Override
	public int count() throws Exception {
		try(SqlSession session=Session.getSession()) {
			return session.selectOne(namespace + ".count");
		} 
	}

	@Override
	public M findById(K k) throws Exception {
		try(SqlSession session=Session.getSession()) {
			return session.selectOne(namespace + ".findById", k);
		} 
	}

	@Override
	public List<M> getList() throws Exception {
		try(SqlSession session=Session.getSession()) {
			return session.selectList(namespace + ".getList");
		} 
	}

	@Override
	public int insert(M m) throws Exception {
		try(SqlSession session=Session.getSession()) {
			int count = session.insert(namespace + ".insert",
										m);
			session.commit();
			return count;
		} 

	}

	@Override
	public int update(M m) throws Exception {
		try(SqlSession session=Session.getSession()) {
			int count = session.update(namespace + ".update", m);
			session.commit();
			return count;
		}
	}

	@Override
	public int delete(K k) throws Exception {
		try(SqlSession session=Session.getSession()) {
			return session.delete(namespace + ".delete", k);
		} 
	}

}