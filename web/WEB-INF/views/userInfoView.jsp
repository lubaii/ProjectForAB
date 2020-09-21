
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

Имя: <b>${loginedUser.userName}</b>
<br />
<form action="uploadServerAll" method="post" enctype="multipart/form-data">
    <p>
        <input type="file" name="file">
        <input type="submit" value="Скачать"></p>
</form>

</body>
</html>
