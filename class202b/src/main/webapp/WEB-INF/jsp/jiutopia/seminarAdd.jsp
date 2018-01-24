<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.ohhoonim.vo.EventVo" %>
<%@ page import="java.util.List"%>   
<%@ include file = "/WEB-INF/jsp/inc/common.jsp" %>
<%	
	String searchName = (String)request.getAttribute("searchName");
	String eventId = (String)request.getAttribute("eventId");
	List<EventVo> seminarList =(List<EventVo>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>세미나 목록</title>
<link rel="StyleSheet" type="text/css" href="/class202b/css/main2_header.css">
<link rel="stylesheet" href="<%=contextPath %>/css/w3.css">
<link rel="stylesheet" href="<%=contextPath %>/css/common.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>

<script>
$(function(){
	$('#buttonSeminarAdd').click(function(){
		document.frm.submit();
	});
	$('#buttonSeminarCancel').click(function(){
		location.href="<%=contextPath%>/jiutopia/seminarListView.do";
	});
	
});
</script>

<style>
#wrapper{
	padding-top: 15px;
	padding-right: 10px;
	padding-bottom: 0px;
	padding-left: 0px;
}

#myNavigator {
	width: 15%;
	float: left;
}
#events {
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
#searchTool {
	float: left;
	margin-left: 30%;
}
#gubun{
	clear : both;
	margin : 5px;
}
.eventList{
width: 50%;
padding-top: 10px;
padding-right: 10px;
padding-bottom: 10px;
padding-left: 10px;
float: left;
border-width: 1px;
border-top-style: none;
border-right-style: none;
border-bottom-style: solid;
border-left-style: none;
border-color: gray;
margin-bottom : 10px;
}
#eventImg{
float : left;
margin-rigth : 1%;
padding-right: 1%;
}
.eventDetail{
list-style:none;
}
.eventChoice{
list-style : none;
}
</style>
</head>
<body>
<div id = "topTab">

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
	<a class="homeName"><h1><a href="<%=contextPath%>/jiutopia/main.do"><font color="white">주토피아</font></a></h1></a>
</header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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
</div>
<div id = "wrapper">
	<div id = "myNavigator">
		<ul class = "eventChoice">
			<li><a href="<%=contextPath %>/jiutopia/championshipListView.do">대회목록</a></li><br>
			<li><b><a href="<%=contextPath %>/jiutopia/seminarListView.do">세미나목록</a></b></li><br>
		</ul>
	</div>

	<div id = "events">
		<div id = "eventAddArea">
			<div id = "eventImg">
				<form name="multiform" id="multiform" action="<%=contextPath%>/common/imageFileUpload.do"  
				method="post"  enctype="multipart/form-data"> 
					<div class ="eventImg">
						<img src="" id="previewImage"  alt="미리보기" style="width:254px; margin:3px;">	
					</div>
					
					<input type="file" name="file" />
					<div id="afile3-list" style="border:2px solid #c9c9c9;min-height:50px;"></div>
					<input type="submit" id="btnSubmit" value="전송"/>
				</form>
			</div>
			<div id="eventInfo">
				<form id = "eventInfoFrm" action="<%=contextPath%>/jiutopia/seminarAdd.do" method="get" name="frm">
					세미나 명 : <input type ="text" value="" id ="eventTitle" name = "eventTitle"><br />
					강사 명: <input type ="text" value="" id ="eventTeacher" name = "eventTeacher"><br />  
					시 작 일 : <input type ="text" value="" id ="eventStart" name = "eventStart"><br />
					참가 인원 : <input type ="text" value="" id ="eventAttend" name = "eventAttend"><br />
					장 소 : <input type ="text" value="" id ="eventLoc" name = "eventLoc"><br>
					소 개 : <textarea rows="8" cols ="50" value=" "id ="eventCont" name = "eventCont" ></textarea><br>
					<input type="hidden" name="fileId" value="" id="fileId">
					<input type="hidden" name="eventId" value="<%=eventId%>" id="eventId">
				</form>
			</div>
			</div>
			<div id = "buttons">
			<br/>
			<input type = "button" id="buttonSeminarAdd"  value="추가">
			<input type = "button" id="buttonSeminarCancel" value="취소">
		</div>	

