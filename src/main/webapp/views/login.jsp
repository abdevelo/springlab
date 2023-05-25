<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://www.google.com/recaptcha/api.js?render=6Lc80jUmAAAAAKfzG9LhqAGVzXG3PO7yG-y1nxLV"></script>
<script>
    $(function() {
        $('#login_btn').click(function() {
            $.ajax({
                url: '/VerifyRecaptcha',
                type: 'post',
                data: {recaptcha: $("#g-recaptcha-response").val()},
                success: function(res) {
                    const data=JSON.parse(res);
                    if(data.success){
                        //alert("자동 가입 방지 봇 통과");
                        $("#login_form").submit();
                    }else{
                        alert("자동 가입 방지 봇을 확인 한뒤 진행 해 주세요.");
                    }
                }
            });
        });
    });
</script>

<div class="col-sm-8">
    <div class="container">
        <div class="row content">
            <div class="col-sm-8 alert alert-danger">
                <strong>Danger!</strong> Keep you safe from the possibility of hacking your keyboard
            </div>
            <hr>
            <form id="login_form" class="form-horizontal well col-sm-8">
                <input type="hidden" name="redirectURL" value="${redirectURL}">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="id" type="text" class="form-control" name="id" placeholder="id">
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="pwd" placeholder="Password">
                </div>
                <hr>
                <button type="button" id="login_btn" name="login_btn" class="btn btn-primary">LOGIN</button>
                <button type="button" class="btn btn-danger">JOIN</button> <br/><br/>
                <div class="g-recaptcha" data-sitekey="6Lc80jUmAAAAAKfzG9LhqAGVzXG3PO7yG-y1nxLV"></div>
            </form>
        </div>
    </div>
</div>
