<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>
<h3 style="color:red;"> Чтобы скачать файлы с другим расширением, необходимо зарегистрироваться</h3>

<h3>Страница регистрации</h3>

<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/login">
    <input type="hidden" name="redirectId" value="${param.redirectId}" />
    <table border="0">
        <tr>
            <td>Имя</td>
            <td><input type="text" name="userName" value= "${user.userName}" /> </td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td><input type="password" name="password" value= "${user.password}" /> </td>
        </tr>

        <tr>
            <td colspan ="2">
                <input type="submit" value= "Войти" />
                <a href="${pageContext.request.contextPath}/">Отмена</a>
            </td>
        </tr>
    </table>
</form>

<p style="color:blue;">Данные для входа:</p>

admin1/456 <br>
user1/123



</body>
</html>