package com.ohhoonim.jiutopia.service;

import java.util.List;

import com.ohhoonim.vo.CrewVo;

public interface CrewService {

	public List<CrewVo> crewListView(CrewVo vo);

	public List<CrewVo> crewDetailView(CrewVo vo);

	public List<CrewVo> crewDetail(CrewVo vo);
	
	public List<CrewVo> crewBoardWriteView(CrewVo vo);

	public List<CrewVo> crewBoardWrite(CrewVo vo);

	public List<CrewVo> crewBoardModifyView(CrewVo vo);

	public List<CrewVo> crewAdd(CrewVo vo);

}
