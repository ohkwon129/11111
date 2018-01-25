<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>

<%	
	List<Map<String, String>> bookGroupList = (List<Map<String, String>>)request.getAttribute("bookGroupList");

	String bookedId = request.getParameter("bookedId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>북마크 그룹에 추가하기</title>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>
$(function(){
	$('#btnAdd').click(function(){

		$('#frm').submit();
		
		opener.location.href="<%=contextPath%>/jiutopia/mypage.do?memId=<%=id%>";

		$(function(){
			window.close();
		});
	});
	
});

</script>

<style>
	#addIntoGroup {
	 width: 100%;
	 height: 100%;
	 padding: 80px 0;
	 text-align: center;
	 }
	 
	#groupSel {
	 display: inline-block;
	 }
</style>

</head>
<body>

	<div id="addIntoGroup">
		<div id="groupSel">
			<p>북마크 그룹에 추가하기</p>
			<form id="frm" action="<%=contextPath%>/jiutopia/addIntoBookGroup.do" method="post">
				<input type="hidden" name="bookedId" value="<%=bookedId%>">
				<select name="idx">
				<% for (Map<String, String> row: bookGroupList) { %>
					<option value="<%=row.get("idx") %>"><%=row.get("groupNm") %></option>
				<% } %>
				<input type="button" id="btnAdd" name="addIntoBookGroup" value="그룹에 추가" class="button">
			</form>
		</div>
	</div>

</body>

</html>