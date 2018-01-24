package com.ohhoonim.jiutopia.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.EVCmmtDao;
import com.ohhoonim.jiutopia.service.EVCmmtService;
import com.ohhoonim.vo.EVCmmtVo;

@Service("evcmmtService")
public class EVCmmtServiceImpl implements EVCmmtService{
	
	@Resource(name="evcmmtDao")
	EVCmmtDao dao;
	
	/*비디오 댓글 목록*/
	@Override
	public List<EVCmmtVo> videoCmmtList(EVCmmtVo vo) {
		List<EVCmmtVo> list = dao.videoCmmtList(vo);
		return list;
	}

	/*비디오 댓글 입력*/
	@Override
	public int videoCmmtAdd(EVCmmtVo vo) {
		return dao.videoCmmtAdd(vo);
	}
	
	/*비디오 댓글 수정*/
	@Override
	public Map<String, String> cmmtDetialView(EVCmmtVo vo) {
		return dao.cmmtDetialView(vo);
	}
	@Override
	public int videoCmmtModify(EVCmmtVo vo) {
		return dao.videoCmmtModify(vo);
	}
	
	/* 비디오 댓글 삭제 */
	@Override
	public int videoCmmtDel(EVCmmtVo vo) {
		return dao.videoCmmtDel(vo);
	}
	
	//event 댓글 입력
		@Override
		public int eventCmmtAdd(EVCmmtVo vo) {
			return dao.eventCmmtAdd(vo);
		}

		@Override
		public List<EVCmmtVo> geteventCmmtList(EVCmmtVo eVo) {
			List<EVCmmtVo> list = dao.geteventCmmtList(eVo);
			return list;
		}

		@Override
		public Map<String, Object> eventCmmtList(EVCmmtVo eVo) {
			List<EVCmmtVo> list = dao.eventCmmtList(eVo);
			int listCount = dao.eventCmmtCnt(eVo);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("list",list);
			resultMap.put("listCount",listCount);
			return resultMap;
		}

		@Override
		public int championshipCmmtDel(EVCmmtVo vo) {
			return dao.championshipCmmtDel(vo);
		}
		@Override
		public int seminarcmmtDel(EVCmmtVo vo) {
			return dao.seminarcmmtDel(vo);
		}
	
}
