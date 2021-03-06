<%@ page contentType="text/html; charset=utf-8"%>

<%@ page import="com.ohhoonim.vo.GymVo"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>

<%
	String searchName = (String)request.getAttribute("searchName");
	
	List<GymVo> gymList = (List<GymVo>)request.getAttribute("gymList");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>체육관 목록</title>
<link rel="StyleSheet" type="text/css" href="/class202b/css/main2_header.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<style>
#wrapper{
	padding-top: 15px;
	padding-right: 10px;
	padding-bottom: 0px;
	padding-left: 0px;
}

#menuNavigator{
	width: 15%;
	float: left;
}
#gymList {
	width: 85%;
	float: left;
	border-width: 1px;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: solid;
	border-color: gray;
	padding-top: 0px;
	padding-right: 0px;
	padding-bottom: 0px;
	padding-left: 15px;
}
.gymListArea{
width: 50%;
padding-top: 10px;
padding-right: 10px;
padding-bottom: 10px;
padding-left: 10px;
float: left;
text-align:center;
}
.gymLink{
width:90%;
}
#reviewAdd{
float:right;
}
#gymAdd{
float:right;
}
</style>
<script>
$(function(){
	$('#gymAdd').click(function(){
		location.href='<%=contextPath%>/jiutopia/gymAddView.do';
		});

});

</script>

</head>
<body>
<div id="search">
	<a href=""><img src="<%=contextPath %>/img/search.png" width="28" alt="검색" /></a>
</div>
<div id="myPage">
	<a href=""><img src="<%=contextPath %>/img/mypage.png" width="28" alt="My" /></a>
</div>
<header id="topMain">
	<a class="homeName"><font color="white"><h1>주토피아</h1></font></a>
</header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto mr-auto">
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 주짓수 정보 </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">유래</a> 
					<a class="dropdown-item" href="#">띠</a> 
					<a class="dropdown-item" href="#">체급</a>
				</div>
			</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 주짓수 소식 </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="month1.html">대회/세미나 정보</a>
				</div>
			</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 커뮤니티 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=contextPath %>/jiutopia/videoListView.do">주짓수 배우기</a> 
						<a class="dropdown-item" href="<%=contextPath %>/jiutopia/gymListView.do">체육관 정보</a> 
						<a class="dropdown-item" href="<%=contextPath %>/jiutopia/crewListView.do">동호회 정보</a>
					</div>
			</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</ul>
	</div>
</nav>
<!-- 공통 부분 끝 -->
<div id = "wrapper">
	<div id = "menuNavigator">
		<ul>
			<li><a href="<%=contextPath %>/jiutopia/defListView.do">주짓수 배우기</a></li>
			<li><b><a href="<%=contextPath %>/jiutopia/gymListView.do">체육관 목록</a></b></li>
			<li><a href="<%=contextPath %>/jiutopia/crewListView.do">동호회 목록</a></li>
		</ul>
	</div>
	<div id="gymList">
		<div id = "categoryName">
			<h2><span id = "gym">체육관 목록</span></h2>
		</div>
		<div id = "searchTool">
			<form name="searchForm" action="<%=contextPath%>/jiutopia/gymReview.do" method="get" id="searchForm">
				<input type="text" name="searchName" id="searchName">
				<input type="submit" id="buttonSearch" value="이름검색"/>
				<span id = "adminArea">
				<input type="button" id="gymAdd"  value ="체육관 추가"/>
					
				</span>
			</form>
		</div>
		<div id = "article">
			<%for (GymVo row: gymList) { %>
			<div class = "gymListArea">
				<a href="<%=contextPath%>/jiutopia/gymDetail.do?gymId=<%=row.getGymId()%>"><img src="http://localhost:8080/class202b/img/ju_EX/c_0.jpg" alt ="gymMark" class = "gymLink"/></a>
				<span class = "gymName"><p><%=row.getGymNm()%></p></span>
			</div>
			<% } %>
		</div>
		
	</div>
</div>
<div class="top">
	<input type="button" value="TOP" onclick="window.scrollTo(0,0);">
</div>
<div id = "gubun">
	<hr />
</div>
<footer> 
	<p><b>“ 주짓수는 작고 약한 사람이 자신을 보호할 수 있는 유일한 호신술이다. ” 엘리오 그레이시(1913 – 2009)</b></p>
</footer>
</body>
</html>