<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    // register.jsp
    let register_form = {
        init:function (){
            $('#register_btn').addClass('disabled');

            $('#register_btn').click(function (){
                register_form.send();
            });

            $('#name').keyup(function (){
                let id = $('#id').val();
                let pwd = $('#pwd').val();
                let name = $('#name').val();
                if( id != '' && pwd != '' && name !=''){
                    $('#register_btn').removeClass('disabled');
                }
            });
            $('#id').keyup(function (){
                let txt_id = $(this).val(); // input태그(명:id)에 입력된 값
                if(txt_id.length <= 3){
                    return;
                } // 그 값의 길이가 3자리가 안되면 여기서 끝
                $.ajax({ // id를 서버에 보내기
                    url :'/checkid',
                    data:{'id':txt_id}, //id라는 이름으로 id 값을 전송하겠다
                    success:function (result){
                        if(result == 0){
                            $('#check_id').text('사용가능합니다.');
                            $('#pwd').focus();
                        }else{
                            $('#check_id').text('사용불가능합니다.');
                        }
                    }
                });
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

            $('#register_form').attr({
                'action':'/registerimpl', //action하면 하게될 서버의 작업
                'method':'post'
            });
            $('#register_form').submit();
        }
    };


    $(function (){
        register_form.init();
    });

</script>



<div class="col-sm-8 text-left">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6  text-left ">
                <h1>Register Page</h1>
                <form id="register_form" class="form-horizontal well">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="id">ID:</label>
                        <div class="col-sm-10">
                            <input type="text" name="id" class="form-control" id="id" placeholder="Enter id">
                        </div>
                        <div class="col-sm-10">
                            <span id="check_id" class="bg-danger"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                        <div class="col-sm-10">
                            <input type="password" name="pwd" class="form-control" id="pwd" placeholder="Enter password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="name">NAME:</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="name" placeholder="Enter name">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="register_btn" type="button" class="btn btn-primary">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>