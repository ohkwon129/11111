package com.ohhoonim.vo;

import com.ohhoonim.common.util.Paging;

public class EVCmmtVo extends Paging{
	private String memId;
	private String cmmtId;
	private String cmmtCont;
	private String cmmtWtime;
	private String videoId;
	private String eventId;
	
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	
	public String getCmmtId() {
		return cmmtId;
	}
	public void setCmmtId(String cmmtId) {
		this.cmmtId = cmmtId;
	}
	
	
	public String getCmmtCont() {
		return cmmtCont;
	}
	public void setCmmtCont(String cmmtCont) {
		this.cmmtCont = cmmtCont;
	}
	
	
	public String getCmmtWtime() {
		return cmmtWtime;
	}
	public void setCmmtWtime(String cmmtWtime) {
		this.cmmtWtime = cmmtWtime;
	}
	
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	

}
