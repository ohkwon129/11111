package com.ohhoonim.vo;

import com.ohhoonim.common.util.Paging;

public class EventVo extends Paging{
	private String eventId;
	private String eventTitle;
	private String eventTeacher;
	private String eventClass;
	private String eventStart;
	private String eventEnd;
	private String eventAttend;
	private String eventLoc;
	private String eventCont;
	private String del;
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	
	public String getEventTeacher() {
		return eventTeacher;
	}
	public void setEventTeacher(String eventTeacher) {
		this.eventTeacher = eventTeacher;
	}
	
	public String getEventClass() {
		return eventClass;
	}
	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
	}
	
	public String getEventStart() {
		return eventStart;
	}
	public void setEventStart(String eventStart) {
		this.eventStart = eventStart;
	}
	
	public String getEventEnd() {
		return eventEnd;
	}
	public void setEventEnd(String eventEnd) {
		this.eventEnd = eventEnd;
	}
	
	public String getEventAttend() {
		return eventAttend;
	}
	public void setEventAttend(String eventAttend) {
		this.eventAttend = eventAttend;
	}
	
	public String getEventLoc() {
		return eventLoc;
	}
	public void setEventLoc(String eventLoc) {
		this.eventLoc = eventLoc;
	}
	
	public String getEventCont() {
		return eventCont;
	}
	public void setEventCont(String eventCont) {
		this.eventCont = eventCont;
	}
	
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	
}
