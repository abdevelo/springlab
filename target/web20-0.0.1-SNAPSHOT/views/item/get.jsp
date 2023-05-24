<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let item_get = {
        init:function () {
            $('#cart_btn').click(function (){
                let cust_id = '${logincust.id}';
                // 가져오는 값이 string : '' 로 감싸주기, int : 그대로 가져오기
                let item_id = ${gitem.id};
                let cnt = $('#cnt').val();
                $.ajax({
                    url:'/addcart',
                    // /item/addcart 와는 다름 ajax 용
                    data:{cust_id:cust_id, item_id:item_id, cnt:cnt},
                    success:function (){
                        $('#myModal').modal();
                    }
                })
            });
        }
    };
    $(function (){
        item_get.init();
    });
</script>

<div class="col-sm-8 text-left">
    <h1>Item Info</h1>
    <img src="/img/${gitem.imgname}">
    <h4>이름 : ${gitem.name}</h4>
    <h4>가격 : ${gitem.price}</h4>

    <c:if test="${logincust != null}">
        <form id="cart_form" class="form-inline well"> <!-- form 이름 수정함 -->
            <input type="hidden" name="cust_id" value="${logincust.id}">
            <input type="hidden" name="item_id" value="${gitem.id}">
            <div class="form-group">
                <label class="control-label col-sm-4" for="cnt">Count : </label>
                <input id="cnt" type="number" class="form-control" name="cnt" placeholder="Enter Count">
                <div clas="col-sm-2">
                    <button type="button" id="cart_btn" name="update_btn" class="btn btn-primary">Cart</button>
                </div>
            </div>
        </form>
    </c:if>
</div>

<%--장바구니 추가 시 모달 출력--%>


<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
                <a href="/item/allcart?id=${logincust.id}" class="btn btn-info" role="button">장바구니로 이동</a>
                <a href="/item/allpage" class="btn btn-info" role="button">계속 쇼핑</a>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>