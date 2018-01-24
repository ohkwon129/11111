<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>주토피아에 오신 것을 환영합니다.</title>
	
	<link rel="StyleSheet" type="text/css" href="/class202b/css/main2_header.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel='stylesheet' type='text/css' href='/class202b/css/month1.css' />

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	<script src='/class202b/js/month2.js'></script>
	<script src='/class202b/js/month1.js'></script>
	<script src='/class202b/js/month3.js'></script>
	<script type='text/javascript'>
		$(document).ready(function() {
			$('#calendar').fullCalendar({
				header : {
					left : 'prev',
					center : 'title,blank, today',
					right : 'next'
				},
				editable : true,
				eventSources : ['<%=contextPath%>/jiutopia/eventScheduleList.do']
			});
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
	
	<br/><br/>

	<div id='calendar'></div>

	<div class="top">
		<input type="button" value="TOP" onclick="window.scrollTo(0,0);">
	</div>
	
	<hr>
	<footer>
		<p><b>“ 주짓수는 작고 약한 사람이 자신을 보호할 수 있는 유일한 호신술이다. ” 엘리오 그레이시(1913 – 2009)</b>
		</p>
	</footer>
</body>

</html>