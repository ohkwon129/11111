package com.ohhoonim.test.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ohhoonim.jiutopia.service.BookGroupService;
import com.ohhoonim.jiutopia.service.BookmarkService;
import com.ohhoonim.jiutopia.web.MyPageController;
import com.ohhoonim.vo.BookGroupVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:**/applicationContext.xml")
@WebAppConfiguration
public class MyPageControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private BookmarkService bookmarkService;
	private BookGroupService bookGroupService;
	private BookGroupVo vo;
	
	@InjectMocks
	private MyPageController controller = new MyPageController();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void bookGruopAddTest() throws Exception {
		
	}

}
