<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    // id 및 pw 전송
    let reg_form = {
        init:function (){
            $('#reg_btn').click(function (){
                reg_form.send();
            });
        },
        send:function (){
            $('#reg_form').attr({
                'action':'/loginimpl', //action하면 하게될 서버의 작업
                'method':'get'
            });
            $('#reg_form').submit();
        }
    };

    $(function (){
        reg_form.init();
    });

</script>


<div class="col-sm-8">
    <div class="container">
        <div class="row content">
            <div class="col-sm-8 alert alert-info">
                <strong>Info!</strong> Finish the register form down below to join our site.
            </div>

            <hr>
            <form id="reg_form" class="form-horizontal well col-sm-8">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="id" type="text" class="form-control" name="id" placeholder="id">
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="pwd" placeholder="Password">
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-font"></i></span>
                    <input id="name" type="name" class="form-control" name="name" placeholder="Name">
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                    <input id="phone" type="phone" class="form-control" name="phone" placeholder="phone">
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                    <input id="address" type="address" class="form-control" name="address" placeholder="address">
                </div>
                <hr>

                <button type="button" id="reg_btn" name="reg_btn" class="btn btn-primary">Register</button>
                <button type="button" class="btn btn-danger">CANCEL</button> <br/><br/>
                <button type="button" class="btn btn-success">Already Member?</button>

            </form>

        </div>
    </div>
</div>
