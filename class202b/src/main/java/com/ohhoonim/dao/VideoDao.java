package com.ohhoonim.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.VideoVo;

@Repository("videoDao")
public class VideoDao extends Mapper {
	
	public List<VideoVo> videoListView(VideoVo vo) {
		return selectList("videoListView", vo);
	}
	
	public List<VideoVo> sptListView(VideoVo vo) {
		return selectList("sptListView", vo);
	}
	
	public List<VideoVo> defListView(VideoVo vo) {
		return selectList("defListView", vo);
	}

	public Map<String, String> videoDetailView(VideoVo vo) {
		return selectOne("videoDetailView", vo);
	}

	public int videoListCnt(VideoVo vo) {
		return selectOne("videoListCnt", vo);
	}

	public int videoDel(VideoVo vo) {
		return update("videoDel", vo);
	}

	public int videoAdd(VideoVo vo) {
		return insert("videoAdd", vo);
	}

	
	
}
