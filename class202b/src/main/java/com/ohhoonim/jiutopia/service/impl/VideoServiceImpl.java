package com.ohhoonim.jiutopia.service.impl;

import org.springframework.stereotype.Service;

import com.ohhoonim.jiutopia.service.VideoService;
import com.ohhoonim.vo.VideoVo;
import com.ohhoonim.dao.VideoDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
	
	@Resource(name="videoDao")
	VideoDao dao;
	
	@Override
	public Map<String, Object> videoListView(VideoVo vo) {
		List<VideoVo> list = dao.videoListView(vo);
		int listCount = dao.videoListCnt(vo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list",list);
		resultMap.put("listCount",listCount);
		return resultMap;
	}
	
	@Override
	public List<VideoVo> sptListView(VideoVo vo) {
		List<VideoVo> list = dao.sptListView(vo);
		return list;
	}
	
	@Override
	public List<VideoVo> defListView(VideoVo vo) {
		List<VideoVo> list = dao.defListView(vo);
		return list;
	}

	@Override
	public Map<String, String> videoDetailView(VideoVo vo) {
		Map<String, String> map = dao.videoDetailView(vo);
		return map;
	}

	@Override
	public int videoDel(VideoVo vo) {
		return dao.videoDel(vo);
	}

	@Override
	public int videoAdd(VideoVo vo) {
		return dao.videoAdd(vo);
	}
	
}
