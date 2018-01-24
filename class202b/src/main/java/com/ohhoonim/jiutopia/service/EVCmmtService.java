package com.ohhoonim.jiutopia.service;

import java.util.List;
import java.util.Map;

import com.ohhoonim.vo.EVCmmtVo;

public interface EVCmmtService {
	public List<EVCmmtVo> videoCmmtList(EVCmmtVo vo);

	public int videoCmmtAdd(EVCmmtVo vo);

	public int videoCmmtDel(EVCmmtVo vo);
	

	public Map<String, String> cmmtDetialView(EVCmmtVo vo);

	public int videoCmmtModify(EVCmmtVo vo);

	
	public int eventCmmtAdd(EVCmmtVo vo);

	public List<EVCmmtVo> geteventCmmtList(EVCmmtVo eVo);

	public Map<String, Object> eventCmmtList(EVCmmtVo eVo);

	public int championshipCmmtDel(EVCmmtVo vo);

	public int seminarcmmtDel(EVCmmtVo vo);
}
