<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>

    <%-- path:绑定的对象中的属性值
        checkbox:自动绑定request域中的值
            (1),通过boolean值绑定
            (2),绑定集合(List,Set),数组中的值
            (3),(了解)嵌套对象的toString()返回值
     --%>
    <form:form commandName="peo" action="/fc">
        <%--<form:input path="id"/>--%>
        <%--<form:input path="name"/>--%>
        <%--<form:checkbox path="address" value="A"/>--%>
        <%--<form:checkbox path="address" value="A"/>--%>
        <%--<form:checkbox path="address" value="O"/>--%>
        <%--<form:checkboxes path="list" items="${all}"/>--%>
        <%--中国<form:radiobutton path="country" value="China"/>--%>
        <%--美国<form:radiobutton path="country" value="USE" />--%>
        
        <%--<form:radiobuttons path="string" items="${cs}" delimiter=","/>--%>

        <%--<form:select path="string" items="${cs}"/>--%>
        <form:select path="string">
            <%--<form:options />--%>
            <form:option value="A">啊-option</form:option>
            <%--<form:option value="B">吧</form:option>--%>
            <form:option value="O">哦-option</form:option>
            <option value="O">哦-html</option>
        </form:select>
    </form:form>


    <form:form action="/test" method="post">
        <input type="submit" value="增加"/>
    </form:form>

    <form:form action="/test" method="delete">
        <input type="submit" value="删除"/>
    </form:form>

    <form:form action="/test" method="put">
        <input type="submit" value="修改"/>
    </form:form>

    <form:form action="/test" method="get">
        <input type="submit" value="查看"/>
    </form:form>


</body>
</html>
