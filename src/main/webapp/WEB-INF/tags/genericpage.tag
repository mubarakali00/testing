<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/js/jquery-1.11.2.min.js" />" ></script>
<link href="<c:url value="/resources/css/main.css" />" type="text/css" rel="stylesheet" />

</head>
  <body>
  <div id="wrapDiv">
        <div id="leftSidebar">
        <!-- This is left side bar .......................................................................................... -->
        </div>
        <div id="mainContent">
	        <div id="pageheader">
	      		<jsp:invoke fragment="header"/>
	    	</div>
	    	<div id="body">
	      		<jsp:doBody/>
	    	</div>
	    	<div id="pagefooter">
	      		<jsp:invoke fragment="footer"/>
	    	</div>
    	</div>
        <div id="rightSidebar">
        <!-- This is right side bar .......................................................................................... -->
        </div>
        <div id="footerSidebar">
        </div>
    </div>
    
  <div id="wrapperDiv">
    
    </div>
  </body>
</html>