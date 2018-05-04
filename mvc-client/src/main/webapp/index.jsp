<%@ page language="java" contentType="text/html; charset=UTF-8" session="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:url value="/" var="curRoot" />
<!DOCTYPE html>

<!DOCTYPE html>
<html>
<head>

        <base href="${curRoot}" />
    <title>My first Vue app</title>

</head>
<body>
<c:redirect url="/index.html"/>


</body>
</html>