<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

    $(function (){
    });

</script>

<div class="col-sm-8">
    <div class="container">
        <div class="row content">
            <h1>CFR2</h1>
            <h2>${result.emotion}</h2>
            <h2>${result.pose}</h2>
            <h2>${result.gender}</h2>
            <h2>${result.age}</h2>
            <hr>
            <form action="/cfr2impl" method="post" enctype="multipart/form-data" id="ctr2_form" class="form-horizontal well col-sm-8">
                <div class="form-group" for="img">
                    <input id="id" type="file" name="img" class="form-control" placeholder="Input image...">
                </div>
                <hr>
                <button type="submit" id="ctr2_btn" name="login_btn" class="btn btn-primary">SEND</button>
            </form>

        </div>
    </div>
</div>
