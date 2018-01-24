package com.ohhoonim.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.GymVo;

@Repository("gymDao")
public class GymDao extends Mapper {

	public List<GymVo> gymListView(GymVo vo) {
		return selectList("gymListView", vo);
	}
	
	public List<GymVo> gymDetail(GymVo vo) {
		
		return selectList("gymDetail",vo);
	}

	public List<GymVo> gymAddView(GymVo vo) {

		return selectList("gymAddView",vo);
	}


	public int gymAdd(GymVo vo) {
	
		return insert("gymAdd",vo);
	}

	public GymVo getGymById(GymVo vo) {
		
		return selectOne("getGymById",vo);
	}

	public Map<String, String> gymModify(GymVo vo) {
	
		return selectOne("gymModify",vo);
	}

	public int gymRemove(GymVo vo) {
		
		return delete("gymRemove",vo);
	}

	public Map<String, Object> getgymId(GymVo vo) {
	
		return selectOne("getgymId",vo);
	}
	
}
