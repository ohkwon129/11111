<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ohhoonim.vo.*"%>
<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Title Name</title>
<script src="<%=contextPath%>/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="<%=contextPath%>/css/w3.css">
<link rel="stylesheet" href="<%=contextPath%>/css/common.css">
</head>
<body>
	<div id="wrapper">
		<div id="menu">
		</div>
		<div id="title">
			<h1>제목 영역</h1>
		</div>
		<div id="contents">
			<div id="search">
				<form name="" action="" method="">
					<label for="">이름 이렇게 하면 좋다고 하던데 label은 필수가 아니지만.</label> 
					<input type="" id="" name="" value=""> 
					<input type="" id="" value="">
				</form>
			</div>
			<div id="list">
				<table class="w3-table w3-bordered w3-striped w3-border test">
					<tr class="w3-brown">
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</table>
			</div>
		</div>
		<div id=footer></div>
	</div>
</body>
</html>