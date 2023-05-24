<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    .medium_img{
        width : 80px;
    }
</style>

<div class="col-sm-8 text-left">
    <div class="low content">
        <div class="col-sm-8 text-left">
            <h1>Item All page</h1>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>IMG</th>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>PRICE</th>
                    <th>RDATE</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="obj" items="${allitem}">
                    <tr>
                        <td><img src="/img/${obj.imgname}" class="medium_img"></td>
                        <td>${obj.id}</td>
                        <td>${obj.name}</td>
                        <td><fmt:formatNumber value="${obj.price}" type="currency"/></td>
                        <td><fmt:formatDate value="${obj.rdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>