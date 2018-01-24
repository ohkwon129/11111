package com.ohhoonim.jiutopia.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohhoonim.common.service.IdGenService;
import com.ohhoonim.common.util.Paging;
import com.ohhoonim.jiutopia.service.EVCmmtService;
import com.ohhoonim.jiutopia.service.EventService;
import com.ohhoonim.vo.BoardVo;
import com.ohhoonim.vo.EVCmmtVo;
import com.ohhoonim.vo.EventVo;
import com.ohhoonim.vo.GymVo;

@Controller
@RequestMapping("/jiutopia")
public class EventController {
	
	@Resource(name="eventService")
	EventService eventService;
	@Resource(name="evcmmtService")
	EVCmmtService evcmmtService;
	@Resource(name="idGenService")
	IdGenService idGenService;
	
	private static final Logger LOGGER = Logger.getLogger(EventController.class);
	public final static String KEY_LIST = "list";
	public final static String KEY_LIST_COUNT = "listCount";
	
	@RequestMapping("/seminarListView.do")
	public String seminarList(@RequestParam HashMap<String, String> req, ModelMap model) throws Exception {
		
		String searchName = req.get("searchName") == null? "": req.get("searchName");
		String eventId = req.get("eventTitle")	== null? "" : req.get("eventTitle");
		String pageNo = req.get("pageNo") == null ? "1" : req.get("pageNo");
		String pageSize = req.get("pageSize") == null ? "10" : req.get("pageSize");
		
		EventVo vo = new EventVo();
		vo.setEventTitle(searchName);
		vo.setPageNo(Integer.parseInt(pageNo));
		vo.setPageSize(Integer.parseInt(pageSize));
		
		Map<String, Object> listMap = eventService.seminarList2(vo);
		
		model.addAttribute("searchName", searchName);
		model.addAttribute(EventController.KEY_LIST, listMap.get("list"));
		
//		System.out.println(listMap.get("list"));
				
		//model.addAttribute("seminarList", list);
		model.addAttribute("eventId",eventId);
		
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(pageNo));
		paging.setPageSize(Integer.parseInt(pageSize));
		paging.setTotalCount((int)listMap.get("listCount"));
//		System.out.println(listMap.get("listCount"));
		
