package com.ohhoonim.jiutopia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ohhoonim.dao.MemberDao;
import com.ohhoonim.jiutopia.service.MemberService;
import com.ohhoonim.vo.MemberVo;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="memberDao")
	MemberDao memberDao;
	
	public List<MemberVo> viewMemberList(MemberVo vo) {
		return null;
	}

	@Override
	public boolean isMember(MemberVo vo) {
		boolean result = false;
		int cnt = memberDao.isMember(vo);
		if (cnt > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public MemberVo getMemberInfo(MemberVo vo) {
		return memberDao.getMemberInfo(vo);
	}
	

}
