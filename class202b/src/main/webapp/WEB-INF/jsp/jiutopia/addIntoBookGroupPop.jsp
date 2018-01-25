<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>

<%
	String bookedId = request.getParameter("bookedId");
	if (bookedId == null) {
		bookedId = request.getAttribute("bookedId").toString();
	}

	List<Map<String, String>> bookGroupList = (List<Map<String, String>>) request.getAttribute("bookGroupList");
	Map<String, String> groupName = (Map<String, String>) request.getAttribute("groupName");

	String msg = "";

	if (groupName != null) {
		msg = groupName.get("msg") == null ? "" : groupName.get("msg");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>북마크 그룹에 추가하기</title>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
<script>
// 북마크그룹명 미입력시 알람
$(function(){
	if ('<%=msg%>'.length > 0) {
		alert('<%=msg%>');
	}
});

// 북마크그룹에 즐겨찾기 추가
$(function(){
	$('#btnAdd').click(function(){
		$('#addIntoGroupFrm').submit();
		opener.location.href="<%=contextPath%>/jiutopia/mypage.do?memId=<%=id%>";
		$(function() {
			window.close();
		});
	});
});
</script>

<style>
#addIntoGroup {
	width: 100%;
	height: 100%;
	padding: 50px 0;
	text-align: center;
}

#groupSel {
	display: inline-block;
}
</style>

</head>
<body>

	<div id="addIntoGroup">
		<!-- 기존 북마크 그룹 선택 -->
		<div id="groupSel">
			<p>북마크 그룹에 추가하기</p>
			<form id="addIntoGroupFrm"
				action="<%=contextPath%>/jiutopia/addIntoBookGroup.do" method="post">
				<input type="hidden" name="bookedId" value="<%=bookedId%>">
				<select name="idx">
					<%
						for (Map<String, String> row : bookGroupList) {
					%>
					<option value="<%=row.get("idx")%>"><%=row.get("groupNm")%></option>
					<%
						}
					%>
					<input type="button" id="btnAdd" name="addIntoBookGroup"
						   value="그룹에 추가" class="button">
			</form>
		</div>
		<!-- 북마크 그룹 생성 -->
		<div id="bookGroupAdd">
			<p>북마크 그룹 추가하기</p>
			<form id="bookGroupAddFrm"
				action="<%=contextPath%>/jiutopia/addIntoBookGroupAdd.do"
				method="post">
				<input type="hidden" name="memId" value="<%=id%>" readonly>
				<input type="hidden" name="bookedId" value="<%=bookedId%>">
				<input type="text" name="groupNm" value="" placeholder="추가할 그룹명 입력">
				<input type="button" name="bookGroupAdd" value="그룹생성" class="button"
					   onClick="openPop();">
			</form>
		</div>
	</div>

</body>

<script>
	function openPop() {
		event.preventDefault();
		$('#bookGroupAddFrm').submit();
	}
</script>

</html>