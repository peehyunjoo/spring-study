package com.zzu.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

//root-context에 등록되어져있는 것을 가지고온다.(ex mybatis 설정등등...)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

//Connection test(mybatis)
public class MyBatisTest{
	@Inject //inject(사용하기위한 선언 후 주입)
	private SqlSessionFactory sqlFactory;
	
	//sql factory test
	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}
	
	//sql factory session test
	@Test
	public void testSession() throws Exception {
		try {
			SqlSession session = sqlFactory.openSession();
			System.out.println(session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
