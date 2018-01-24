package com.ohhoonim.jiutopia.service;

import java.util.List;
import java.util.Map;

import com.ohhoonim.vo.BookGroupVo;

public interface BookGroupService {

	public int bookGroupAdd(BookGroupVo vo);
	
	public String bookGroupIdGen(String memId);

	public int bookGroupDel(BookGroupVo vo);

	public List<Map<String, String>> bookGroupListView(BookGroupVo vo);
	
}
