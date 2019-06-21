<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>主页</title>
</head>
<body>
    <a href="/query/1">查询1号</a>:${user}<br/>
    <a href="/queryAll">查询全部</a>:${users}<br/>
    <a href="/delete/1">删除1号</a>:${d}<br/>
<hr/>
    <form action="/insert" method="post">
        username:<input name="username"/><br/>
        password:<input type="password" name="password"/><br/>
        <input type="submit" value="注册">:${i}
    </form><br/>
    <form action="/update" method="post">
        id:<input name="id"/><br/>
        password:<input type="password" name="password"/><br/>
        <input type="submit" value="修改密码">:${u}
    </form>
</body>
</html>
