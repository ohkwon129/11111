package com.ohhoonim.jiutopia.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ohhoonim.jiutopia.service.GymService;
import com.ohhoonim.vo.GymVo;

@Controller
@RequestMapping("/jiutopia")
public class GymController {
	
	@Resource(name="gymService")
	GymService gymService;
	
	@RequestMapping("/gymListView.do")
	public String gymListView(@RequestParam Map<String, String> req, ModelMap model) {
		
		String searchName = req.get("searchName") == null ? "": req.get("searchName");
		
		GymVo vo = new GymVo();
		vo.setGymNm(searchName);
		
		List<GymVo> gymList = (List<GymVo>) gymService.gymListView(vo);
		
		model.addAttribute("gymList", gymList);
		model.addAttribute("searchName", searchName);
		
	
		return "jiutopia/gymListView";
	}
	@RequestMapping("/gymAddView.do")
	public String gymAddView(ModelMap model) {
		GymVo vo = new GymVo();
		List<GymVo> gymlist = gymService.gymListView(vo);
		model.addAttribute("gymList",gymlist);
		
		return "jiutopia/gymAdd";
	}
	@RequestMapping("/gymAdd.do")
	public String gymAdd(@RequestParam Map<String, String> req) {
		String gymId = req.get("gymId") == null? "" : req.get("gymId");
		String gymNm = req.get("gymNm") == null? "" : req.get("gymNm");
		String gymAdd = req.get("gymAdd") == null? "" : req.get("gymAdd");
		String gymOwner = req.get("gymOwner") == null? "" : req.get("gymOwner");
		String gymTel = req.get("gymTel") == null? "" : req.get("gymTel");
		String gymType = req.get("gymType") == null? "" : req.get("gymType");
		String gymCont = req.get("gymCont") == null? "" : req.get("gymCont");
		String gymCnt = req.get("gymCnt") == null? "" : req.get("gymCnt");
		
		GymVo vo = new GymVo();
		vo.setGymId(gymId);
		vo.setGymNm(gymNm);
		vo.setGymAdd(gymAdd);
		vo.setGymOwner(gymOwner);
		vo.setGymTel(gymTel);
		vo.setGymType(gymType);
		vo.setGymCont(gymCont);
		vo.setGymCnt(gymCnt);

		int cnt = gymService.gymAdd(vo);
		
		return "redirect:/jiutopia/gymListView.do";
	}
	
	@RequestMapping("/gymDetail.do")
	public String gymDetailView(@RequestParam Map<String, String> req, ModelMap model) {
		
		String gymId= req.get("gymId") == null ? "" : req.get("gymId");
		
		GymVo vo = new GymVo();
		vo.setGymId(gymId);
		GymVo resultVo = gymService.getGymById(vo);
		
		model.addAttribute("gym",resultVo);
		model.addAttribute("gId",gymId);
		
		return "jiutopia/gymDetail";
	}
	@RequestMapping("/gymModifyView.do")
	public String gymModifyVIew(@RequestParam Map<String, String> req, ModelMap model) {
		String gymId =req.get("gymId") == null ? "": req.get("gymId");

		GymVo vo = new GymVo();
		vo.setGymId(gymId);
		GymVo resultVo = gymService.getGymById(vo);
		
		model.addAttribute("gym",resultVo);
		
		return "jiutopia/gymModifyView";
	}
	
	@RequestMapping("/gymModify.do")
	public String gymModify(@RequestParam Map<String, String> req) {
		String gymId      = req.get("gymId");
		String gymNm      = req.get("gymNm");
		String gymAdd     = req.get("gymAdd");
		String gymOwner   = req.get("gymOwner");
		String gymTel     = req.get("gymTel");
		String gymType    = req.get("gymType");
		String gymCont    = req.get("gymCont");
		String gymCnt     = req.get("gymCnt");

		GymVo vo = new GymVo();
		vo.setGymId(gymId);
		vo.setGymNm(gymNm);
		vo.setGymAdd(gymAdd);
		vo.setGymOwner(gymOwner);
		vo.setGymTel(gymTel);
		vo.setGymType(gymType);
		
		vo.setGymCont(gymCont);
		vo.setGymCnt(gymCnt);
		
		gymService.gymModify(vo);
		
		return "redirect:/jiutopia/gymDetail.do?gymId=" + gymId;
	}
	@RequestMapping("/gymRemove.do")
	public String gymRemove(@RequestParam Map<String, String> req) {
		
		String Id = req.get("gymId");
		GymVo vo = new GymVo();
		vo.setGymId(Id);
		
		int resultCnt = gymService.gymRemove(vo);
		
		return "redirect:/jiutopia/gymListView.do";
	}
	@RequestMapping("/gymReview.do")
	public String gymReview() {
		return "jiutopia/gymReview";
	} 
	@RequestMapping("/gymReviewDetail.do")
	public String gymReviewView(@RequestParam Map<String, String> req,ModelMap model) {
		String gymReviewId= req.get("gymId") == null ? "" : req.get("gymId");
	
		GymVo vo = new GymVo();
		vo.setGymId(gymReviewId);
		GymVo resultVo = gymService.getGymById(vo);
		
		model.addAttribute("gym",resultVo);
		model.addAttribute("gId",gymReviewId);
		
		return "jiutopia/gymReviewDetail";
	}
}
