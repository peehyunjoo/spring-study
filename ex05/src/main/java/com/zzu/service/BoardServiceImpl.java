package com.zzu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzu.domain.BoardVO;
import com.zzu.domain.Criteria;
import com.zzu.domain.SearchCriteria;
import com.zzu.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	@Transactional
	@Override
	public void regist(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		dao.create(board);
		String[] files = board.getFiles();
		if(files == null ) {return; }
		for(String fileName : files) {
			dao.addAttach(fileName);
		}
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		dao.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri);
	}
}
