<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page import="com.ohhoonim.vo.VideoVo" %>
<%@ page import="com.ohhoonim.vo.EVCmmtVo" %>

<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<%
	String videoId = (String)request.getAttribute("videoId");
	List<EVCmmtVo> videoCmmtList = (List<EVCmmtVo>)request.getAttribute("videoCmmtList");
	Map<String, String> videoDetail = (Map<String, String>)request.getAttribute("videoDetail");
	boolean isWriter = (videoDetail != null && isLogined && id != null && id.equals(videoDetail.get("memId"))) ? true: false;
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	
	<title>동영상 상세페이지</title>
	
	<link rel="StyleSheet" type="text/css" href="/class202b/css/main2_header.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	
	<script>
		$(function(){
			
			$('#cmmtAdd').submit(function(event){
				var replyVal = $('#memo').val();
				if (replyVal != null && replyVal.length > 3) {
					return;
				}
				alert('댓글이 입력되지 않았거나 4글자 이상 입력해주세요.\n 입력한 글자수: ' + replyVal.length);
				event.preventDefault();
			});
			
			
		});
	</script>
	
	<style>
	
	/* 		타이틀 메인페이지 링크 */
	#topMain {
		background-color: grey;
		width: 100%; 
		height: 85px;
		text-align: center;
	}
	#wrapper{
		padding-top: 15px;
		padding-right: 10px;
		padding-bottom: 0px;
		padding-left: 0px;
	}
	#menuNavigator {
		width: 15%;
		float: left;
	}
	#videoDetail {
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
	#videoBookmark{
		float: right;
	}
	#videoCmmtAdd{
		float: right;
	}
</style>
</head>
<body>	
	<!-- header -->
	<jsp:include page="/WEB-INF/jsp/inc/headerNav.jsp">
		<jsp:param name="isLogined" value="<%=isLogined %>" />
		<jsp:param name="contextPath" value="<%=contextPath %>" />
		<jsp:param name="id" value="<%=id %>" />
	</jsp:include>

<div id = "wrapper">
	<div id = "menuNavigator">
		<ul class = "eventChoice">
			<li><a href="<%=contextPath %>/jiutopia/videoListView.do?videoType=DEF" >호신술 영상</a></li><br/>
			<li><b><a href="<%=contextPath %>/jiutopia/videoListView.do?videoType=SPT" >스포츠 영상</a></b></li><br/>
		</ul>
	</div>
	<div id = "videoDetail">
		
		<div id = "videoArea">
			<table>
				<tr>
					<td>
						<h1><%=videoDetail.get("videoTitle")%></h1>
					</td>
				</tr>
				<tr>
					<td>
						<iframe width="1000" height="600" src="<%=videoDetail.get("videoUrl") %>" frameborder="0" allowfullscreen></iframe>
					</td>
				</tr>
				<tr>
					<td>
					<!-- 즐겨찾기 추가 -->
					<% if (id != null) { %>
						<form id="bookmarkAdd" action="<%=contextPath%>/jiutopia/bookmarkAdd.do" method="post">
							<input type="hidden" name="memId" value="<%=id%>" readonly>
							<input type="hidden" name="ctgr" value="<%=videoDetail.get("videoId")%>" readonly>
							<input type="submit" id="videoBookmark" name="videoBookmark" value="즐겨찾기추가">
						</form>
					<% } %>
					<% if (isWriter) {%>
					<form id="videoDel" action="<%=contextPath%>/jiutopia/videoDel.do" method="post">
						<input type="hidden" name="videoId" value="<%=videoId%>">
						<input type="submit" value="삭제">
					</form>s
					<% }%>
					</td>
				</tr>
				<tr>	
					<td>
						<p><%=videoDetail.get("videoWtime") %></p>
					</td>
				</tr>	
				<tr>
					<td>
						<p><%=videoDetail.get("videoCont") %></p>
					</td>
				</tr>
			</table>
		</div>
		
		<!-- 댓글 -->
		<div id = "commentArea">
		<style>
			#replyArea .left { display: inline; width: 250px; float: left;}
			#replyArea .left input { display: block; width: 230px;}
			#replyArea .right { display: inline; width: auto; float: left;}
		</style>
	<!-- 댓글 입력 -->
	<%
		if(id != null) {	
	%>
	<form name="cmmtAdd" id="cmmtAdd" action="<%=contextPath%>/jiutopia/cmmtAdd.do" method="post">					
		<input type="hidden" id="memId" name="memId" value="<%=id %>">
		<input type="hidden" id="videoId" name="videoId" value="<%=videoId%>">
		
		<div id="replyArea">
			<div class="right">
				<input type="text" name="memo" id="memo" rows="2" cols="50" maxlength="400" title="댓글내용입력" value="">
			</div>
		</div>
				
		<input type="submit" value="입력">
	</form>
	<%
		}
	%>
	
	
	<!-- 댓글 목록 -->
			<table id="cmmtList">
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>날짜</th>
					<th></th>
					<th></th>
				</tr>
				<% for (EVCmmtVo row: videoCmmtList) { %>
				<tr>
					<td><%=row.getMemId()%></td>
					<td><%=row.getCmmtCont()%></td>
					<td><%=row.getCmmtWtime()%></td>
					<td>
						<%
							if(id != null && row.getMemId().equals(id)) {	
						%>
						<form action="<%=contextPath%>/jiutopia/cmmtDel.do" method="post" name="cmmtDel" >
							<input type="submit" value="삭제">
							<input type="hidden" name="memId" value="<%=row.getMemId()%>">
							<input type="hidden" name="cmmtId" value="<%=row.getCmmtId()%>">
							<input type="hidden" name="videoId" value="<%=videoId%>">
						</form>
						<%
							}
						%>
					</td>
				</tr>
				<% } %>
			</table>		
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