package com.ohhoonim.common.service;

public interface IdGenService {
	public String getNextId(String tableName);
	
//	북마크 그룹 아이디 생성
	public String bookGroupIdGen(String memId);
//	비디오 썸네일 생성
	public String thumbGen(String url);
}
