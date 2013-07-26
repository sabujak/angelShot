<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=720, user-scalable=no" /> 
	<meta name ="format-detection" content="telephone=no, address=no, email=no" />
	<meta name="format-detection" content="no" />
	<title>Tmap 대리운전</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/mobile.css">
	<script type="text/javascript" src="/resources/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="/resources/js/mj.viewport.js"></script>
	<script type="text/javascript" src="/resources/js/common.js"></script>
	<script type="text/javascript">
	function prevEvent(){
		history.go(-1);
	}

	function update(scale) {    
	   document.getElementById("useragent").textContent = navigator.userAgent;    
	   document.getElementById("scale").textContent = scale || "none";    

	   if (mj.viewport.isIos()) {        
		  document.getElementById("device").textContent = "iOS";    
	   } else if (mj.viewport.isAndroid()) {        
		  document.getElementById("device").textContent = "Android";    
	   } else if (mj.viewport.isPCBrowser()) {        
		  document.getElementById("device").textContent = "PC";    
	   }
	}
	 
	mj.viewport({    width : 720,    onAdjustment : update});
	 
	if (mj.viewport.isIos()) {    
	   window.addEventListener("load", function() {        update(null);    });
	}
	 
	</script>

</head>
<body>
<!-- wrap -->
<div id="wrap" class="tdriver04">
	<h1><img src="/resources/images/t_tdriver.gif" alt="대리운전" /></h1>
	<!-- container -->
	<div id="container">
		<div class="error_message">
			<img src="/resources/images/icon_error.gif" alt="" />
			<p>페이지 로딩이<br />일시적으로 중단되었습니다.<br />다시 시작해 주시기 바랍니다.</p>
		</div>
		<div class="btn_area">
			<a href="#"><img src="/resources/images/btn_ok02.gif" alt="확인" /></a>
		</div>
	</div>
	<!-- container -->
</div>
<!-- //wrap -->
</body>
</html>
