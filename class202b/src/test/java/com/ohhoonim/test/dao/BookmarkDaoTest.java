package com.ohhoonim.test.dao;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ohhoonim.dao.BookGroupDao;
import com.ohhoonim.dao.BookmarkDao;
import com.ohhoonim.vo.BookGroupVo;
import com.ohhoonim.vo.BookmarkVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:**/applicationContext.xml")
@TransactionConfiguration(defaultRollback=false)
@Transactional(value="txManager")
public class BookmarkDaoTest {

	@Resource(name="bookmarkDao")
	BookmarkDao dao;
	
	String[] memIds = {"mem01","jiu123","jurujuru"};
	String[] ctgr = {
			"SPT00005" ,"SPT00006" ,"DEF00005" ,"SEN00005" ,"CHP00004"
			,"SPT00003" ,"CHP00002" ,"DEF00004"
			};
	
	String[] groupId = {"0001","0002","0003"};
	
	@Test
	public void bookGroupAddTest() {
		
		for (int i = 0; i < 200000; i++) {
			BookmarkVo vo = new BookmarkVo();
			String memId = randomVal(memIds); 
			vo.setMemId(memId);
			vo.setCtgr(randomVal(ctgr));
			/*
			mem01 0001 ~ 0003  
			jiu123 0001
			*/
			if (memId.equals("mem01")) {
				vo.setIdx(randomVal(groupId));
			} else if(memId.equals("jiu123")) {
				vo.setIdx("0001");
			} else {
				vo.setIdx("");
			}
			dao.bookmarkAdd(vo);
			System.out.println(i);
		}
		
	}
	@Ignore
	@Test
	public void randomValTest() {
		System.out.println(randomVal(memIds));
		System.out.println(randomVal(groupId));
		System.out.println(randomVal(ctgr));
		
	}
	
	
	private String randomVal(String[] vals) {
		int size = vals.length;
		int i = (int)(Math.random() * size);
		
		return vals[i];
	}
	
}




















