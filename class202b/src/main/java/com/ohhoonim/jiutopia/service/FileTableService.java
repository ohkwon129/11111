package com.ohhoonim.jiutopia.service;

import java.util.Map;

import com.ohhoonim.vo.FileTableVo;

public interface FileTableService {
	public FileTableVo selectFiles(FileTableVo vo);
	public int addFiles(FileTableVo vo);
	public int updateFiles(FileTableVo vo);
	public int deleteFiles(FileTableVo vo);
	public Map<String, Object> fileList(FileTableVo vo);
}
