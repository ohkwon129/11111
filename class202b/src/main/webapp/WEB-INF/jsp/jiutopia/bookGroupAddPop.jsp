<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>

<%@ page import="java.util.Map" %>

<%
	Map<String, String> groupName = (Map<String, String>)request.getAttribute("groupName");
	
	String msg = "";
	String groupNm = "";

	if (groupName != null) {
		msg = groupName.get("msg") == null? "": groupName.get("msg");
		groupNm = groupName.get("groupNm") == null? "": groupName.get("groupNm");
	}
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>북마크 그룹 생성</title>
	
	<script src="<%=contextPath %>/js/jquery-3.1.1.min.js"></script>
	<script>
		$(function(){
			$('#btnAdd').click(function(){
				$('#frm').submit();
				
				opener.location.href="<%=contextPath%>/jiutopia/mypage.do?memId=<%=id%>";
				
				$(function(){
					if ('<%=msg%>'.length > 0) {
						alert('<%=msg%>');		
					} else if ('<%=msg%>'.length == 0) {
						window.close();
					}
				});
				
			});
		});
	</script>
	
</head>
<body>

<!-- 	북마크 그룹 명 입력 -->
	<div id="bookGroupAdd">
		<p>북마크 그룹 추가하기</p>
		<form id="frm" action="<%=contextPath%>/jiutopia/bookGroupAdd.do" method="post">
			<input type="hidden" name="memId" value="<%=id%>" readonly>
			<input type="text" name="groupNm" value="<%=groupNm %>" placeholder="추가할 그룹명 입력">
			<input type="button" id="btnAdd" value="그룹생성">
		</form>
	</div>
</body>
</html>