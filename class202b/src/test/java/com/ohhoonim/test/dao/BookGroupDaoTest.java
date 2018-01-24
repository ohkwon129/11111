package com.ohhoonim.test.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ohhoonim.dao.BookGroupDao;
import com.ohhoonim.vo.BookGroupVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:**/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional(value = "txManager")

public class BookGroupDaoTest {

	@Resource(name="bookGroupDao")
	BookGroupDao dao;
	
	@Mock
	private BookGroupVo vo;
	
	@Test
	public void bookGroupAddTest() {
		int result = dao.bookGroupAdd(vo);
		System.out.println(result);
	}
	
//	@Test
//	public void bookGroupIdGenTest() {
//		
//		String result = dao.getGroupId("mem01");
//		System.out.println(result);
//	}
}
