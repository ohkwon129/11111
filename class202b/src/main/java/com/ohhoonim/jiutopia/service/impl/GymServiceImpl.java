package com.ohhoonim.jiutopia.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.GymDao;
import com.ohhoonim.jiutopia.service.GymService;
import com.ohhoonim.vo.GymVo;

@Service("gymService")
public class GymServiceImpl implements GymService {
	
	@Resource(name="gymDao")
	GymDao dao;

	@Override
	public List<GymVo> gymListView(GymVo vo) {
		List<GymVo> list = dao.gymListView(vo);
		return list;
	}

	@Override
	public List<GymVo> gymDetail(GymVo vo) {
		List<GymVo> list = dao.gymDetail(vo);		
		return list;
	}


	@Override
	public int gymAdd(GymVo vo) {
		int list = dao.gymAdd(vo);
		return list;
	}

	@Override
	public GymVo getGymById(GymVo vo) {
	
		return dao.getGymById(vo);
	}

	@Override
	public Map<String, String> gymModify(GymVo vo) {
		
		return dao.gymModify(vo);
	}

	@Override
	public int gymRemove(GymVo vo) {
		int list = dao.gymRemove(vo);
		return list;
	}

	

}
