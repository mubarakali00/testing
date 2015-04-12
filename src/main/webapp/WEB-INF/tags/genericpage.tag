<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/js/jquery-1.11.2.min.js" />" ></script>
<link href="<c:url value="/resources/css/main.css" />" type="text/css" rel="stylesheet" />
<title> ${ title } </title>
</head>
  <body>
  <div id="wrapDiv">
  
        <div id="mainContent">
        
	        <div id="pageheader">
	      		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	    	</div>
	    	<div id="body">
	      		<jsp:doBody/>
	    	</div>
	    	<div id="pagefooter">
	      		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	    	</div>
	    	
    	</div>
    	
    </div>
    
  <%-- <div id="wrapDiv">
  
        <div id="leftSidebar">
        </div>
        
        <div id="mainContent">
        
	        <div id="pageheader">
	      		<jsp:invoke fragment="header"/>
	    	</div>
	    	<div id="body">
	      		<jsp:doBody/>
	    	</div>
	    	<div id="pagefooter">
	      		<p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
	    	</div>
	    	
    	</div>
    	
        <div id="rightSidebar">
        </div>
        
        <div id="footerSidebar">
        </div>
    </div> --%>
  
  </body>
</html>