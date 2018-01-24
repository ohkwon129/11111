package com.ohhoonim.jiutopia.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.FileTableDao;
import com.ohhoonim.jiutopia.service.FileTableService;
import com.ohhoonim.vo.EventVo;
import com.ohhoonim.vo.FileTableVo;

@Service("fileTableService")
public class FileTableServiceImpl implements FileTableService {

	@Resource(name="fileTableDao")
	FileTableDao dao;
	@Override
	public FileTableVo selectFiles(FileTableVo vo) {
		return dao.selectFiles(vo);
	}
	@Override
	public int addFiles(FileTableVo vo) {
		return dao.addFiles(vo);
	}
	@Override
	public int updateFiles(FileTableVo vo) {
		return dao.updateFiles(vo);
	}
	@Override
	public int deleteFiles(FileTableVo vo) {
		return dao.deleteFiles(vo);
	}

	@Override
	public Map<String, Object> fileList(FileTableVo vo) {
		List<EventVo> list = dao.fileList(vo);
		int listCount=dao.fileListCnt(vo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", list);
		resultMap.put("listCount", listCount);
		return resultMap;
	}

}
