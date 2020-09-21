<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<a href="${pageContext.request.contextPath}/userTask">
    Пользователь
</a>
||
<a href="${pageContext.request.contextPath}/adminTask">
    Администратор
</a>
||
<a href="${pageContext.request.contextPath}/userInfo">
    Скачать файлы
</a>
||
<a href="${pageContext.request.contextPath}/login">
    Войти
</a>
||
<a href="${pageContext.request.contextPath}/logout">
    Выйти
</a>

&nbsp;
<span style="color:red">[ ${loginedUser.userName} ]</span>
