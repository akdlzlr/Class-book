package edu.iot.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iot.common.dao.AttachmentDao;
import edu.iot.common.dao.BoardDao;
import edu.iot.common.exception.PasswordMissmatchException;
import edu.iot.common.model.Attachment;
import edu.iot.common.model.Board;
import edu.iot.common.model.Pagination;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	
	@Autowired
	AttachmentDao attachmentDao;

	@Override
	public Map<String, Object> getPage(int page) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		
		int total = dao.count();
		Pagination pagination = new Pagination(page, total);
		map.put("pagination", pagination);
		map.put("list", dao.getPage(pagination.getPageMap()));		
		return map;
	}
	
	@Transactional
	@Override
	public void create(Board board) throws Exception {
		int result = dao.insert(board);
		/*if(result==1) {
			throw new RuntimeException("test");
			//throw new Exception("test");
		}*/
		
		for(Attachment attachment : board.getAttachList()) {
			attachment.setAttachmentId(31);
			attachment.setBoardId(board.getBoardId());
			attachmentDao.insert(attachment);
		}
	}

	@Override
	public Board findById(long boardId) throws Exception {
		dao.increaseReadCnt(boardId);
		Board board = dao.findById(boardId);
		board.setAttachList(attachmentDao.getList(boardId));
		return board;
	}

	@Override
	public Attachment getAttachment(long attachmentId) throws Exception {
		return attachmentDao.findById(attachmentId);
	}

	@Override
	public void update(Board board) throws Exception {
		int result=dao.update(board);

		if(result==0) {
			throw new PasswordMissmatchException();
		}
		
		for(Attachment attachment : board.getAttachList()) {
			attachment.setBoardId(board.getBoardId());
			attachmentDao.insert(attachment);
		}
	}

	@Override
	public List<Attachment> getAttachList(long boardId) throws Exception {
		return attachmentDao.getList(boardId);
	}

	@Override
	public void delete(long boardId, String password, long attachmentId) throws Exception {
		if(!dao.findById(boardId).getPassword().equals(password)) {
			throw new PasswordMissmatchException();
		}
		attachmentDao.delete(attachmentId);
	}

	@Transactional
	@Override
	public void delete(Board board) throws Exception {
		long boardId=board.getBoardId();
		
		Board b = dao.findById(boardId);
		
		if(!b.getPassword().equals(board.getPassword())) {
			throw new PasswordMissmatchException();
		}
		
		attachmentDao.deleteByBoardId(boardId);
		dao.delete(boardId);
	}

}
