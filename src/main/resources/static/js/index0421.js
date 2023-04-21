//login.jsp

let login_form = {
    init:function (){
        $('#login_btn').click(function (){
            login_form.send();
        });
    },
    send:function (){
        $('#login_form').attr({
            'action':'/loginimpl', //form의 정보를 server의 application에 전달하세요
            'method':'get'
        });
        $('#login_form').submit();
    }
};


// register.jsp

let reg_form = {
    init:function (){
        $('#reg_btn').click(function (){
            reg_form.send();
        });
    },
    send:function (){
        $('#reg_form').attr({
            'action':'/registerimpl', //action하면 하게될 서버의 작업
            'method':'get'
        });
        $('#reg_form').submit();
    }
};


 // jsp01.jsp

let jsp01={
    data:0,
    init:function (num){
        // this.data = ${num};
        // 위의 표현을 보안을 강화하는 경우는 아래와 같이
        // this.data = '<c:out value="${num}"/>';
        this.data= num;
        this.display();
    },
    display:function (){
        $('#jsp01').text(this.data+'');
    }
};
