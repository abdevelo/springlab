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

 // ajax01.jsp

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
