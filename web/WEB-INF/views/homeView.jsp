<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
</head>

<body>

<a href="${pageContext.request.contextPath}/login">
    Регистрация
</a>
&nbsp;
<span style="color:red">[ ${loginedUser.userName} ]</span>

<h3>Скачать файл только с расширением txt</h3>
<br/>
Скачать фотографию: <a href="download?param=test2.jpg">test.jpg</a>
</p>
Скачать файл: <a href="download?param=test.txt">test.txt</a>

</body>
</html>