		model.addAttribute("paging", paging);
		model.addAttribute("listMap", listMap);
		
		
		return "jiutopia/seminarListView";
	}
	
	@RequestMapping("/seminarDetail.do")
	public String seminarDetail(@RequestParam HashMap<String, String> req, ModelMap model) throws Exception {
		String eventId = req.get("eventId") == null? "" : req.get("eventId");
		//page
		String pageNo = req.get("pageNo") == null ? "1" : req.get("pageNo");
		String pageSize = req.get("pageSize") == null ? "5" : req.get("pageSize");
		
		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		
		EVCmmtVo eVo = new EVCmmtVo();
		eVo.setEventId(eventId);
		eVo.setPageNo(Integer.parseInt(pageNo));
		eVo.setPageSize(Integer.parseInt(pageSize));
		
		Map<String, Object> seminarDetail = eventService.getSeminarDetail(vo);
		Map<String, Object> cmmtListMap = evcmmtService.eventCmmtList(eVo);
				
		model.addAttribute(EventController.KEY_LIST, cmmtListMap.get("list"));
		model.addAttribute("seminarDetail",seminarDetail);
		//model.addAttribute("eventCmmtList",cmmtListMap);
		model.addAttribute("eventId",eventId);	
		
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(pageNo));
		paging.setPageSize(Integer.parseInt(pageSize));
		paging.setTotalCount((int)cmmtListMap.get("listCount"));
		//System.out.println(cmmtListMap.get("listCount"));
		
		model.addAttribute("paging", paging);
		
		
		return "/jiutopia/seminarDetail";
	}
	
	@RequestMapping("/seminarAddView.do")
	public String seminarAddView(@RequestParam HashMap<String, String> req, ModelMap model) {
		String result = idGenService.getNextId("EVENT_SEN");
		model.addAttribute("eventId", result);
		return "jiutopia/seminarAdd";
	}
	
	@RequestMapping("/seminarAdd.do")
	public String seminarAdd(@RequestParam HashMap<String, String>req, RedirectAttributes reAttr) {
		String reUrl = "redirect:/jiutopia/seminarListView.do";

		String eventId = req.get("eventId") == null? "" : req.get("eventId");
		String eventTitle = req.get("eventTitle") == null? "" : req.get("eventTitle");
		String eventTeacher = req.get("eventTeacher") == null? "" : req.get("eventTeacher");
		String eventStart = req.get("eventStart") == null? "" : req.get("eventStart");
		String eventAttend = req.get("eventAttend") == null? "" : req.get("eventAttend");
		String eventLoc = req.get("eventLoc") == null? "" : req.get("eventLoc");
		String eventCont = req.get("eventCont") == null? "" : req.get("eventCont");
		
		
		
		EventVo vo = new EventVo();
		 vo.setEventId(eventId);
		 vo.setEventTitle(eventTitle);
		 vo.setEventTeacher(eventTeacher);
		 vo.setEventStart(eventStart);
		 vo.setEventAttend(eventAttend);
		 vo.setEventLoc(eventLoc);
		 vo.setEventCont(eventCont);
		 vo.setEventEnd("");
		 vo.setDel("");
		 
		int cnt = eventService.seminarAdd(vo);
			
		return reUrl;
	}
			
	@RequestMapping("/seminarCmmtAdd.do")
	public String seminarCmmtAdd(@RequestParam HashMap<String, String> req, ModelMap model) {
		String eventId = req.get("eventId") == null? "" : req.get("eventId");
		String memId = req.get("memId") == null? "" : req.get("memId");
		String cmmtCont = req.get("cmmtCont") == null? "" : req.get("cmmtCont");
	
		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		
		EVCmmtVo eVo = new EVCmmtVo();
		eVo.setEventId(eventId);
		eVo.setMemId(memId);
		eVo.setCmmtCont(cmmtCont);
		
		
		if(cmmtCont.equals("")) {
			String errMsg = req.put("errMsg", "내용이 없습니다. 내용을 확인 해 주세요.");
			model.addAttribute("errMsg", errMsg);
		}
		
		Map<String, Object> cmmtListMap = evcmmtService.eventCmmtList(eVo);
		
		model.addAttribute(EventController.KEY_LIST, cmmtListMap.get("list"));
		int eventCmmtAdd = evcmmtService.eventCmmtAdd(eVo);
		
		
		model.addAttribute("eventCmmtAdd",eventCmmtAdd);
		model.addAttribute("eventId",eventId);		
		
		return "redirect:/jiutopia/seminarDetail.do?eventId="+eventId;
	}
	@RequestMapping("/championshipAddView.do")
	public String championshipAddView(@RequestParam HashMap<String, String> req,ModelMap model) {
		String result = idGenService.getNextId("EVENT_CHP");
		model.addAttribute("eventId", result);
				
		return "jiutopia/championshipAdd";
	}
	@RequestMapping("/championshipAdd.do")
	public String championshipAdd(@RequestParam HashMap<String, String>req) {
		String reUrl = "redirect:/jiutopia/championshipListView.do";
		
		String eventId = req.get("eventId") == null? "" : req.get("eventId");
		String eventTitle = req.get("eventTitle") == null? "" : req.get("eventTitle");
		String eventClass = req.get("eventClass") == null? "" : req.get("eventClass");
		String eventStart = req.get("eventStart") == null? "" : req.get("eventStart");
		String eventEnd = req.get("eventEnd") == null? "" : req.get("eventEnd");
		String eventAttend = req.get("eventAttend") == null? "" : req.get("eventAttend");
		String eventLoc = req.get("eventLoc") == null? "" : req.get("eventLoc");
		String eventCont = req.get("eventCont") == null? "" : req.get("eventCont");
		
		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		vo.setEventTitle(eventTitle);
		vo.setEventClass(eventClass);
		vo.setEventStart(eventStart);
		vo.setEventEnd(eventEnd);
		vo.setEventAttend(eventAttend);
		vo.setEventLoc(eventLoc);
		vo.setEventCont(eventCont);
		vo.setDel("");
		vo.setEventTeacher("");
		
		int cnt = eventService.championshipAdd(vo);
		
		return reUrl;
	}
	
	@RequestMapping("/championshipListView.do")
	public String championshipList(@RequestParam HashMap<String, String> req, ModelMap model) {
		
		String searchName = req.get("searchName") == null? "": req.get("searchName");
		String eventId = req.get("eventTitle") == null? "" : req.get("eventTitle");
		String pageNo = req.get("pageNo") == null ? "1" : req.get("pageNo");
		String pageSize = req.get("pageSize") == null ? "10" : req.get("pageSize");
		
		EventVo vo = new EventVo();
		vo.setEventTitle(searchName);
		vo.setPageNo(Integer.parseInt(pageNo));
		vo.setPageSize(Integer.parseInt(pageSize));
		
		Map<String, Object> listMap = eventService.championshipList(vo);
		
		model.addAttribute(EventController.KEY_LIST, listMap.get("list"));
		model.addAttribute("searchName", searchName);
		//model.addAttribute("championshipList", listMap);
		model.addAttribute("eventId",eventId);
		
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(pageNo));
		paging.setPageSize(Integer.parseInt(pageSize));
		paging.setTotalCount((int)listMap.get("listCount"));
	//	System.out.println(list.get("listCount"));
		
		model.addAttribute("paging", paging);
		model.addAttribute("listMap", listMap);
		
		return "/jiutopia/championshipListView";
	}
	
	@RequestMapping("/championshipDetail.do")
	public String championshipDetail(@RequestParam HashMap<String, String> req, ModelMap model) {
		String eventId = req.get("eventId") == null? "" : req.get("eventId");
		String pageNo = req.get("pageNo") == null ? "1" : req.get("pageNo");
		String pageSize = req.get("pageSize") == null ? "5" : req.get("pageSize");
		
		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		
		EVCmmtVo eVo = new EVCmmtVo();
		eVo.setEventId(eventId);
		eVo.setPageNo(Integer.parseInt(pageNo));
		eVo.setPageSize(Integer.parseInt(pageSize));
		
		Map<String, Object> champDetail = eventService.getChampDetail(vo);
		Map<String, Object> cmmtListMap = evcmmtService.eventCmmtList(eVo);
		
		model.addAttribute(EventController.KEY_LIST, cmmtListMap.get("list"));
		model.addAttribute("champDetail",champDetail);
		model.addAttribute("eventId",eventId);		
		
		
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(pageNo));
		paging.setPageSize(Integer.parseInt(pageSize));
		paging.setTotalCount((int)cmmtListMap.get("listCount"));
		//System.out.println(cmmtListMap.get("listCount"));
		
		model.addAttribute("paging", paging);
		
		
		return "/jiutopia/championshipDetail";
	}
	@RequestMapping("/championshipCmmtAdd.do")
	public String championshipCmmtAdd(@RequestParam HashMap<String, String> req, ModelMap model) {
		String eventId = req.get("eventId") == null? "" : req.get("eventId");
		String memId = req.get("memId") == null? "" : req.get("memId");
		String cmmtCont = req.get("cmmtCont") == null? "" : req.get("cmmtCont");
	
		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		

		EVCmmtVo eVo = new EVCmmtVo();
		eVo.setEventId(eventId);
		eVo.setMemId(memId);
		eVo.setCmmtCont(cmmtCont);
		
		
		if(cmmtCont.equals("")) {
			String errMsg = req.put("errMsg", "내용이 없습니다. 내용을 확인 해 주세요.");
			model.addAttribute("errMsg", errMsg);
		}
		
		Map<String, Object> cmmtListMap = evcmmtService.eventCmmtList(eVo);
		
		model.addAttribute(EventController.KEY_LIST, cmmtListMap.get("list"));
		int eventCmmtAdd = evcmmtService.eventCmmtAdd(eVo);
		
	
		model.addAttribute("eventCmmtAdd",eventCmmtAdd);
		model.addAttribute("eventId",eventId);		
		
		return "redirect:/jiutopia/championshipDetail.do?eventId="+eventId;
	}
	@RequestMapping("/championshipModifyView.do")
	public String championModifyView(@RequestParam Map<String, String> req, ModelMap model) {
		String eventId =req.get("eventId") == null ? "": req.get("eventId");

		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		//Map<String, Object> resultVo = eventService.championshipList(vo);
		//Map<String, Object> detailChp = eventService.championshipModify(vo);
		Map<String, Object> dddchp = eventService.getChampDetail(vo);
		
		model.addAttribute("eventId",dddchp);
		
		return "jiutopia/championshipModifyView";
	}
	
	@RequestMapping("/championshipModify.do")
	public String championshipModify(@RequestParam Map<String, String> req) {
		String eventId 		 = req.get("eventId");
		String eventTitle   = req.get("eventTitle");
		String eventLoc    = req.get("eventLoc");
		String eventClass   = req.get("eventClass");
		String eventStart   = req.get("eventStart");
		String eventEnd    = req.get("eventEnd");
		String eventCont   = req.get("eventCont");

		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		vo.setEventTitle(eventTitle);
		vo.setEventClass(eventClass);
		vo.setEventLoc(eventLoc);
		vo.setEventStart(eventStart);
		vo.setEventEnd(eventEnd);	
		vo.setEventCont(eventCont);
		
		eventService.championshipModify(vo);
		
		return "redirect:/jiutopia/championshipDetail.do?eventId=" + eventId;
	}
	
	@RequestMapping("/seminarModifyView.do")
	public String seminarModifyView(@RequestParam Map<String, String> req, ModelMap model) {
		String eventId =req.get("eventId") == null ? "": req.get("eventId");

		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		
		Map<String, Object> seminar = eventService.getSeminarDetail(vo);
		
		model.addAttribute("eventId",seminar);
		
		return "jiutopia/seminarModifyView";
	}
	
	@RequestMapping("/seminarModify.do")
	public String seminarModify(@RequestParam Map<String, String> req) {
		String eventId 		 = req.get("eventId");
		String eventTitle   = req.get("eventTitle");
		String eventLoc    = req.get("eventLoc");
		String eventTeacher   = req.get("eventTeacher");
		String eventStart   = req.get("eventStart");
		String eventCont   = req.get("eventCont");

		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		vo.setEventTitle(eventTitle);
		vo.setEventTeacher(eventTeacher);
		vo.setEventLoc(eventLoc);
		vo.setEventStart(eventStart);
		vo.setEventCont(eventCont);
		
		eventService.seminarModify(vo);
		
		return "redirect:/jiutopia/seminarDetail.do?eventId=" + eventId;
	}
	
	/*댓글 삭제*/
	@RequestMapping("/seminarCmmtDel.do")
	public String seminarcmmtDel(@RequestParam Map<String, String> req) {
		String memId = req.get("memId") == null? "": req.get("memId");
		String eventId = req.get("eventId") == null? "": req.get("eventId");
		String cmmtId = req.get("cmmtId") == null? "": req.get("cmmtId");
		
		EVCmmtVo vo = new EVCmmtVo();
		vo.setEventId(eventId);
		vo.setCmmtId(cmmtId);
		vo.setMemId(memId);
		evcmmtService.seminarcmmtDel(vo);
		
		return "redirect:/jiutopia/seminarDetail.do?eventId=" + eventId;
	}
	
	/*댓글 삭제*/
	@RequestMapping("/championshipCmmtDel.do")
	public String championshipCmmtDel(@RequestParam Map<String, String> req) {
		String memId = req.get("memId") == null? "": req.get("memId");
		String eventId = req.get("eventId") == null? "": req.get("eventId");
		String cmmtId = req.get("cmmtId") == null? "": req.get("cmmtId");
		
		EVCmmtVo vo = new EVCmmtVo();
		vo.setEventId(eventId);
		vo.setCmmtId(cmmtId);
		vo.setMemId(memId);
		evcmmtService.championshipCmmtDel(vo);
		
		return "redirect:/jiutopia/championshipDetail.do?eventId=" + eventId;
	}
	@RequestMapping("/seminarDelete.do")
	public String seminarDelete(@RequestParam HashMap<String, String> req, ModelMap model ) {
		
		String eventId = req.get("eventId");
	
		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		
		eventService.seminarDelete(vo);
		
		return "redirect:/jiutopia/seminarListView.do";
	}
	@RequestMapping("/championshipDelete.do")
	public String championshipDelete(@RequestParam HashMap<String, String> req, ModelMap model ) {
		
		String eventId = req.get("eventId");
	
		EventVo vo = new EventVo();
		vo.setEventId(eventId);
		
		eventService.championshipDelete(vo);
		
		return "redirect:/jiutopia/championshipListView.do";
	}
	
	@RequestMapping("/calendar.do")
	public String calendar() {
		return "jiutopia/month";
	}
	
	@RequestMapping("/eventScheduleList.do")
	@ResponseBody
	public Object  eventScheduleList (@RequestParam HashMap<String, String> req) {
		/*
		{
			title : 'Click for Google',
			start : new Date(y, m, 28),
			end : new Date(y, m, 29),
			url : 'http://google.com/',
			jobType : 's'
		}
		*/
		String start = req.get("start"); 

		long startDate = Long.parseLong(start + "000");
		Date date = DateUtils.addMonths(new Date(startDate), 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String strDate = sdf.format(date);
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("month", strDate);
		
		List<Map<String, String>> list = eventService.eventScheduleList(param);
		
		return list;
	}
	
	
}









