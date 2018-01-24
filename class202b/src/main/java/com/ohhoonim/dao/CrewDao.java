package com.ohhoonim.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.CrewVo;

@Repository("crewDao")

public class CrewDao extends Mapper {

	public List<CrewVo> crewListView(CrewVo vo) {

		return selectList("crewListView", vo);
	}

	public List<CrewVo> crewDetail(CrewVo vo) {
		
		return selectList("crewDetail", vo);
	}	
	
	public List<CrewVo> crewBoardWriteView(CrewVo vo){
		
		return selectList("crewBoardWriteView", vo);
	}
	
	public List<CrewVo> crewBoardWrite(CrewVo vo) {
		
		return selectList("crewBoardWrite", vo);
	}
	
	public List<CrewVo> crewBoardModifyView(CrewVo vo) {
		
		return selectList("crewBoardModifyView", vo);
	}
	
	public List<CrewVo> crewBoardModify(CrewVo vo) {
		
		return selectList("crewBoardModify", vo);
	}
	
	public List<CrewVo> crewBoardDelete(CrewVo vo) {
		
		return selectList("crewBoardDelete", vo);
	}

	public List<CrewVo> crewAdd(CrewVo vo) {
		return null;
	}
}
