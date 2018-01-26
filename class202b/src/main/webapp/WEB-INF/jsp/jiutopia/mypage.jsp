<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>

<%@ page import="com.ohhoonim.vo.BookmarkVo"%>
<%@ page import="com.ohhoonim.vo.VideoVo"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>

<%
	Map<String, List<Map<String, Object>>> bookedGroupListMap = (Map<String, List<Map<String, Object>>>)request.getAttribute("bookedGroupListMap");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>마이 페이지</title>
	
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
			width: 20%;
			height: 80%;
		}
		
/* 		북마크 리스트 */
		#bookList {
			float: right;
			width: 79%;
			height: 80%;
		}
		
		.bookView {
			width: 500px;
			height: 350px;
		}
		
		.myList {
			padding: 20px;
		}
		
/* 		풋터 */
		#footer {
			float: left;
			width: 100%;
			height: 20%;
			text-align: center;
		}
	</style>
	
	<link rel="StyleSheet" type="text/css" href="/class202b/css/main2_header.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel='stylesheet' type='text/css' href='/class202b/css/month1.css' />

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
		
</head>
<body>

	<!-- header -->
	<jsp:include page="/WEB-INF/jsp/inc/headerNav.jsp">
		<jsp:param name="isLogined" value="<%=isLogined %>" />
		<jsp:param name="contextPath" value="<%=contextPath %>" />
		<jsp:param name="id" value="<%=id %>" />
	</jsp:include>
	
	<div id="content-wrap">
		<!-- 사이드 바 -->
		<aside id="navi">
			<ul>
				<li><a href="<%=contextPath %>/jiutopia/videoListView.do">주짓수 배우기</a></li>
				<li><b><a href="<%=contextPath %>/jiutopia/seminarListView.do">세미나목록</a></b></li>
			</ul>
	    </aside>
	    
		<!-- 북마크 리스트 -->
	    <section id="bookList">
			
		<!-- 북마크 그룹 -->
		<%
			Set<String> groupIds = bookedGroupListMap.keySet();
			
			for(String groupId: groupIds) {
				List<Map<String, Object>> groupList = bookedGroupListMap.get(groupId);
				int listSize = groupList.size();
				
				for(int i = 0; i < listSize; i++) {
					Map<String, Object> row = groupList.get(i);
					String gName = row.get("idx") == null? "": row.get("idx").toString(); 
			    	if(i == 0) { 
					%>
					<fieldset class="myGroup">
						<legend><%=row.get("groupNm")%></legend>
						<!-- 그룹 삭제 버튼 -->
						<% if (!gName.equals("9999")) { %>
								<form action="<%=contextPath%>/jiutopia/bookGroupDel.do" method="post">
									<input type="hidden" name="memId" value="<%=id%>">
									<input type="hidden" name="idx" value="<%=row.get("idx")%>">
									<input type="submit" value="그룹 제거" class="button">
								</form>
						<% } %>
						<br/><br/>
					<% } %>
						<div name="bookView">
							<a href="<%=contextPath%><%=row.get("url")%>">
								<img src="<%=row.get("thumb") == null? "http://placehold.it/400x300" : row.get("thumb")%>" 
									 alt="<%=row.get("title")%>" style="width:400px;height:300px"/>
							</a> 
							<p><%=row.get("title")%><p>
							
						<!-- 그룹에 속한 경우만 '그룹에서 제거' 버튼 표시 -->
							<% if (!gName.equals("9999")) { %>
								<form action="<%=contextPath%>/jiutopia/bookmarkDelFromGroup.do" method="post">
									<input type="hidden" name="memId" value="<%=id%>">
									<input type="hidden" name="id" value="<%=row.get("id")%>">
									<input type="submit" name="bookmarkDelFromG" value="그룹에서 제거" class="button">
								</form>
							<% } %>
							
						<!-- 즐겨찾기 게시물 그룹에 추가하기 -->
							<% if (gName.equals("9999")) { %>
								<form name="addGroupForm" action="" method="get">
									<input type="hidden" name="memId" value="<%=id%>" readonly>
									<input type="hidden" name="bookedId" value="<%=row.get("id")%>" readonly>
									<input type="button" name="addIntoBookGroup" value="그룹에 추가" class="button" onClick="openGroupPop(this);">
								</form>
							<% } %>
							
						<!-- 즐겨찾기 해제 버튼 -->
								<form action="<%=contextPath%>/jiutopia/bookmarkDel.do" method="post">
									<input type="hidden" name="memId" value="<%=id%>">
									<input type="hidden" name="id" value="<%=row.get("id")%>">
									<input type="submit" name="bookmarkDel" value="즐겨찾기 해제" class="button">
								</form>
							<br/><br/>
						</div>
					<% if(i == (listSize - 1)) {  %>
					</fieldset>
					<%		
					}
				}
			}
		%>
		
		<!-- 북마크 그룹 생성 -->
			<div id="bookGroupAddPop">
				<p>북마크 그룹 추가하기</p>
				<input type="button" name="bookGroupAdd" value="그룹생성" class="button" onClick="openPop();">
			</div>
	    </section>
    </div>
				
	<!-- 탑버튼 -->
	<div>
		<input id="top" type="button" value="TOP" onclick="window.scrollTo(0,0);">
	</div>
	
	<footer id="footer">
		<p><b>“ 주짓수는 작고 약한 사람이 자신을 보호할 수 있는 유일한 호신술이다. ” 엘리오 그레이시(1913 – 2009)</b></p>
	</footer>
	
</body>

<script>

// 	북마크 그룹 추가 팝업
	function openPop(){
		var X = (window.screen.width/2)-(400/2);
		var Y = (window.screen.height/2)-(300/2);
		
		window.open('<%=contextPath%>/jiutopia/bookGroupAddPop.do', 'popUp', 'width=500px, height=300px, left='+X+', top='+Y+'');
		
	}
	
// 	북마크 그룹에 즐겨찾기 게시물 추가 팝업
	function openGroupPop(obj){
		
		var X = (window.screen.width/2)-(400/2);
		var Y = (window.screen.height/2)-(300/2);
		var frm = $(obj).parent();
		
		var memId = $(obj).parent().find('input[name="memId"]').val();
		var bookedId = $(obj).parent().find('input[name="bookedId"]').val();
		
		window.open('<%=contextPath%>/jiutopia/addIntoBookGroupPop.do?memId='+memId+'&bookedId='+bookedId, 'popUp', 'width=500px, height=300px, left='+X+', top='+Y+'');
	}
	

</script>

</html>