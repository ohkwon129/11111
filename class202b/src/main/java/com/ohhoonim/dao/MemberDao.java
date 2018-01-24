package com.ohhoonim.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.ohhoonim.vo.MemberVo;

@Repository("memberDao")
public class MemberDao extends Mapper{

	public List<MemberVo>  viewMemberList(MemberVo vo) {
		return selectList("viewMemberList", vo);
	}

	public int isMember(MemberVo vo) {
		return selectOne("isMember", vo);
	}

	public MemberVo getMemberInfo(MemberVo vo) {
		return selectOne("getMemberInfo" , vo);
	}
	
}
