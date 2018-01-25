package com.ohhoonim.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.BookGroupVo;
import com.ohhoonim.vo.BookmarkVo;

@Repository("bookmarkDao")
public class BookmarkDao extends Mapper{

	/*북마크 그룹 보기*/
	public List<Map<String, Object>> bookGroupView(Map<String, Object> bookVo) {
		return selectList("bookGroupView", bookVo);
	}
	
	/*북마크 추가*/
	public int bookmarkAdd(BookmarkVo vo) {
		return insert("bookmarkAdd", vo);
	}
	
	/*북마크 그룹에서 제거*/
	public int bookmarkDelFromGroup(BookmarkVo vo) {
		return update("bookmarkDelFromGroup", vo);
	}

//	북마크 그룹에 추가
	public int addIntoBookGroup(BookmarkVo vo) {
		return update("addIntoBookGroup", vo);
	}

//	북마크 그룹 제거
	public int bookGroupDel(BookGroupVo vo) {
		return update("bookmarkGroupDel", vo);
	}

//	즐겨찾기 해제
	public int bookmarkDel(BookmarkVo vo) {
		return delete("bookmarkDel", vo);
	}
	
}
