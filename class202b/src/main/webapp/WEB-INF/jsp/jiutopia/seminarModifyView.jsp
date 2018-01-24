<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.ohhoonim.common.util.Utils" %>
<%@ page import="com.ohhoonim.vo.EventVo" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<%
 Map<String, Object> event = (Map<String, Object>)request.getAttribute("eventId");

%>
<!DOCTYPE >
<html>
<head>
<meta charset="utf-8">
<title>세미나 상세 정보 수정</title>

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
#seminarDetail {
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
#seminarImg{
width : 39%;
float : left;
margin-right:1%; 

}
.seminarImg{
width : 100%;
float : left;

}
#seminarIntro{
width:60%;
float :left;

}
#seminarReviewArea{
clear:both;
}
#btn{
float : right;
}

</style>
<script>
$(function(){
	$('#modify').click(function(){
		document.frm.submit();
	});
	$('#cancel').click(function(){
		location.href="<%=contextPath%>/jiutopia/seminarListView.do";
	});
	
});
</script>
</head>
<body>
<div id = "toptab">
	<div id="search">
		<a href=""><img src="<%=contextPath %>/img/search.png" width="28" alt="검색" /></a>
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
	<header id="topMain">

		<a class="homeName">
		
		<h1><a href="<%=contextPath%>/jiutopia/main.do"><font color="white">주토피아</font></a></h1></a>

	</header>
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
          <a class="dropdown-item" href="<%=contextPath%>/jiutopia/seminarListView.do"><b>세미나정보</b></a>
        </div>
        </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        

    </ul>


  </div>
</nav>
</div>
<div id = "wrapper">
	<div id = "menuNavigator">
		<ul>
			<li><a href="<%=contextPath %>/jiutopia/championshipListView.do">대회 목록</a></li><br/>
			<li><a href="<%=contextPath %>/jiutopia/seminarListView.do">세미나 목록</a></li><br/>
		</ul>
	</div>
	<div id = "seminarDetail">
		<div id = "contentsNav">
			<div id = "category">
				<span><p>위치/분류</p></span>
				<h4 id = "seminarNameArea">제목 들어오는 영역</h4>
					<div id = "btn">
				<input type = "button" id="modify" value="수정 완료">
				<input type = "button" id="cancel" value="취소">

 			</div>
				
 			</div>
		</div>
		<div class = "gubun">
			<hr />
		</div>
		<div id = "seminarIntroMain">
			<div id = "seminarImg">
				<img src="<%=contextPath%>http://placehold.it/500x300" alt = "gg" class ="seminarImg">
			</div>
			<div id="seminarIntro">
			<form action="<%=contextPath%>/jiutopia/seminarModify.do" method="post" name="frm">
				<input type="hidden" name="eventId" value="<%=event.get("eventId")%>">
				이름	  : <input type="text" name="eventTitle" value="<%=event.get("eventTitle")%>"><br />  
				장소 	  : <input type="text" name="eventLoc" value="<%=event.get("eventLoc")%>"><br />  
				강사	  : <input type="text" name="eventTeacher" value="<%=event.get("eventTeacher")%>"><br />
				시작 날짜 : <input type="text" name="eventStart" value="<%=event.get("eventStart")%>"><br>
				소개 	  : <textarea rows="8" cols ="50" id ="eventCont" name = "eventCont" ></textarea><br>
			</form>
			
			</div>
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