package edu.iot.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.iot.common.database.Session;

public class PaginationDaoImpl<M, K> 
		extends CrudDaoImpl<M, K> 
		implements PaginationDao<M> {

	public PaginationDaoImpl(String name) {
		super(name);
	}

	public List<M> getPage(int start, int end) throws Exception {
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);

		try (SqlSession session = Session.getSession()) {
			return session.selectList(namespace + ".getPage", map);
		}
	}
}
