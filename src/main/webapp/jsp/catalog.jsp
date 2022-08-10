<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Каталог товаров</title>
</head>
<body>
<table>
    <caption>Каталог товаров(${catalog.size()})</caption>
    <tr>
        <th scope="col">Артикул</th>
        <th scope="col">Название</th>
        <th scope="col">Цена, руб</th>
    </tr>
    <c:forEach items="${catalog}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>