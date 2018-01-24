package com.ohhoonim.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.ohhoonim.vo.EventVo;
import com.ohhoonim.vo.FileTableVo;

@Repository("fileTableDao")
public class FileTableDao extends Mapper{

	public FileTableVo selectFiles(FileTableVo vo) {
		
		return null;
	}

	public int addFiles(FileTableVo vo) {
		return insert("addFiles", vo);
	}

	public int updateFiles(FileTableVo vo) {
		
		return 0;
	}

	public int deleteFiles(FileTableVo vo) {
		
		return 0;
	}

	public List<EventVo> fileList(FileTableVo vo) {
		return selectList ("fileList", vo);
	}

	public int fileListCnt(FileTableVo vo) {
		return selectOne("fileListCnt", vo);
	}

}
