<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    $(function (){
        login_form.init(); // form정보를 서버에 전송
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
                <button type="button" class="btn btn-success">Forget?</button>

            </form>

        </div>
    </div>
</div>
