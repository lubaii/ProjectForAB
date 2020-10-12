
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Это страница: ${loginedUser.userName}</h3>

 <b>Вы можете скачать файлы с другими расширениями</b>

<br/>
Скачать фотографию: <a href="download?param=test2.jpg">test2.jpg</a>
</p>
Скачать файл: <a href="download?param=test.txt">test.txt</a>


</body>
</html>
