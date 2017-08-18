<%@page pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Funt
  Date: 23.07.2017
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title></title>

  <c:url var="home" value="/" scope="request" />

  <spring:url value="/resources/core/css/bootstrap.min.css"
  	var="bootstrapCss" />
  <link href="${bootstrapCss}" rel="stylesheet" />

  <spring:url value="/resources/core/css/catalog.css" var="catCss" />
  <link href="${catCss}" rel="stylesheet" />

  <spring:url value="/resources/core/js/jquery.1.10.2.min.js"
  	var="jqueryJs" />
  <script src="${jqueryJs}"></script>

</head>


<body>

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
          <a class="navbar-brand" href="./">Spring Boot Session</a>
		</div>

        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>

                <h2 style="color: #FFFFFF">Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
            </c:when>
            <c:otherwise>
                <h2 style="color: #FFFFFF">Welcome GUEST | <a href="${contextPath}/login">Log In</a></h2>
            </c:otherwise>
        </c:choose>

	</div>


</nav>



</body>
</html>
