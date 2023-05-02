<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let custinfo_form = {
        init:function (){
            $('#custinfo_btn').click(function (){
                custinfo_form.send();
            });
        },
        send:function (){
            let id = $('#id').val();
            let pwd = $('#pwd').val();
            let name = $('#name').val();
            if(id.length <=3){
                $('#check_id').text('4자리 이상이어야 합니다.'); // 숨겨진 span 영역에 뿌리는 문구
                $('#pwd').focus();
                return;
            }
            if( pwd == ''){
                $('#pwd').focus();
                return;
            }
            if( name == ''){
                $('#name').focus();
                return;
            }
            $('#custinfo_form').attr({
                'action':'/custinfoimpl', //action하면 하게될 서버의 작업
                'method':'post'
            });
            $('#custinfo_form').submit();
        }
    };
    $(function (){
        custinfo_form.init();
    });

</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6  text-left ">
                <h1>Cust Info Page</h1>
                <form id="custinfo_form" class="form-horizontal well">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="id">ID:</label>
                        <div class="col-sm-10">
                            <input type="text" name="id" class="form-control" id="id" value="${custinfo.id}" readonly>
                        </div>
                        <div class="col-sm-10">
                            <span id="check_id" class="bg-danger"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                        <div class="col-sm-10">
                            <input type="password" name="pwd" class="form-control" id="pwd">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="name">NAME:</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="name" value="${custinfo.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="custinfo_btn" type="button" class="btn btn-default">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>