<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">
        h2{
            color: green;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>

    <fmt:message key="resource.welcome"/>
    <fmt:message key="resource.exit"/>

    <h1>SUCCESS</h1>
    <h1>request:</h1>
    <h2>${mav}</h2>
    <h2>model:${model}</h2>
    <h2>modelmap:${modelmap}</h2>
    <h2>map:${person1}</h2>
<hr/>
    <h1>session:</h1>
    <h2>${sessionScope.person1}</h2>
    <h2>${sessionScope.sp}</h2>
</body>
</html>
