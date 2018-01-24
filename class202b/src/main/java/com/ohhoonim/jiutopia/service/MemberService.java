package com.ohhoonim.jiutopia.service;

import java.util.List;

import com.ohhoonim.vo.MemberVo;

public interface MemberService {
	public List<MemberVo> viewMemberList(MemberVo vo);
	public boolean isMember(MemberVo vo);
	public MemberVo getMemberInfo(MemberVo vo);
}
