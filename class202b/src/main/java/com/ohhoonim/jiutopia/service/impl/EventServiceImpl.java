package com.ohhoonim.jiutopia.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.EVCmmtDao;
import com.ohhoonim.dao.EventDao;
import com.ohhoonim.jiutopia.service.EventService;
import com.ohhoonim.vo.EVCmmtVo;
import com.ohhoonim.vo.EventVo;


@Service("eventService")
public class EventServiceImpl implements EventService {

	@Resource(name="eventDao")
	EventDao dao;

	@Resource(name="evcmmtDao")
	EVCmmtDao cmmtdao;
	
	
	public List<EventVo> seminarList(EventVo vo) {
		List<EventVo> list = dao.seminarList(vo);
		return list;
	}

	@Override
	public Map<String, Object> championshipList(EventVo vo) {
		List<Object> list = dao.championshipList(vo);
		int listCount = dao.champListCnt(vo);
	
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", list);
		resultMap.put("listCount", listCount);
		return resultMap;
	}

	@Override
	public Map<String, Object> getChampDetail(EventVo vo) {
		Map<String, Object> resultVo = dao.getChampDetail(vo);
		return resultVo;
	}

	@Override
	public Map<String, Object> getSeminarDetail(EventVo vo) {
		Map<String, Object> resultVo = dao.getSeminarDetail(vo);
		return resultVo;
	}

	@Override
	public Map<String, Object> seminarList2(EventVo vo) {
		List<EventVo> list = dao.seminarList2(vo);
		int listCount=dao.seminarListCnt(vo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", list);
		resultMap.put("listCount", listCount);
		return resultMap;
	}

	@Override
	public int seminarAdd(EventVo vo) {
		
		return dao.seminarAdd(vo);
	}

	@Override
	public int championshipAdd(EventVo vo) {
		
		return dao.championshipAdd(vo);
	}

	@Override
	public Map<String, Object> championshipModify(EventVo vo) {
		
		return dao.championshipModify(vo);
	}

	@Override
	public Map<String, Object> seminarModify(EventVo vo) {
	
		return dao.seminarModify(vo);
	}



	@Override
	public int seminarCmmtDel(EVCmmtVo vo) {
		
		return dao.seminarCmmtDel(vo);
	}

	@Override
	public int championshipCmmtDel(EVCmmtVo vo) {
		
		return dao.championshipCmmtDel(vo);
	}

	
	@Override
	public int seminarDelete(EventVo vo) {
		
		return dao.seminarDelete(vo);
	}

	@Override
	public int championshipDelete(EventVo vo) {
		// TODO Auto-generated method stub
		return dao.championshipDelete(vo);
	}

	@Override
	public List<Map<String, String>> eventScheduleList(Map vo) {
		return dao.eventScheduleList(vo);
	}

	
}


