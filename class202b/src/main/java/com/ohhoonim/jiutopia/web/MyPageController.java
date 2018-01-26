package com.ohhoonim.jiutopia.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohhoonim.common.service.IdGenService;
import com.ohhoonim.common.util.Utils;
import com.ohhoonim.jiutopia.service.BookGroupService;
import com.ohhoonim.jiutopia.service.BookmarkService;
import com.ohhoonim.vo.BookGroupVo;
import com.ohhoonim.vo.BookmarkVo;

@Controller
@RequestMapping("/jiutopia")
public class MyPageController {
	
	@Resource(name="bookmarkService")
	BookmarkService bookmarkService;
	
	@Resource(name="bookGroupService")
	BookGroupService bookGroupService;
	
	@Resource(name="idGenService")
	IdGenService idGenService;
	
//	마이페이지 
	@RequestMapping("/mypage.do")
	public String mypage(@RequestParam Map<String, String> req, ModelMap model) {
		
		String id = req.get("memId");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memId", id);
		map.put("videoUrl", "'/jiutopia/videoDetail.do?videoId='");
		map.put("seminarUrl", "'/jiutopia/seminarDetail.do?eventId='");
		map.put("championshipUrl", "'/jiutopia/championshipDetail.do?eventId='");
		
		List<Map<String, Object>> bookedGroupList = bookmarkService.bookGroupView(map);
		Map<String, List<Map<String, Object>>> bookedGroupListMap = Utils.grouppingList(bookedGroupList);
		
		model.addAttribute("bookedGroupListMap", bookedGroupListMap);
		
		return "jiutopia/mypage";
	}
	
//	북마크 그룹 추가
	@RequestMapping("bookGroupAddPop.do")
	public String bookGroupAddPop(ModelMap model) {
				
		return "jiutopia/bookGroupAddPop";
	}
	@RequestMapping("bookGroupAdd.do")
	public String bookGruopAdd(@RequestParam Map<String, String> req, ModelMap model) {
		
		String memId = req.get("memId");
		String groupNm = req.get("groupNm") == null? "": req.get("groupNm");
		
		if (groupNm.equals("")) {
			String msg = "그룹명을 입력해 주세요.";
			
			Map<String, String> groupName = new HashMap<String, String>();
			
			groupName.put("msg", msg);
			
			return "redirect:/jiutopia/bookGroupAddPop.do";
		} else {

		String idx = idGenService.bookGroupIdGen(memId);
		
		BookGroupVo vo = new BookGroupVo();
		
		vo.setMemId(memId);
		vo.setIdx(idx);
		vo.setGroupNm(groupNm);
		
		bookGroupService.bookGroupAdd(vo);
		
		}
		
		return "redirect:/jiutopia/mypage.do?memId="+memId;
	}
	
//	북마크 그룹 제거
	@RequestMapping("bookGroupDel.do")
	public String bookGroupDel(@RequestParam Map<String, String> req, ModelMap model) {
				
		String memId = req.get("memId");
		String idx = req.get("idx");
		
		BookGroupVo vo = new BookGroupVo();
		
		vo.setMemId(memId);
		vo.setIdx(idx);

		bookmarkService.bookGroupDel(vo);
		bookGroupService.bookGroupDel(vo);
		
		return "redirect:/jiutopia/mypage.do?memId=" + memId;
	}
	
//	북마크 그룹에 북마크 게시물 추가
	@RequestMapping("addIntoBookGroupPop.do")
	public String bookmarkAddIntoPop(@RequestParam Map<String, String> req, ModelMap model) {
		
		String id = req.get("memId");

		BookGroupVo vo = new BookGroupVo();
		vo.setMemId(id);
		
		List<Map<String, String>> bookGroupList = bookGroupService.bookGroupListView(vo);
		
		model.addAttribute("bookGroupList", bookGroupList);
		
		return "jiutopia/addIntoBookGroupPop";
	}
	@RequestMapping("addIntoBookGroupAdd.do")
	public String addIntoBookGroupAdd(@RequestParam Map<String, String> req, ModelMap model) {
		
		String rtnUrl = "jiutopia/addIntoBookGroupPop";
		
		String memId = req.get("memId");
		String bookedId = req.get("bookedId");
		String groupNm = req.get("groupNm") == null? "": req.get("groupNm");

		if (groupNm.equals("")) {
			String msg = "그룹명을 입력해 주세요.";
			
			Map<String, String> groupName = new HashMap<String, String>();
			
			groupName.put("msg", msg);
			
			model.addAttribute("groupName", groupName);
			
			return rtnUrl;
		} else {

		String idx = idGenService.bookGroupIdGen(memId);
		
		BookGroupVo vo = new BookGroupVo();
		
		vo.setMemId(memId);
		vo.setIdx(idx);
		vo.setGroupNm(groupNm);
		
		bookGroupService.bookGroupAdd(vo);
	
		vo = new BookGroupVo();
		vo.setMemId(memId);
		
		List<Map<String, String>> bookGroupList = bookGroupService.bookGroupListView(vo);
		
		model.addAttribute("bookGroupList", bookGroupList);
		
		}
		return rtnUrl;
	}
	@RequestMapping("addIntoBookGroup.do")
	public String addIntoBookGroup(@RequestParam Map<String, String> req, ModelMap model) {

		String idx = req.get("idx");
		String id = req.get("bookedId");
		
		BookmarkVo vo = new BookmarkVo();
		
		vo.setIdx(idx);
		vo.setId(id);
		
		bookmarkService.addIntoBookGroup(vo);
		
		return "jiutopia/addIntoBookGroup";
	}
	
//	북마크 그룹에서 제거
	@RequestMapping("/bookmarkDelFromGroup.do")
	public String bookmarkDel(@RequestParam Map<String, Object> req, ModelMap model) {
	
		String memId = req.get("memId") == null? "": (String) req.get("memId");
		String id = req.get("id") == null? "": (String) req.get("id");
		
		BookmarkVo vo = new BookmarkVo();
		vo.setId(id);
		
		bookmarkService.bookmarkDelFromGroup(vo);
		
		return "redirect:/jiutopia/mypage.do?memId=" + memId;
	}

//	TODO 즐겨찾기 해제

}
