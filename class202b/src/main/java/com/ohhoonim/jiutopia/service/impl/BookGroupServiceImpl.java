package com.ohhoonim.jiutopia.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.jiutopia.service.BookGroupService;
import com.ohhoonim.vo.BookGroupVo;
import com.ohhoonim.common.util.Utils;
import com.ohhoonim.dao.BookGroupDao;

@Service("bookGroupService")
public class BookGroupServiceImpl implements BookGroupService{

	@Resource(name="bookGroupDao")
	BookGroupDao dao;

//	북마크 생성
	@Override
	public int bookGroupAdd(BookGroupVo vo) {
		return dao.bookGroupAdd(vo);
	}
	
//	북마크 아이디 생성
	@Override
	public String bookGroupIdGen(String memId) {
		StringBuffer sb = new StringBuffer();
		String groupId = dao.getGroupId(memId);
		
		if (groupId != null) {
			String id = "";
			int i = 0;
			String[] idSet = groupId.split("_");
			if (idSet.length == 2) {
				id = idSet[0];
				i = Integer.parseInt(idSet[1]) + 1;
				String num = Integer.toString(i);
				String newNum = Utils.fixedNumber(num, 4);
				sb.append(id);
				sb.append(newNum);
			}
		}
		return sb.toString();
	}

//	북마크 그룹 제거
	@Override
	public int bookGroupDel(BookGroupVo vo) {
		return dao.bookGroupDel(vo);
	}

//	북마크 그룹 리스트
	@Override
	public List<Map<String, String>> bookGroupListView(BookGroupVo vo) {
		return dao.bookGroupListView(vo);
	}
	

}