<br>

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

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
<script src="<%=contextPath %>/js/upload/jquery.form.min.js"></script>
<script src="<%=contextPath %>/js/upload/jQuery.MultiFile.min.js"></script>
<script>
$(function(){
	//use jQuery MultiFile Plugin 
    $('#multiform input[name=file]').MultiFile({
        max: 1, //업로드 최대 파일 갯수 (지정하지 않으면 무한대)
        accept: 'jpg|png|gif', //허용할 확장자(지정하지 않으면 모든 확장자 허용)
        maxfile: 1024, //각 파일 최대 업로드 크기
        maxsize: 3024,  //전체 파일 최대 업로드 크기
        STRING: { //Multi-lingual support : 메시지 수정 가능
            remove : "제거", //추가한 파일 제거 문구, 이미태그를 사용하면 이미지사용가능
            duplicate : "$file 은 이미 선택된 파일입니다.", 
            denied : "$ext 는(은) 업로드 할수 없는 파일확장자입니다.",
            selected:'$file 을 선택했습니다.', 
            toomuch: "업로드할 수 있는 최대크기를 초과하였습니다.($size)", 
            toomany: "업로드할 수 있는 최대 갯수는 $max개 입니다.",
            toobig: "$file 은 크기가 매우 큽니다. (max $size)"
        },
        list:"#afile3-list" //파일목록을 출력할 요소 지정가능
    });
    
	//폼전송 : 해당폼의 submit 이벤트가 발생했을경우 실행  
    $('#multiform').ajaxForm({
       cache: false,
       dataType:"json",
       //보내기전 validation check가 필요할경우
       beforeSubmit: function (data, frm, opt) {
           //console.log(data);
           return true;
       },
 	   success: function(data, statusText){
    	    
        	alert("전송성공!!");
       	 	//console.log(data); //응답받은 데이터 콘솔로 출력         
        	$('#previewImage').attr('src', data.file.fileLink);
       	 	$('#fileId').val(data.file.fileId);
        	//output(data); //받은 정보를 화면 출력하는 함수 호출
    	},
    	//ajax error
    	error: function(e){
        	alert("에러발생!!");
        	console.log(e);
    	}         
    });
});
//전달받은 정보를 가지고 화면에 보기 좋게 출력
function output(data) {
	/*
    //업로드한 파일을 다운로드할수있도록 화면 구성
   
    if(data.file && data.file.length != 0){
    	$('#ig').remove();
    	$('#fi').remove();
            //var link = "fileDownload2?f="+item.fileName+"&of="+item.uploadedFileName;
        $("#image").append("<img id = 'ig' style='width:250px;height:250px' src='" + data.file.link + "'>");
    } 
    $("#file").append("<input type='hidden' id='fi' name='fileN' value='"+data.file.fileN+"'>");
    $("#file").append("<input type='hidden' id='fi' name='fileU' value='"+data.file.fileU+"'>");
    $("#file").append("<input type='hidden' id='fi' name='fileS' value='"+data.file.fileS+"'>");
    $("#file").append("<input type='hidden' id='fi' name='cType' value='"+data.file.cType+"'>");
    $("#file").append("<input type='hidden' id='fi' name='link' value='"+data.file.link+"'>");
    
    $('#image')[0].reset(); //폼 초기화(리셋);
    //$('#multiform').resetForm(); //(jQuery.Form 플러그인 메서드)
    //$('#multiform').clearForm(); //(jQuery.Form 플러그인 메서드)  
    $('#image input:file').MultiFile('reset'); //멀티파일 초기화  
    */
}
</script>
</body>
</html>