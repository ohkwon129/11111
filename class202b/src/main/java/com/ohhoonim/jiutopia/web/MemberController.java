package com.ohhoonim.jiutopia.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ohhoonim.jiutopia.service.MemberService;
import com.ohhoonim.vo.MemberVo;

@Controller
public class MemberController {

	@Resource(name="memberService")
	MemberService memvberservice;
	
	@RequestMapping("/jiutopia/MemberList.do")
	public String viewMemberList() {
	
		return "jiutopia/MemberList";
		
	}
	
	
}
