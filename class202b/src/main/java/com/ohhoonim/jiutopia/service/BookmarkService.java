package com.ohhoonim.jiutopia.service;

import java.util.List;
import java.util.Map;

import com.ohhoonim.vo.BookmarkVo;

public interface BookmarkService {
	
//  북마크 그룹
	List<Map<String, Object>> bookGroupView(Map<String, Object> bookVo);

//	북마크 추가
	public int bookmarkAdd(BookmarkVo vo);

//	북마크 그룹에서 제거
	public int bookmarkDelFromGroup(BookmarkVo vo);

//	북마크 그룹에 북마크 게시물 추가
	public int addIntoBookGroup(BookmarkVo vo);
	
}
