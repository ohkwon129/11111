package com.ohhoonim.jiutopia.service;

import java.util.List;
import java.util.Map;

import com.ohhoonim.vo.VideoVo;

public interface VideoService {

	public Map<String, Object> videoListView(VideoVo vo);
	public List<VideoVo> sptListView(VideoVo vo);
	public List<VideoVo> defListView(VideoVo vo);
	public Map<String, String> videoDetailView(VideoVo vo);
	public int videoDel(VideoVo vo);
	public int videoAdd(VideoVo vo);
	
}
