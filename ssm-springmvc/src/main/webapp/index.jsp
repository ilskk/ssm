<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
    <a href="/i18n">i18n</a><br/>

    <a href="/success">get</a>
    <form action="/success" method="post">
        name:<input name="name"/><br/>
        age:<input name="age"/><br/>
        not:<input name="not"/>
        <input type="submit" value="post">
    </form>

    <a href="/demo">demo-head</a><br/>
    <a href="/demo2/axb/test">demo2-?</a><br/>
    <a href="/demo3/x/test">demo3-*</a><br/>
    <a href="/demo4/x/q/test">demo4-**</a><br/>
    <a href="/demo5/java">demo5-result</a><br/>
    <a href="/demo7">demo7-head</a><br/>
    <a href="/demo8">demo8-jsessionid</a>

    <form action="/demo9" method="post">
        id:<input name="id"/><br/>
       name:<input name="name"/><br/>
        addressName:<input name="address.addressName"/>
        <input type="submit" value="提交"/>
    </form>

    <a href="/demo10">demo10-ModelAndView</a><br/>
    <a href="/demo11">demo11-{3}</a><br/>
    <a href="/demo12">demo12-setName</a><br/>
    <a href="/images/1.jpg">图1</a><br/>

    <form action="/demo13" method="post">
        Person:<input type="text" name="personInfo"/>
        <input type="submit" value="提交"/>
    </form>
    <br/>
    <form action="/demo14" method="post">
        id:<input name="id"/><br/>
        name:<input name="name"/><br/>
        day:<input name="day"/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
