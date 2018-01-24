<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta charset="utf-8">
<title>체육관 상세 정보</title>

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
#gymDetail {
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
#gymImg{
width : 39%;
float : left;
margin-right:1%; 
}
.gymImg{
width : 100%;
float : left;
}
#gymIntro{
width:59%;
float :left;

}
#buttons{
clear:both;

}

</style>
<script>
$(function(){
	$('#buttonGymAdd').click(function(){
		document.frm.submit();
	});
	$('#buttonGymCancel').click(function(){
		location.href="<%=contextPath%>/jiutopia/gymListView.do";
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

		<a class="homeName">
		<font color="white">
		<h1>주토피아</h1></font></a>

	</header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
	
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          주짓수 정보
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">유래</a>
          <a class="dropdown-item" href="#">띠</a>
          <a class="dropdown-item" href="#">체급</a>
        </div>
        </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          주짓수 소식
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="<%=contextPath %>/month1.html">대회/세니마 정보</a>
        </div>
        </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          커뮤니티
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="<%=contextPath %>/Movie.html">주짓수 배우기</a>
          <a class="dropdown-item" href="<%=contextPath %>/Gym.html">체육관 정보</a>
          <a class="dropdown-item" href="<%=contextPath %>/Club.html">동호회 정보</a>
        </div>
      </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     
    </ul>


  </div>
</nav>

<div id = "wrapper">
	<div id = "menuNavigator">
		<ul>
			<li><a href="<%=contextPath %>/jiutopia/defListView.do">주짓수 배우기</a></li>
			<li><a href="<%=contextPath %>/jiutopia/gymListView.do">체육관 정보</a></li>
			<li><a href="<%=contextPath %>/jiutopia/crewListView.do">동호회 게시판</a></li>
		</ul>
	</div>
	<div id = "gymDetail">
		<div id = "contentsNav">
			<div id = "category">
				<form id = "gymHeader">
					<input type = "text" id = "gymAddress" name ="gymAddress" value="" placeholder ="지역"><br>
					<input type = "text" id = "gymNm" name ="gymNm" value="" placeholder ="체육관 이름">
				</form>
			</div>
		</div>
		<div class = "gubun">
			<hr />
		</div>
		<div id = "gymIntroMain">
				<div id = "gymImg">
					<form name="multiform" id="multiform" action="<%=contextPath%>/common/imageFileUpload.do" 
						method="post"  enctype="multipart/form-data"> 
						<div class ="gymImg">
							<img src="" id="previewImage"  alt="미리보기" style="width:254px;">	
						</div>
						<input type="file" name="file" />
						<div id="afile3-list" style="border:2px solid #c9c9c9;min-height:50px;"></div>
						<input type="submit" id="btnSubmit" value="전송"/>
					</form>
				</div>
				<div id="gymIntro">
					<form id = "gymIntroFrm" action="<%=contextPath%>/jiutopia/gymAdd.do" method="get" name="frm">
							체육관 번호 : <input type ="text" value="" id ="gymId" name = "gymId" placeholder ="체육관 번호"><br />
							체육관 이름 : <input type ="text" value="" id ="gymNm" name = "gymNm" placeholder ="체육관 이름"><br />  
							체육관 주소 : <input type ="text" value="" id ="gymAdd" name = "gymAdd" placeholder ="체육관 주소"><br />
							체육관 대표 : <input type ="text" value="" id ="gymOwner" name = "gymOwner" placeholder ="체육관 대표"><br />
							대 표 번 호 : <input type ="text" value=" "id ="gymTel" name = "gymTel" placeholder ="대표번호"><br>
							분		 야 : <input type ="text" value=" "id ="gymType" name = "gymType" placeholder ="분		 야"><br>
							비		 용 : <input type ="text" value="" id ="gymFee" name = "gymFee" placeholder ="비		 용"><br><br>
							소		 개 : <input type ="text" value="" id ="gymData" name = "gymData" placeholder ="체육관 소개"><br><br>
							<input type="hidden" name="fileId" value="" id="fileId">
					</form>
				</div>
		</div>
		<div id = "buttons">
			<br/>
			<input type = "button" id="buttonGymAdd"  value="추가">
			<input type = "button" id="buttonGymCancel" value="취소">
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