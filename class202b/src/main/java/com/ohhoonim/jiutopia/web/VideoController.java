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
import com.ohhoonim.common.util.Paging;
import com.ohhoonim.jiutopia.service.EVCmmtService;
import com.ohhoonim.jiutopia.service.VideoService;
import com.ohhoonim.vo.EVCmmtVo;
import com.ohhoonim.vo.VideoVo;

@Controller
@RequestMapping("/jiutopia")
public class VideoController {
	
	@Resource(name="videoService")
	VideoService videoService;
	
	@Resource(name="evcmmtService")
	EVCmmtService evcmmtService;
	
	@Resource(name="idGenService")
	IdGenService idGenService;
	
	/*비디오 리스트*/
	@RequestMapping("/videoListView.do")
	public String videoListView(@RequestParam Map<String, String> req, ModelMap model) {
		
		String searchName = req.get("searchName") == null ? "": req.get("searchName");
		// videoType = SPT(스포츠), DEF(호신술), ""(전체)
		String videoType = req.get("videoType") == null ? "" : req.get("videoType");
		String pageNo = req.get("pageNo") == null ? "1" : req.get("pageNo");
		String pageSize = req.get("pageSize") == null ? "4" : req.get("pageSize");

		VideoVo vo = new VideoVo();
		vo.setVideoType(searchName);
		vo.setVideoTitle(videoType);
		vo.setPageNo(Integer.parseInt(pageNo));
		vo.setPageSize(Integer.parseInt(pageSize));
		Map<String, Object> videoListMap = videoService.videoListView(vo);
		
		model.addAttribute("videoList", videoListMap.get("list"));
		model.addAttribute("searchName", searchName);
		model.addAttribute("videoType", videoType);
		
		Paging paging = new Paging();
		paging.setPageNo(Integer.parseInt(pageNo));
		paging.setPageSize(Integer.parseInt(pageSize));
		paging.setTotalCount((int)videoListMap.get("listCount"));
		model.addAttribute("paging", paging);
		
		return "jiutopia/videoListView";
	}
	
	
	/*비디오 상세 페이지*/
	@RequestMapping("/videoDetail.do")
	public String videoDetail(@RequestParam Map<String, String> req, ModelMap model) {
		
		String videoId = req.get("videoId") == null ? "": req.get("videoId");
		
		VideoVo vo = new VideoVo();
		vo.setVideoId(videoId);
		Map<String, String> map = videoService.videoDetailView(vo);
		
		EVCmmtVo cmmtVo = new EVCmmtVo();
		cmmtVo.setVideoId(videoId);
		List<EVCmmtVo> videoCmmtList = evcmmtService.videoCmmtList(cmmtVo);
		
		model.addAttribute("videoId", videoId);
		model.addAttribute("videoCmmtList", videoCmmtList);	
		model.addAttribute("videoDetail", map);
		
		return "jiutopia/videoDetail";
	}
	
	/*댓글 추가*/
	@RequestMapping("/cmmtAdd.do")
	public String cmmtAdd(@RequestParam Map<String, String> req, RedirectAttributes reAttr) {
		
		String memId = req.get("memId") == null? "": req.get("memId");
		String videoId = req.get("videoId") == null? "": req.get("videoId");
		String memo = req.get("memo") == null? "": req.get("memo");
		
		EVCmmtVo vo = new EVCmmtVo();
		vo.setMemId(memId);
		vo.setVideoId(videoId);
		vo.setCmmtCont(memo);
		
		evcmmtService.videoCmmtAdd(vo);
		
		return "redirect:/jiutopia/videoDetail.do?videoId=" + videoId;
	}
	
	/*댓글 삭제*/
	@RequestMapping("/cmmtDel.do")
	public String cmmtDel(@RequestParam Map<String, String> req) {
		String cmmtId = req.get("cmmtId") == null? "": req.get("cmmtId");
		String memId = req.get("memId") == null? "": req.get("memId");
		String videoId = req.get("videoId") == null? "": req.get("videoId");
		
		EVCmmtVo vo = new EVCmmtVo();
		vo.setCmmtId(cmmtId);
		vo.setMemId(memId);
		evcmmtService.videoCmmtDel(vo);
		
		return "redirect:/jiutopia/videoDetail.do?videoId=" + videoId;
	}
	
	/*글 삭제*/
	@RequestMapping("/videoDel.do")
	public String videoDel(@RequestParam Map<String, String> req) {
		String videoId = req.get("videoId") == null? "": req.get("videoId");
		
		VideoVo vo = new VideoVo();
		vo.setVideoId(videoId);
		
		videoService.videoDel(vo);
		
		return "redirect:/jiutopia/videoListView.do";
	}
	
//	비디오 등록
	@RequestMapping("/videoPosting.do")
	public String videoPosting(ModelMap model) {
		return "jiutopia/videoPosting";
	}
	@RequestMapping("/videoAdd.do") 
	public String videoAdd(@RequestParam Map<String, String> req,  RedirectAttributes reAttr) {
		
		String rtnUrl = "redirect:/jiutopia/videoPosting.do";
		
		String memId = req.get("memId");
		String videoCtgr = req.get("videoCtgr") == null? "": req.get("videoCtgr");
		String videoTitle = req.get("videoTitle") == null? "": req.get("videoTitle");
		String videoUrl = req.get("videoUrl") == null? "": req.get("videoUrl");
		String videoCont = req.get("videoCont") == null? "": req.get("videoCont");
		
		String videoId = idGenService.getNextId(videoCtgr);
		String videoThumb = idGenService.thumbGen(videoUrl);
		
		videoUrl = idGenService.urlGen(videoUrl);
		
		if (videoTitle.equals("")) {
			req.put("msg", "제목을 입력해주세요");
			reAttr.addFlashAttribute("rtnParams", req);
			return rtnUrl;
		}
		else if (videoUrl.equals("")) {
			req.put("msg", "URL을 입력해주세요");
			reAttr.addFlashAttribute("rtnParams", req);
			return rtnUrl;
		}
		else if (videoCont.equals("")) {
			req.put("msg", "내용을 입력해주세요");
			reAttr.addFlashAttribute("rtnParams", req);
			return rtnUrl;		
		} else {			
			
			VideoVo vo = new VideoVo();
			
			vo.setVideoId(videoId);
			vo.setVideoTitle(videoTitle);
			vo.setVideoCont(videoCont);
			vo.setVideoUrl(videoUrl);
			vo.setVideoThumb(videoThumb);
			vo.setMemId(memId);
			
			videoService.videoAdd(vo);
			
		}
		
		return "redirect:/jiutopia/videoDetail.do?videoId="+videoId;
	}
	
}
