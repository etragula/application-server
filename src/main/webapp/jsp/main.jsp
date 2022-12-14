<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Главная</title>
</head>
<body>
<h3>Главная страница</h3>
<span style="float:left;">
    <form align="left" action="<c:url value="/"/>" method="get">
        <input type="hidden" name="stage" value="Cart"/>
        <input name="submit" type="submit" value="Корзина">
    </form>
    <form align="left" action="<c:url value="/"/>" method="get">
        <input type="hidden" name="stage" value="Catalog"/>
        <input name="submit" type="submit" value="Каталог">
    </form>
    <form align="left" action="<c:url value="products"/>" method="get">
        <input name="submit" type="submit" value="Товары">
    </form>
</span>
<span style="float:left;">
    <form align="left" action="oneFileUpload" method="get">
        <input type="submit" value="Загрузить файл">
    </form>
    <form align="left" action="twoFilesUpload" method="get">
        <input type="submit" value="Загрузить файлы">
    </form>
</span>
<span style="float:left;">
    <form align="left" action="calculator" method="get">
        <input type="submit" value="Калькулятор">
    </form>
</span>
<form action="signIn" method="get">
    <input type="submit" value="Войти">
</form>
</body>
</html>
