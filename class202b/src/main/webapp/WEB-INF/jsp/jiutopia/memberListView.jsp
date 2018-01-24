<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ page import="com.ohhoonim.vo.MemberVo" %>
<%@ page import="java.util.List"%>   
<%@ include file = "/WEB-INF/jsp/inc/common.jsp" %>
<%
			
		String dname=(String)request.getAttribute("mem_id");//request.getParameter()
		List<MemberVo> memberlist=(List<MemberVo>)request.getAttribute("memberList");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MemberList</title>
<script src="<%=contextPath%>/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="<%=contextPath%>/css/w3.css">
<script>
$(function(){
	$('#btnSearch').click(function(){
		document.deptForm.submit();
	});
});
</script>
</head>
<div id="wrapper">
		<div id="menu"></div>
		<div id="title"><h1>멤버목록</h1></div>

		<div id="contents">
			<div id="search">
				<form name="memberForm" action="" method="post">
				<label for= "memId">멤버 아이디</label>

					<input type="text" id="memId" name="memId" value="<%=dname%>" >


					<input type="button" value="검색" id="btnSearch">
				</form>
			</div>
			<div id="list">
				<table class="w3-table w3-bordered w3-striped w3-border test">
					<tr class="w3-brown">
						<th class="w3-center">멤버 아이디</th>
						<th class="w3-center">멤버 패스워드</th>
						<th class="w3-center">멤버 이메일</th>
						<th class="w3-center">멤버 순서</th>
						<th class="w3-center">멤버 생일</th>
						<th class="w3-center">멤버 핸드폰번호</th>
						<th class="w3-center">멤버 성별</th>
						<th class="w3-center">체육관 아이디</th>
						<th class="w3-center">동호회 아이디</th>
						<th class="w3-center">게시판 관리자 아이디</th>
					</tr>
					
	<%
	for(MemberVo row : memberlist){
		%>
		<tr>
		<td><%=row.getMemId()%></td>
		<td><%=row.getMemPw()%></td>
		<td><%=row.getMemEmail()%></td>
		<td><%=row.getMemNm()%></td>
		<td><%=row.getMemBirthday()%></td>
		<td><%=row.getMemPhone()%></td>
		<td><%=row.getMemGender()%></td>
		<td><%=row.getGymId()%></td>
		<td><%=row.getCrewId()%></td>
		<td><%=row.getBoardAdminId()%></td>
		</tr>
		<%
	}
	%>

				</table>
			</div>
		</div>
		<div id="footer"></div>
	</div>

	
</body>
</html>