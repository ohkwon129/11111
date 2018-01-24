package com.ohhoonim.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.BookGroupVo;

@Repository("bookGroupDao")
public class BookGroupDao extends Mapper{

//	북마크 그룹 생성
	public int bookGroupAdd(BookGroupVo vo) {
		return insert("bookGroupAdd", vo);
	}
	
//	북마크 아이디 불러오기
	public String getGroupId(String memId) {
		return selectOne("getGroupId", memId);
	}

//	북마크 그룹 리스트
	public List<Map<String, String>> bookGroupListView(BookGroupVo vo) {
		return selectList("bookGroupListView", vo);
	}

//	북마크 그룹 제거
	public int bookGroupDel(BookGroupVo vo) {
		return delete("bookGroupDel", vo);
	}


}
