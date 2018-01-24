package com.ohhoonim.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.EVCmmtVo;
import com.ohhoonim.vo.EventVo;

@Repository("evcmmtDao")
public class EVCmmtDao extends Mapper{
	
	/*비디오 댓글 목록*/
	public List<EVCmmtVo> videoCmmtList(EVCmmtVo vo) {
		return selectList("videoCmmtList", vo);
	}
	
	/*비디오 댓글 입력*/
	public int videoCmmtAdd(EVCmmtVo vo) {
		return insert("videoCmmtAdd", vo);
	}

	/*비디오 댓글 수정*/
	public int videoCmmtModify(EVCmmtVo vo) {
		return update("videoCmmtModify", vo);
	}
	public Map<String, String> cmmtDetialView(EVCmmtVo vo) {
		return null;
	}
	
	/*비디오 댓글 삭제*/
	public int videoCmmtDel(EVCmmtVo vo) {
		return delete("videoCmmtDel", vo);
	}

	public int eventCmmtAdd(EVCmmtVo vo) {
		return insert("eventCmmtAdd", vo);
	}

	public List<EVCmmtVo> geteventCmmtList(EVCmmtVo eVo) {
		return selectList("geteventCmmtList", eVo);
	}

	public int eventCmmtCnt(EVCmmtVo eVo) {
		return selectOne("eventCmmtCnt", eVo);
	}

	public List<EVCmmtVo> eventCmmtList(EVCmmtVo eVo) {
		return selectList("eventCmmtList", eVo);
	}

	public int championshipCmmtDel(EVCmmtVo vo) {

		return delete("eventCmmtDel", vo);
	}

	public int seminarcmmtDel(EVCmmtVo vo) {

		return delete("eventCmmtDel", vo);
	}
	
	
}
