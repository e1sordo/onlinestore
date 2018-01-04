<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>
<a href="../../index.jsp" target="_blank">Go back to the main page.</a>
<br>

<h3>Product list</h3>
<c:if test="${!empty listProducts}">
    <table width="100%">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${listProducts}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}.0</td>
                <td><a href="<c:url value='/edit/${product.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${product.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<hr><hr>
<br>

<h3>Add new product</h3>

<c:url var="addAction" value="/products/add">
    <form:form action="${addAction}" commandName="product">
        <table>
            <c:if test="${!empty product.productName}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="id"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="productName">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="productName"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="productDescription">
                        <spring:message text="Description"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="productDescription"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="price">
                        <spring:message text="Price"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="price"/>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <c:if test="${!empty product.productName}">
                        <input type="submit" value="<spring:message text='Edit item'/>"/>
                    </c:if>
                    <c:if test="${empty product.productName}">
                        <input type="submit" value="<spring:message text='Add item'/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</c:url>

</body>
</html>
