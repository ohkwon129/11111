package com.ohhoonim.jiutopia.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.BookmarkDao;
import com.ohhoonim.jiutopia.service.BookmarkService;
import com.ohhoonim.vo.BookGroupVo;
import com.ohhoonim.vo.BookmarkVo;

@Service("bookmarkService")
public class BookmarkServiceImpl implements BookmarkService{
	
	@Resource(name="bookmarkDao")
	BookmarkDao dao;

//	북마크 그룹
	@Override
	public List<Map<String, Object>> bookGroupView(Map<String, Object> bookVo) {
		return dao.bookGroupView(bookVo);
	}
	
//	북마크 추가
	@Override
	public int bookmarkAdd(BookmarkVo vo) {
		return dao.bookmarkAdd(vo);
	}
	
//	북마크 그룹에서 제거
	@Override
	public int bookmarkDelFromGroup(BookmarkVo vo) {
		return dao.bookmarkDelFromGroup(vo);
	}

//	북마크 그룹에 북마크 게시물 추가
	@Override
	public int addIntoBookGroup(BookmarkVo vo) {
		return dao.addIntoBookGroup(vo);
	}

//	북마크 그룹 제거
	@Override
	public int bookGroupDel(BookGroupVo vo) {
		return dao.bookGroupDel(vo);
	}

//	즐겨찾기 해제
	@Override
	public int bookmarkDel(BookmarkVo vo) {
		return dao.bookmarkDel(vo);
	}
}
