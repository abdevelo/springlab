<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-8 text-left">
  <div class="container">
    <div class="row content">
      <div class="col-sm-6  text-left ">
        <h3>Cust All Page</h3>
        <table class="table table-hover">
          <thead>
          <tr>
            <th>ID</th>
            <th>NAME</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="c" items="${cpage.getList()}">
            <tr>
              <td><a href="/cust/get?id=${c.id}">${c.id}</a></td>
              <td>${c.name}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
        <!-- pagination start -->
        <div class="col text-center">
          <ul class="pagination ">
            <c:choose>
              <c:when test="${cpage.getPrePage() != 0}">
                <li>
                  <a href="/cust/allpage?pageNo=${cpage.getPrePage()}">Previous</a>
                </li>
              </c:when>
              <c:otherwise>
                <li class="disabled">
                  <a href="#">Previous</a>
                </li>
              </c:otherwise>
            </c:choose>

            <c:forEach begin="${cpage.getNavigateFirstPage() }" end="${cpage.getNavigateLastPage() }" var="page">
              <c:choose>
                <c:when test="${cpage.getPageNum() == page}">
                  <li class="active">
                    <a  href="/cust/allpage?pageNo=${page}">${page }</a>
                  </li>
                </c:when>
                <c:otherwise>
                  <li>
                    <a href="/cust/allpage?pageNo=${page}">${page }</a>
                  </li>
                </c:otherwise>
              </c:choose>

            </c:forEach>
            <c:choose>
              <c:when test="${cpage.getNextPage() != 0}">
                <li>
                  <a href="/cust/allpage?pageNo=${cpage.getNextPage()}">Next</a>
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
        <!-- pagination end -->
      </div>
    </div> <!-- -->
  </div>
</div>