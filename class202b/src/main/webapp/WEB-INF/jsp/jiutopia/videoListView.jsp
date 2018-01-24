<%@ page contentType="text/html; charset=utf-8"%>

<%@ include file = "/WEB-INF/jsp/inc/common.jsp" %>

<%@ page import="com.ohhoonim.vo.VideoVo"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%
	String searchName = (String)request.getAttribute("searchName");
	String videoType = (String)request.getAttribute("videoType");
	List<VideoVo> videoList = (List<VideoVo>)request.getAttribute("videoList");
	String selectedMenu = " class=\"w3-btn w3-aqua w3-round-large\" ";
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>VIDEO LIST</title>
<link rel="stylesheet" href="/class202b/css/common.css">
<link rel="stylesheet" href="/class202b/css/w3.css">
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

#myNavigator{
	width: 15%;
	float: left;
}
#movieList {
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
#searchForm {
	float left;
	margin-left: 30%;
}
#gubun{
	clear : both;
	margin : 5px, 0px, 0px, 0px;
}
.movieListArea{
width: 50%;
padding-top: 10px;
padding-right: 10px;
padding-bottom: 10px;
padding-left: 10px;
float: left;
}
ul{
list-style:none;
}

</style>


</head>
<body>

	<div id="search">
		<a href=""><img src="<%=contextPath%>/img/search.png" width="28" alt="검색" /></a>
	</div>
	
	<!-- 	마이 페이지 -->
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
	
	<!-- 홈페이지 간판 -->
	<header id="topMain">
		<a class="homeName" href="<%=contextPath%>/jiutopia/main.do"> <font color="white" size="5"><h1>주토피아<h1></h1></font></a>
	</header>
	
<!-- 좌측 네이게이터 -->	
<nav class="navbar navbar-expand-lg navbar-light bg-light">
 	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
	
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link" href="<%=contextPath %>/jiutopia/videoListView.do" id="navbarDropdown">
          주짓수 배우기
        </a>
       
       </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
        <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          주짓수 소식
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="<%=contextPath%>/jiutopia/championshipListView.do">대회 정보</a>
          <a class="dropdown-item" href="<%=contextPath%>/jiutopia/seminarListView.do">세미나정보</a>
        </div>
        </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </ul>
  </div>
</nav>

<!-- 메뉴 네이게이터 -->
<div id = "wrapper">
	<div id = "myNavigator">
		<ul class = "eventChoice">
			<li><a href="<%=contextPath %>/jiutopia/videoListView.do?videoType=DEF" <%=videoType.equals("DEF") ? selectedMenu: "" %>>호신술 영상</a></li><br/>
			<li><b><a href="<%=contextPath %>/jiutopia/videoListView.do?videoType=SPT" <%=videoType.equals("SPT") ? selectedMenu: "" %>>스포츠 영상</a></b></li><br/>
		</ul>
	</div>
	<!-- 배우기 영상 목록 -->
	<div id="movieList">
		<!-- 검색(3글자 이상) -->
		
		<div id = "searchTool">
			<form name="searchForm" action="<%=contextPath %>/jiutopia/videoListView.do" method="get" id="searchForm">
				<select id="searchBox" name="searchBox">
					<option value="title">제목</option>
				</select> 
				<input type="text" name="searchName" id="searchName" value="<%=searchName %>">
				<input type="hidden" name="videoType" id="videoType" value="<%=videoType %>">
				<input type="hidden" name="pageNo" value="${paging.pageNo}">
				<input type="submit"  class="w3-btn w3-brown w3-round-xxlarge" value="검색">
			</form>
		</div>
		
		<% for(VideoVo row: videoList) { %>
		<div id = "article">
			<!-- 영상 -->
			<div class = "movieListArea">
				<a href="<%=contextPath%>/jiutopia/videoDetail.do?videoId=<%=row.getVideoId()%>"><img src="<%=row.getVideoThumb()%>" alt ="moives" class = "movieLink"/></a>
				<span class = "moviesName"><p><%=row.getVideoTitle() %></p></span>
			</div>
		</div>
		<% } %>
	</div>
	<div style="clear:both;"></div>
		<div class="pagingArea">	 
				<center>
			 <jsp:include page="/WEB-INF/jsp/inc/paging.jsp">
				<jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
				<jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
				<jsp:param name="startPageNo" value="${paging.startPageNo}" />
				<jsp:param name="pageNo" value="${paging.pageNo}" />
				<jsp:param name="endPageNo" value="${paging.endPageNo}" />
				<jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
				<jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
		
			</jsp:include>		
			</center>		
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
<script type="text/javascript">
	function goPage(pageNo) {
		document.searchForm.pageNo.value = pageNo;
		document.searchForm.submit();
	}
</script>
</body>
</html>