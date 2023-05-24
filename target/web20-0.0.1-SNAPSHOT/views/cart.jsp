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
            <h1>CART page</h1>

<%--            total이라는 변수를 선언( 초기값은 0 )--%>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>IMG</th>
                    <th>ITEM_ID</th>
                    <th>NAME</th>
                    <th>PRICE</th>
                    <th>COUNT</th>
                    <th>TOTAL</th>
                    <th>RDATE</th>
                    <th>DELETE</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="obj" items="${allcart}">
                    <tr>
                        <td><img src="/img/${obj.item_imgname}" class="medium_img"></td>
                        <td>${obj.item_id}</td>
                        <td>${obj.item_name}</td>
                        <td><fmt:formatNumber value="${obj.item_price}" pattern="###,###원"/></td>
                        <td>${obj.cnt}</td>
                        <td><fmt:formatNumber value="${obj.cnt * obj.item_price}" pattern="###,###원"/></td>
                        <td><fmt:formatDate value="${obj.rdate}" pattern="yyyy-MM-dd"/></td>
                        <td> <a href="/item/delcart?id=${obj.id}" class="btn btn-info" role="button">DELETE</a></td>
<%--                        카트의 id는 pk는 아니지만 unique함--%>
                    </tr>
                   <c:set var="total" value="${total + (obj.cnt * obj.item_price)}"/>
<%--                    for문이 돌아가면서 total의 값을 계산--%>
                </c:forEach>
                </tbody>
            </table>
            <h4>장바구니 총액 : <fmt:formatNumber value="${total}" pattern="###,###원"/></h4>
<%--            for문 안에서 만든 값을 for 문 밖에서 출력--%>
        </div>
    </div>
</div>