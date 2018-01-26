package com.ohhoonim.vo;

public class VideoVo {
	private String videoId;
	private String videoTitle;
	private String videoCont;
	private String videoUrl;
	private String videoWtime;
	private String videoThumb;
	private String videoType;
	private String del;
	private String memId;
	private int pageSize;
	private int pageNo;
	
	
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	
	
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	
	
	public String getVideoCont() {
		return videoCont;
	}
	public void setVideoCont(String videoCont) {
		this.videoCont = videoCont;
	}
	
	
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	
	public String getVideoWtime() {
		return videoWtime;
	}
	public void setVideoWtime(String videoWtime) {
		this.videoWtime = videoWtime;
	}
	
	
	public String getVideoThumb() {
		return videoThumb;
	}
	public void setVideoThumb(String videoThumb) {
		this.videoThumb = videoThumb;
	}
	
	
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
