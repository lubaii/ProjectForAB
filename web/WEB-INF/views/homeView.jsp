<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
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

Скачать файл: <a href="DownloadServlet">test.txt</a>
Скачать фотографию: <a href="DownloadServlet2">test2.jpg</a>
<%--<form action="uploadServer" method="post" enctype="multipart/form-data">
    <p>
        <input type="file" name="file">
        <input type="submit" value="Скачать"></p>
</form>--%>
</body>
</html>