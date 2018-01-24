package com.ohhoonim.jiutopia.service;

import java.util.List;
import java.util.Map;

import com.ohhoonim.vo.GymVo;

public interface GymService {
	
	public List<GymVo> gymListView(GymVo vo);
	public  int gymAdd(GymVo vo);
	public List<GymVo> gymDetail(GymVo vo);
	public GymVo getGymById(GymVo vo);
	public Map<String, String> gymModify(GymVo vo);
	public int gymRemove(GymVo vo);


}
