<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%
	Map<String, String> rtnParams = (Map<String, String>)request.getAttribute("rtnParams");

	String videoTitle = "";
	String videoUrl = "";
	String videoCont = "";
	String msg = "";	

	if (rtnParams != null) {
		videoTitle = rtnParams.get("videoTitle") == null? "": rtnParams.get("videoTitle");
		videoUrl = rtnParams.get("videoUrl") == null? "": rtnParams.get("videoUrl");
		videoCont = rtnParams.get("videoCont") == null? "": rtnParams.get("videoCont");
	
		msg = rtnParams.get("msg") == null? "": rtnParams.get("msg");
	}
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>비디오 등록</title>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	
	<!-- header -->
	<link rel="StyleSheet" type="text/css"
		href="/class202b/css/main2_header.css">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
		integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
		crossorigin="anonymous">
	
	<style>
		fieldset {
			margin-bottom: 20px;
		}
		
		legend {
			padding: 10px 10px;
			width: 300px;
			background-color: gray;
		}
		
		* {
			margin: 0;
			padding: 0;
			box-sizing: border-box;
		}
		
		/* 	    버튼 */
		.button {
			padding: 5px;
		}
		
		/* 		타이틀 메인페이지 링크 */
		#topMain {
			background-color: grey;
			width: 100%;
			height: 85px;
			text-align: center;
		}
		
		/* 		탑버튼 */
		#top {
			float: right;
			clear: both;
			padding: 5px;
		}
		
		/* 		사이드 바 */
		#navi {
			float: left;
			width: 17%;
			height: 76vh;
			border-right: 1px solid grey;
			box-sizing: border-box;
			padding: 30px 0 200px 30px;
		}
		
		/* 		비디오 포스팅 */
		#videoPosting {
			float: right;
			width: 79%;
		}
		
		/* 		풋터 */
		#footer {
			float: left;
			width: 100%;
			height: 20%;
			text-align: center;
		}
	</style>
	
	<script>
			$(function(){
				if ('<%=msg%>'.length > 0) {
					alert('<%=msg%>');
			}
		});
	</script>
</head>
<body>

	<!-- header -->
	<jsp:include page="/WEB-INF/jsp/inc/headerNav.jsp">
		<jsp:param name="isLogined" value="<%=isLogined %>" />
		<jsp:param name="contextPath" value="<%=contextPath %>" />
		<jsp:param name="id" value="<%=id %>" />
	</jsp:include>

	<!-- 사이드 바 -->
	<aside id="navi">
		<ul>
			<li><a href="<%=contextPath %>/jiutopia/videoListView.do">주짓수
					배우기</a></li>
			<li><b><a
					href="<%=contextPath %>/jiutopia/seminarListView.do">세미나목록</a></b></li>
		</ul>
	</aside>

	<!-- 비디오 입력 폼 -->
	<section id="videoPosting">
		<form name="videoPostFrm" action="<%=contextPath%>/jiutopia/videoAdd.do" method="post">
			<p>
				<input type="hidden" name="memId" value="<%=id %>">
			</p>
			<p>
				제목 : <input type="text" name="videoTitle"
					value="<%=videoTitle %>"
					placeHolder="이곳에 제목을 입력하세요." style="width: 400px;">
			</p>
			<p>
				URL : <input type="text" name="videoUrl"
					value="<%=videoUrl %>"
					placeHolder="이곳에 URL을 입력하세요." style="width: 400px;">
			</p>
			<p> 분류 :
				<select name="videoCtgr">
					<option value="VIDEO_SPT">스포츠 영상</option>
					<option value="VIDEO_DEF">호신술 영상</option>
				</select>
			</p>
			<p>
				내용 :
				<textarea name="videoCont" rows="17" cols="140"
					placeHolder="이곳에 내용을 입력하세요."><%=videoCont%></textarea>
			</p>
			<input type="submit" name="addBtn" value="등록" class="button">
			<input type="button" name="cancelBtn" value="취소" class="button"
				onClick="postCancel();">
		</form>
	</section>

	<!-- 푸터 -->
	<footer id="footer">
		<p>
			<b>“ 주짓수는 작고 약한 사람이 자신을 보호할 수 있는 유일한 호신술이다. ” 엘리오 그레이시(1913 –
				2009)</b>
		</p>
	</footer>
</body>

<script>
	// 	취소 버튼
	function postCancel() {
		var boo = confirm('작성중이던 내용이 사라집니다. 정말 취소 하시겠습니까?');
		if (boo == true) {
			location.reload();
		} else if (boo == false) {

		}
	}
</script>

</html>