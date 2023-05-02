<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%--규칙 1: cpage라는 이름으로 데이터를 넣어야 함--%>

<!-- pagination Navigation start -->
<div class="col text-center">
  <ul class="pagination ">
    <c:choose>
      <c:when test="${cpage.getPrePage() != 0}">
        <li>
          <a href="/${target}/allpage?pageNo=${cpage.getPrePage()}">Previous</a>
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
            <a  href="/${target}/allpage?pageNo=${page}">${page }</a>
          </li>
        </c:when>
        <c:otherwise>
          <li>
            <a href="/${target}/allpage?pageNo=${page}">${page }</a>
          </li>
        </c:otherwise>
      </c:choose>

    </c:forEach>
    <c:choose>
      <c:when test="${cpage.getNextPage() != 0}">
        <li>
          <a href="/${target}/allpage?pageNo=${cpage.getNextPage()}">Next</a>
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