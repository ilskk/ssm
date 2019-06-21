<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#button").click(function(){
                //通过ajax请求springmvc
                $.post(
                    "/ajax",//服务器地址
                    //{"name":"zs","age":23}
                    function(result){//服务端处理完毕后的回调函数,@ResponseBody后,list<Address>就是一个json数组的格式
                        for(var i=0;i<result.length ;i++){
                            alert(result[i].addressName);
                        }
                    }
                );
            });
        });
    </script>
</head>
<body>
    <a href="/fc">Form</a><br/>
    <input type="button" id="button" value="Ajax" /><br/>
    <a href="/i18n">i18n</a><br/>

    <a href="/success">get</a>
    <form action="/success" method="post">
        name:<input name="name"/><br/>
        age:<input name="age"/><br/>
        not:<input name="not"/>
        <input type="submit" value="post">
    </form>

    <a href="/head"></a><br/>
    <a href="/ant1/axb/test">ant1-?</a><br/>
    <a href="/ant2/xxxxx/test">ant2-*</a><br/>
    <a href="/ant3/x/xx/xxx/test">ant3-**</a><br/>
    <a href="/result/java">result</a><br/>
    <a href="/params">params</a><br/>
    <a href="/accept">head</a><br/>
    <a href="/jsessionid">jsessionid</a>

    <form action="/json" method="post">
        id:<input name="id"/><br/>
       name:<input name="name"/><br/>
        addressName:<input name="address.addressName"/>
        <input type="submit" value="提交"/>
    </form>

    <a href="/modelAndView">ModelAndView</a><br/>
    <a href="/mmm">mmm</a><br/>
    <a href="/modify">modify</a><br/>
    <a href="/images/1.jpg">图1</a><br/>

    <form action="/converter" method="post">
        Person:<input type="text" name="personInfo"/>
        <input type="submit" value="提交"/>
    </form>
    <br/>
    <form action="/formatting" method="post">
        id:<input name="id"/><br/>
        name:<input name="name"/><br/>
        day:<input name="day"/><br/>
        email:<input name="email">
        <input type="submit" value="提交"/>
    </form>
    <hr/>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="fileName" /><br/>
        描述:<input type="text" name="desc" /><br/>
        <input type="submit" value="上传"/><span>${status}</span>
    </form>

    <hr/>
    <a href="/interceptor">Interceptor</a><br/>
    <a href="/me">MyException</a><br/>
    <a href="/eh">ExceptionHandler</a><br/>
    <a href="/ms">ExceptionStatus</a>
</body>
</html>
