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
<script type="text/javascript" src="/class202b/js/service/HuskyEZCreator.js" charset="utf-8"></script>
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
#buttonAdd{
float:right;
}
.reviewTitle{
width:30%;
}
</style>

</head>
<body>
<div id="search">
	<a href=""><img src="img/search.png" width="28" alt="검색" /></a>
</div>
<div id="myPage">
	<a href=""><img src="img/mypage.png" width="28" alt="My" /></a>
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
					<a class="dropdown-item" href="month1.html">대회/세니마 정보</a>
				</div>
			</li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 커뮤니티 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="Movie.html">주짓수 배우기</a> 
						<a class="dropdown-item" href="Gym.html">체육관 정보</a> 
						<a class="dropdown-item" href="Club.html">동호회 정보</a>
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
		<p class = "category">카테고리</p>
		<h4>제목</h4>
		<input type="text" name="title" value="" placeholder="게시글 제목을 입력하세요" class="reviewTitle">
		<br />
		<br />
		<form action="" method="post">
			<textarea name="ir1" id="ir1" rows="10" cols="100" value ="gg"
				style="width: 766px; height: 412px; display: none;">gggg</textarea>
		</form>
		<script type="text/javascript">
			var oEditors = [];

			var sLang = "ko_KR"; // 언어 (ko_KR/ en_US/ ja_JP/ zh_CN/ zh_TW), default = ko_KR

			// 추가 글꼴 목록
			var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

			nhn.husky.EZCreator.createInIFrame({
				oAppRef : oEditors,
				elPlaceHolder : "ir1",
				sSkinURI : "/class202b/SmartEditor2Skin.html",
				htParams : {
					bUseToolbar : true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseVerticalResizer : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseModeChanger : true, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
					//bSkipXssFilter : true,		// client-side xss filter 무시 여부 (true:사용하지 않음 / 그외:사용)
					aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
					fOnBeforeUnload : function() {
						//alert("완료!");
					},
					I18N_LOCALE : sLang
				}, //boolean
				fOnAppLoad : function() {
					//예제 코드
					//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
				},
				fCreator : "createSEditor2"
			});

			function pasteHTML() {
				var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
				oEditors.getById["ir1"].exec("PASTE_HTML", [ sHTML ]);
			}

			function showHTML() {
				var sHTML = oEditors.getById["ir1"].getIR();
				alert(sHTML);
			}

			function submitContents(elClickedObj) {
				oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됩니다.

				// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.

				try {
					elClickedObj.form.submit();
				} catch (e) {
				}
			}

			function setDefaultFont() {
				var sDefaultFont = '궁서';
				var nFontSize = 24;
				oEditors.getById["ir1"].setDefaultFont(sDefaultFont, nFontSize);
			}
		</script>
		<input type="file" name="profile">
		<div id = "buttonsAdd">
			<input type="submit" value="확인">
			<input type="reset" value="취소">
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