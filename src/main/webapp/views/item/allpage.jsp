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
                <c:forEach var="obj" items="${ipage.getList()}">
<%--                    ipage는 페이지 정보이므로 그 속의 list를 꺼내야 함--%>
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

            <!-- pagination Navigation start -->
            <div class="col text-center">
                <ul class="pagination ">
                    <c:choose>
                        <c:when test="${ipage.getPrePage() != 0}">
                            <li>
                                <a href="/cust/allpage?pageNo=${ipage.getPrePage()}">Previous</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="disabled">
                                <a href="#">Previous</a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach begin="${ipage.getNavigateFirstPage() }" end="${ipage.getNavigateLastPage() }" var="page">
                        <c:choose>
                            <c:when test="${ipage.getPageNum() == page}">
                                <li class="active">
                                    <a  href="/item/allpage?pageNo=${page}">${page }</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="/item/allpage?pageNo=${page}">${page }</a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                    <c:choose>
                        <c:when test="${ipage.getNextPage() != 0}">
                            <li>
                                <a href="/item/allpage?pageNo=${ipage.getNextPage()}">Next</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="disabled">
                                <a href="#">Next</a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                </ul>
            </div>
            <!-- pagination Navigation end -->
            
        </div>
    </div>
</div>