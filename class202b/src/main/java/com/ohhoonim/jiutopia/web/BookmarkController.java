package com.ohhoonim.jiutopia.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ohhoonim.jiutopia.service.BookmarkService;
import com.ohhoonim.vo.BookmarkVo;

@Controller
@RequestMapping("/jiutopia")
public class BookmarkController {
	
	@Resource(name="bookmarkService")
	BookmarkService bookmarkService;
	
//	북마크 추가
	@RequestMapping("/bookmarkAdd.do")
	public String bookmarkAdd(@RequestParam Map<String, String> req, ModelMap model) {
		
		String memId = req.get("memId") == null? "": req.get("memId");
		String ctgr = req.get("ctgr") == null? "": req.get("ctgr");
		
		BookmarkVo vo = new BookmarkVo();
		vo.setMemId(memId);
		vo.setCtgr(ctgr);
		
		bookmarkService.bookmarkAdd(vo);
		
		return "redirect:/jiutopia/mypage.do?memId=" + memId;
	}

//	북마크 해제
	@RequestMapping("/bookmarkDel.do")
	public String bookmarkDel(@RequestParam Map<String, String> req, ModelMap model) {
		
		String memId = req.get("memId") == null? "": req.get("memId");
		String id = req.get("id") == null? "": req.get("id");

		BookmarkVo vo = new BookmarkVo();
		vo.setId(id);
		
		bookmarkService.bookmarkDel(vo);
		
		return "redirect:/jiutopia/mypage.do?memId=" + memId;
	}
	
}
