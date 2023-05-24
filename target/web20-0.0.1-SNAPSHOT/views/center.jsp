<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> <%--다국어용--%>

<style>
    #w2 {
        width:500px;
        border : 2px solid red;
    }
</style>
<script>
    let center = {
        init:function(){
            $.ajax({
                url:'/weather2',
                success:function(data){
                    center.display(data);
                }
            })
        },
        display:function(data){
            var result = data.response.body.items.item; //여기서 result는 배열데이터;
            var txt = '';

            $(result).each(function(index, item){
                txt += '<h5>';
                txt += item.tm+' '+item.ta;
                txt += '<h5>';
            });

            $('#w2').html(txt);
        }
    };
    $(function(){
        // center.init();
    });
</script>

<div class="col-sm-8 text-left">
    <h1><spring:message code="site.title"/></h1>
    <p><spring:message code="site.content"/></p>
    <hr>
    <h1> 기상 예보 </h1>
    <textarea id="w1" cols="80" rows="10">${weatherinfo}</textarea> <%--파싱해서 가져온 것들--%>
    <hr>
    <div id="w2" cols="80" rows="10"></div>
</div>