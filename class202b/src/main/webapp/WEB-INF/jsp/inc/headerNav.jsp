<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getParameter("contextPath");
	boolean isLogined = Boolean.parseBoolean(request.getParameter("isLogined"));
	String id = request.getParameter("id");
%>

	<!-- 제목 -->
	<header id="topMain">
		<div id="homeName">
			<a href="<%=contextPath%>/jiutopia/main.do"> 
				<font color="white" size="6">주토피아</font>
			</a>
		</div>
		
		<div id="search">
			<a href=""><img src="<%=contextPath%>/img/search.png" width="28"alt="검색" /></a>
		</div>
		
		<div id="myPage">
			<%
				if (!isLogined) {
			%>
					<a href="<%=contextPath%>/jiutopia/loginView.do">로그인</a>
			<%
				} else {
			%>
					<a href="<%=contextPath%>/jiutopia/mypage.do?memId=<%=id%>">마이페이지</a>
					<a href="<%=contextPath%>/jiutopia/logout.do">로그아웃</a>
			<%
				}
			%>
		</div>
	</header>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto mr-auto">
				<li class="nav-item dropdown"><a class="nav-link"
					href="<%=contextPath%>/jiutopia/videoListView.do"
					id="navbarDropdown"> 주짓수 배우기 </a>
				</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 주짓수 소식 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=contextPath%>/jiutopia/championshipListView.do">대회 정보</a> 
						<a class="dropdown-item" href="<%=contextPath%>/jiutopia/seminarListView.do">세미나정보</a>
						<a class="dropdown-item" href="<%=contextPath%>/jiutopia/calendar.do">일정보기</a>
					</div>
				</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</ul>
		</div>
	</nav>