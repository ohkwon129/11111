package com.ohhoonim.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.EVCmmtVo;
import com.ohhoonim.vo.EventVo;

@Repository("eventDao")
public class EventDao extends Mapper {
	
	public List<EventVo> seminarList(EventVo vo) {
		return selectList("seminarList", vo); 
	}

	public List<Object> championshipList(EventVo vo) {
		return  selectList("championshipList", vo);
	}

	public Map<String, Object> getChampDetail(EventVo vo) {
		
		return selectOne("getChampDetail", vo);
	}

	public Map<String, Object> getSeminarDetail(EventVo vo) {
		
		return selectOne("getSeminarDetail", vo);
	}

	public int seminarListCnt(EventVo vo) {
		return selectOne("seminarListCnt", vo);
	}

	public List<EventVo> seminarList2(EventVo vo) {
		return selectList("seminarList2", vo);
	}

	public int seminarAdd(EventVo vo) {
		return insert("seminarAdd", vo);
	}

	public int championshipAdd(EventVo vo) {
		
		return insert("championshipAdd", vo);
	}

	public Map<String, Object> championshipModify(EventVo vo) {
		
		return selectOne("championshipModify", vo);
	}
	public int champListCnt(EventVo vo) {
		return selectOne("champListCnt", vo);
	}

	public Map<String, Object> seminarModify(EventVo vo) {
		
		return selectOne("seminarModify", vo);
	}

	public int seminarCmmtDel(EVCmmtVo vo) {
	
		return delete("eventCmmtDel",vo);
	}

	public int championshipCmmtDel(EVCmmtVo vo) {
	
		return delete("eventCmmtDel",vo);
	}

	public int seminarDelete(EventVo vo) {

		return delete("seminarDelete",vo);
	}

	public int championshipDelete(EventVo vo) {
		// TODO Auto-generated method stub
		return delete("championshipDelete",vo);
	}

	public List<Map<String, String>> eventScheduleList(Map vo) {
		return selectList("eventScheduleList", vo);
	}
}

