package com.ohhoonim.dao;

import org.springframework.stereotype.Repository;

@Repository("idGenDao")
public class IdGenDao extends Mapper{
	
	public String getNextId(String tableName){
		return selectOne("getNextId", tableName);
	}
	
	public int updateNextId(String tableName) {
		return update("updateNextId", tableName);
	}
	
//	북마크 그룹 아이디 넘버 불러오기
	public String getGroupNo(String memId) {
		return selectOne("getGroupNo", memId);
	}
	
//	북마크 그룹 아이디 넘버 업데이트
	public int updateGroupNo(String memId) {
		return update("updateGroupNo", memId);
	}
}
