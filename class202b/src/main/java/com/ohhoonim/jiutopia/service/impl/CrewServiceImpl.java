package com.ohhoonim.jiutopia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.CrewDao;
import com.ohhoonim.jiutopia.service.CrewService;
import com.ohhoonim.vo.CrewVo;

@Service("crewService")
public class CrewServiceImpl implements CrewService{
	
	@Resource(name = "crewDao")
	CrewDao dao;
	
	@Override
	public List<CrewVo> crewListView(CrewVo vo) {
		
		List<CrewVo> list = dao.crewListView(vo);
		
		return list;
	}
	@Override
	public List<CrewVo> crewDetail(CrewVo vo) {
		
		List<CrewVo> list = dao.crewDetail(vo);	
		
		return list;
	}
	@Override
	public List<CrewVo> crewBoardWriteView(CrewVo vo) {
		
		List<CrewVo> list = dao.crewBoardWriteView(vo);
		
		return list;
	}
	@Override
	public List<CrewVo> crewBoardWrite(CrewVo vo) {
		
		List<CrewVo> list = dao.crewBoardWrite(vo);
		
		return list;
	}
	@Override
	public List<CrewVo> crewBoardModifyView(CrewVo vo) {
		
		List<CrewVo> list = dao.crewBoardModifyView(vo);
		
		return list;
	}
	@Override
	public List<CrewVo> crewAdd(CrewVo vo) {
		List<CrewVo> list = dao.crewAdd(vo);
		
		return list;
	}
	@Override
	public List<CrewVo> crewDetailView(CrewVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
