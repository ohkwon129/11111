package com.ohhoonim.jiutopia.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ohhoonim.common.util.Utils;
import com.ohhoonim.jiutopia.service.BookmarkService;
import com.ohhoonim.jiutopia.service.CrewService;
import com.ohhoonim.jiutopia.service.MemberService;
import com.ohhoonim.jiutopia.service.VideoService;
import com.ohhoonim.vo.BookmarkVo;
import com.ohhoonim.vo.CrewVo;
import com.ohhoonim.vo.MemberVo;
import com.ohhoonim.vo.VideoVo;


@Controller
@RequestMapping("/jiutopia")
public class MainController {
	
	@Resource(name="memberService")
	MemberService memberService;
	
	@Resource(name="bookmarkService")
	BookmarkService bookmarkService;
	
	@Resource(name="videoService")
	VideoService videoService;
	
	@RequestMapping("/main.do")
	public String main(@RequestParam Map<String, String> req, HttpServletRequest request) {
		
		return "jiutopia/main";
	}

	@RequestMapping("/loginView.do")
	public String loginView(@RequestParam Map<String, String> req) {
		
		return "jiutopia/login";
	}
	
	@RequestMapping("/logout.do")
	public String logout(@RequestParam Map<String, String> req, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginedMember");
		session.removeAttribute("loginId");
		return "jiutopia/main";
	}
	
	@RequestMapping("/login.do")
	public String login(@RequestParam Map<String, String> req, HttpServletRequest request) {
		String id = Utils.toEmptyBlank(req.get("id"));
		String pwd = Utils.toEmptyBlank(req.get("pwd"));
		
		String returnUrl = "redirect:/jiutopia/main.do";
		
		if (Utils.isEmpty(id) || Utils.isEmpty(pwd)) {
			
			returnUrl = "redirect:/jiutopia/loginView.do";
		} else {
			HttpSession session = request.getSession();
			
			MemberVo vo = new MemberVo();
			vo.setMemId(id);
			vo.setMemPw(pwd);
			
			if(memberService.isMember(vo)) {
				MemberVo resultVo = memberService.getMemberInfo(vo);
				session.setAttribute("loginedMember", resultVo);
				session.setAttribute("loginId", resultVo.getMemId());
				
			} else {
				returnUrl = "redirect:/jiutopia/loginView.do";
			}
			
		}
		
		return returnUrl;
	}
	
}
