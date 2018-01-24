package com.ohhoonim.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ohhoonim.dao.IdGenDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:**/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional(value = "txManager")
public class IdsDaoTest {
	
	@Resource(name="idGenDao")
	IdGenDao dao;

	@Test
	public void getNextIdTest() {
		/*
		 코드명       코드    용도
		--------------------------------
		VIDEO_SPT    SPT    대회영상
		VIDEO_DEF    DEF    호신술강좌
		EVENT_SEN    SEN    세미나
		EVENT_CHP    CHP    대회일정
		
		
		- 사용테이블
		video       video_id
		event       event_id
		file_table  file_id

		 */
		String result = dao.getNextId("VIDEO_SPT");
		
		System.out.println("get " + result);		
	}

	@Test
	public void updatenextIdTest() {
		dao.updateNextId("VIDEO_SPT");
		String result = dao.getNextId("VIDEO_SPT");
		System.out.println("udpate " + result);	
	}

	/**
	 * 실제로 사용할 때는 아래 코드처럼 사용하면됨.
	 * nextId로 값을 가져와서 사용하고 바로 업데이트 쳐줌
	 */
	@Test
	public void usingTest() {
		String result = dao.getNextId("VIDEO_SPT");
		dao.updateNextId("VIDEO_SPT");
	}
	
}






















