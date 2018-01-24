package com.ohhoonim.test.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.ohhoonim.common.service.IdGenService;
import com.ohhoonim.common.service.impl.IdGenServiceImpl;
import com.ohhoonim.dao.IdGenDao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;


@RunWith(MockitoJUnitRunner.class)
public class IdGenServiceTest {
	
	@InjectMocks
	private IdGenServiceImpl service = new IdGenServiceImpl();
	
	@Mock
	IdGenDao idGenDao;
		
//	@Test
//	public void getNextIdTest() {
//		/*
//		 코드명       코드    용도
//		--------------------------------
//		VIDEO_SPT    SPT    대회영상
//		VIDEO_DEF    DEF    호신술강좌
//		EVENT_SEN    SEN    세미나
//		EVENT_CHP    CHP    대회일정
//		
//		
//		- 사용테이블
//		video       video_id
//		event       event_id
//		file_table  file_id
//
//		 */
//		
//		when(idGenDao.getNextId("VIDEO_SPT")).thenReturn("1");
//		
//		String result = service.getNextId("VIDEO_SPT");
//
//		System.out.println(result);
//		
//		assertThat(result.length(), is(8));
//		
//	}
	
	@Test
	public void bookGroupIdGenTest() {
		when(idGenDao.getGroupNo("mem01")).thenReturn("2");
		
		String result = service.bookGroupIdGen("mem01");
		
		assertThat(result, is("mem010002"));
	}
}





















