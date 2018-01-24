<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.ohhoonim.vo.MemberVo" %>
<%@ page import="com.ohhoonim.common.util.Utils" %>
<%
	String contextPath = request.getContextPath();

	String id = (String)session.getAttribute("loginId");
	MemberVo memberVo = (MemberVo)session.getAttribute("loginedMember");
	
	boolean isLogined = !Utils.isEmpty(id) ? true: false;
%>
