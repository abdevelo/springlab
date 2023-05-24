<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    img{
        width:150px;
    }
</style>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>Marker Detail</h3>
        <img src="/img/${gmarker.img}">
        <h4>${gmarker.id}</h4>
        <h4><a href="${gmarker.target}">${gmarker.title}</a></h4>

        <div class="low content">
            <div class="col-sm-6 text-left">
                <h3>MARKER DESC page</h3>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ITEM</th>
                        <th>PRICE</th>
                        <th>IMGNAME</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="c" items="${mlist}">
                        <tr>
                            <td>${c.item}</td>
                            <td>${c.price}</td>
                            <td><img src="/img/${c.imgname}"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>