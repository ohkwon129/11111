<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="com.ohhoonim.vo.VideoVo" %>
<%@ page import="com.ohhoonim.vo.EVCmmtVo" %>

<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<%
	Map<String, String> cmmtDetail = (Map<String, String>)request.getAttribute("cmmtDetail");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>댓글 수정</title>
</head>
<body>
	<div id="cmmtModify">
		<form id="cmmtModifyForm" action="<%=contextPath %>/jiutopia/cmmtModifyView.do">
			<table>
				<tr>
					<th>작성자</th>				
					<th>내용</th>				
				</tr>
				<tr>
					<td><input type="hidden" name="<%=cmmtDetail.get("cmmtId") %>"></td>
					<td><input type="hidden" name="<%=cmmtDetail.get("videoId") %>"></td>
					<td><input type="text" name="memId" value="mem01"></td>
					<td><input type="text" name="<%=cmmtDetail.get("cmmtCont") %>"></td>
					<td><input type="submit" name="btnModify" value="수정"></td>
					<td><input type="button" name="modifyCncl" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>