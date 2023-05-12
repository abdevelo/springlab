<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

    $(function (){
    });

</script>

<div class="col-sm-8">
    <div class="container">
        <div class="row content">
            <h1>ocr1</h1>
            <h2>${result.biznum}</h2>
            <h2>${result.bizname}</h2>
            <h2>${result.bizowner}</h2>
            <h2>${result.bizdate}</h2>
            <h2>${result.bizadd}</h2>
            <hr>
            <form action="/ocrimpl1" method="post" enctype="multipart/form-data" id="ocr1_form" class="form-horizontal well col-sm-8">
                <div class="form-group" for="img">
                    <input id="id" type="file" name="img" class="form-control" placeholder="Input image...">
                </div>
            <hr>
                <button type="submit" id="ocr1_btn" name="login_btn" class="btn btn-primary">SEND</button>
            </form>

        </div>
    </div>
</div>
