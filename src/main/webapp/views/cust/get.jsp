<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    $(function (){
    });
</script>

<div class="col-sm-8">
    <div class="container">
        <div class="row content">
            <div class="col-sm-8 alert alert-success">
                <strong>Your Info</strong> Modify your information to the update.
            </div>
            <hr>

            <form id="update_form" class="form-horizontal well col-sm-8"> <!-- form 이름 수정함 -->
                <h1>Detail Page</h1>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="id" type="text" class="form-control" name="id" value="${gcust.id}" readonly>
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="pwd" value="${gcust.pwd}">
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-font"></i></span>
                    <input id="name" type="name" class="form-control" name="name" value="${gcust.name}">
                </div>
                <br/>
                <hr>

                <button type="button" id="update_btn" name="update_btn" class="btn btn-primary">UPDATE</button>
                <button type="button" id="remove_btn" name="remove_btn" class="btn btn-primary">DELETE</button>
                <button type="button" class="btn btn-success">Already Member?</button>

            </form>

        </div>
    </div>
</div>
