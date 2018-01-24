package com.ohhoonim.jiutopia.service;

import java.util.List;
import java.util.Map;

import com.ohhoonim.vo.EVCmmtVo;
import com.ohhoonim.vo.EventVo;

public interface EventService {
	public List<EventVo> seminarList(EventVo vo);

	public Map<String, Object> championshipList(EventVo vo);

	public Map<String, Object> getChampDetail(EventVo vo);

	public Map<String, Object> getSeminarDetail(EventVo vo);

	public Map<String, Object> seminarList2(EventVo vo);

	public int seminarAdd(EventVo vo);

	public int championshipAdd(EventVo vo);

	public Map<String, Object> championshipModify(EventVo vo);

	public Map<String, Object> seminarModify(EventVo vo);

	public int seminarCmmtDel(EVCmmtVo vo);
	public int championshipCmmtDel(EVCmmtVo vo);

	public int seminarDelete(EventVo vo);

	public int championshipDelete(EventVo vo);

	public List<Map<String, String>> eventScheduleList(Map vo);
}
