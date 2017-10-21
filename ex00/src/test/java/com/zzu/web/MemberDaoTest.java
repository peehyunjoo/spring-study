package com.zzu.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzu.domain.MemberVO;
import com.zzu.persistence.MemberDAO;
import com.zzu.persistence.MemberDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})	
public class MemberDaoTest {
	@Inject
	//private MemberDAO dao;
	private MemberDAOImpl dao;
	@Test
	public void testTime()throws Exception{
		System.out.println(dao.getTime());
	}
	
	@Test
	public void testInsertMember()throws Exception{
		MemberVO vo = new MemberVO();
		vo.setUserid("user01");
		vo.setUserpw("user00");
		vo.setUsername("USER00");
		vo.setEmail("user00@aaa.com");
		
		dao.insertMember(vo);
	}
	
}
