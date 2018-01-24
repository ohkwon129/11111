package com.ohhoonim.test.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ohhoonim.common.service.IdGenService;
import com.ohhoonim.common.service.impl.IdGenServiceImpl;
import com.ohhoonim.common.util.Utils;
import com.ohhoonim.dao.BookGroupDao;
import com.ohhoonim.jiutopia.service.BookGroupService;
import com.ohhoonim.jiutopia.service.impl.BookGroupServiceImpl;
import com.ohhoonim.vo.BookGroupVo;

@RunWith(MockitoJUnitRunner.class)
public class BookGroupServiceTest {
	
	@InjectMocks
	private BookGroupService service = new BookGroupServiceImpl();
	
	@Mock
	BookGroupDao dao;

//	@Test
//	public void bookGroupIdGenTest() {
//		
//		when(dao.getGroupId((String)anyObject())).thenReturn("mem01_0002");
//		
//		String result = service.bookGroupIdGen("mem01");
//		
//		assertThat(result, is("mem01_0003"));
//	}
	
}
