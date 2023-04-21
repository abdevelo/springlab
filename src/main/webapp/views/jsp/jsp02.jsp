<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-sm-8 text-left">
    <div class="container">
        <h1> Jsp 02 </h1>
        <c:if test="${rcust!=null}">
            <h4>${rcust.id}</h4>
            <%--  위는 c:out으로도 출력할 수 있음을 기억하세요--%>

            <%--  JST if--%>
            <c:if test="${rcust.id == 'id01'}">
                <h4>콜센터 직원</h4>
            </c:if>
            <%--  JST if else--%>
            <c:choose>
                <c:when test="${num ==3}">
                    <h3>Num is 3</h3>
                </c:when>
                <c:when test="${num ==2}">
                    <h3>Num is 2</h3>
                </c:when>
                <%--  JST Else--%>
                <c:otherwise>
                    <h3>Num is 1</h3>
                </c:otherwise>
            </c:choose>
        </c:if>
        <h1> End Page </h1>
    </div>

</div>