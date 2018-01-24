package com.ohhoonim.jiutopia.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohhoonim.common.util.Utils;
import com.ohhoonim.jiutopia.service.CrewService;
import com.ohhoonim.vo.CrewVo;

@Controller
@RequestMapping("/jiutopia")
public class CrewController {
	
	@Resource(name="crewService")
	CrewService crewService;
	
	@RequestMapping("/crewListView.do")
	public String viewCrewList(@RequestParam Map<String, String> req, ModelMap model) {
		
		String searchName = req.get("searchName") == null? "" : req.get("searchName");
		
		CrewVo vo = new CrewVo();
		vo.setCrewNm(searchName);
		
		List<CrewVo> crewList = (List<CrewVo>)crewService.crewListView(vo); 
				
		model.addAttribute("crewList", crewList);
		model.addAttribute("searchName", searchName);
		
		return "jiutopia/crewListView";
	}
	@RequestMapping("/crewList.do")
	public String crewList(@RequestParam Map<String, String> req, ModelMap model) {
		
		CrewVo vo = new CrewVo();
		List<CrewVo> crewList = crewService.crewListView(vo);
		model.addAttribute("crewList", crewList);
		
		return "jiutopia/crewListView";
	}
	@RequestMapping("/crewAddView.do")
	public String crewAddView(ModelMap model) {
		
		
		return "jiutopia/crewAdd";
	}
	@RequestMapping("/crewAdd.do")
	public String crewAdd(@RequestParam Map<String, String> req, RedirectAttributes reAttr) {
		
		String crewId = req.get("crewId") == null? "" : req.get("crewId");
		String crewLoc = req.get("crewLoc") == null? "" : req.get("crewLoc");
		String crewNm = req.get("crewNm") == null? "" : req.get("crewNm");
		String crewCont = req.get("crewCont") == null? "" : req.get("crewCont");
		
		if (crewId.equals("") || crewLoc.equals("") || crewNm.equals("")) {
			req.put("crewId", "crewCont,crewLoc and crewNm value is required.");
			reAttr.addFlashAttribute("rtnParams", req);
		}
		
		CrewVo vo = new CrewVo();
		vo.setCrewId(crewId);
		vo.setCrewLoc(crewLoc);
		vo.setCrewNm(crewNm);
		vo.setCrewCont(crewCont);
		
		List<CrewVo> crewList = crewService.crewAdd(vo);
		
		return "redirect:/jiutopia/crewListView.do";
	}
	
	@RequestMapping("/crewDetail.do")
	public String crewDetail(@RequestParam Map<String, String> req, ModelMap model) {
		
		return "jiutopia/crewDetail";
	}
	@RequestMapping("/crewBoardWriteView.do")
	public String crewBoardWriteView(@RequestParam Map<String, String> req, ModelMap model) {
			
		return "jiutopia/crewList";
	}
	@RequestMapping("/crewBoardWrite.do")
	public String crewBoardWrite(@RequestParam Map<String, String> req, ModelMap model) {
			
		return "jiutopia/crewBoardWriteView";
	}
	@RequestMapping("/crewBoardModifyView.do")
	public String crewBoardModeifyView(@RequestParam Map<String, String> req, ModelMap model) {
			
		return "jiutopia/crewBoardModifyView";
	}
	@RequestMapping("/crewBoardModify.do")
	public String crewBoardModeify(@RequestParam Map<String, String> req, ModelMap model) {
		String rtuUrl = "redirect:/jiutopia/crewDetail.do?crewId=" + Utils.toEmptyBlank(req.get("CREWID"));
		
		return rtuUrl;
	}
	@RequestMapping("/crewBoardDelete.do")
	public String crewBoardDelete(@RequestParam Map<String, String> req, ModelMap model) {
			
			return "jiutopia/crewList";
	}
	@RequestMapping("/crewCommentWriteView.do")
	public String crewCommentWriteView(@RequestParam Map<String, String>req, ModelMap model) {
		
		return "jiutopia/crewCommentWrite";
	}
	@RequestMapping("/crewCommentWrite.do")
	public String crewCommentWrite(@RequestParam Map<String, String> req, ModelMap model) {
		
		return "jiutopia/crewDetail";
	}
	@RequestMapping("/crewCommentModifyView.do")
	public String crewCommentModifyView(@RequestParam Map<String, String> req, ModelMap model) {
		
		return "jiutopia/crewCommentModify";
	}
	@RequestMapping("/crewCommentModify.do")
	public String crewCommentModify(@RequestParam Map<String, String>req, ModelMap model) {
		
		return "jiutopia/crewList";
	}
	@RequestMapping("/crewCommentDelete.do")
	public String crewCommentDelete(@RequestParam Map<String, String> req, ModelMap model) {
		
		return "jiutopia/crewList";
	}
	@RequestMapping("/crewBoardList.do")
	public String crewBoardList(@RequestParam Map<String, String> req, ModelMap model) {
		
		return "jiutopia/crewList";
	}
	
}
