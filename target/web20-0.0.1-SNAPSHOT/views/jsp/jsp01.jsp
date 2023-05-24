<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    $(function(){
        jsp01.init(${num});
    });
</script>



<div class="col-sm-8 text-left">
    <h1 id="jsp01"> Jsp 01 </h1>
    <%--    EL : 보안 기술을 적용시키지 않은 부분--%>
    <h3>${num}</h3>
    <h3>${cdate}</h3>
    <h3>${cust.id}</h3>
    <h3>${cust.name}</h3>
    <hr>
    <%--    JSTL : 보안기술을 적용시킨 부분--%>
    <h3> <c:out value="${cust.id}"/></h3>
    <h3> <c:out value="${cust.name}"/></h3>
    <hr>
    <%--    시간표현--%>
    <fmt:formatDate  value="${cdate}" pattern="yyyy-mm-dd:hhmmss" /> </br>
    <hr>
    <%--    통화표현--%>
    <fmt:parseNumber integerOnly="true" type="number" value="${num}" /> </br>
    <fmt:formatNumber value="${num}" type="currency" /> </br>
    <fmt:formatNumber type="number" pattern="###.###$" value="${num}" /> </br>
    <hr>

<%--    set & out--%>
<%--    값을 set해주고 out(출력)은 다른 곳에서 --%>
<%--    실제 jsp문서에서 이렇게 연산하는 것은 사실 좋지 않아서 --%>
<%--    서버단에서 해주는 게 좋지만--%>
<%--    불가피하게 필요할 경우 사용가능--%>

    <h3>${num*2}</h3>
    <c:set var="mynum" value="${num*3}"/>
    <h6><c:out value="${mynum}"/></h6>

</div>