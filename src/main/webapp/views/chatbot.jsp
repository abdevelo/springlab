<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
  #all {
    width: 400px;
    height: 200px;
    overflow: auto;
    border: 2px solid red;
  }

  #me {
    width: 400px;
    height: 200px;
    overflow: auto;
    border: 2px solid blue;
  }

  #to {
    width: 400px;
    height: 200px;
    overflow: auto;
    border: 2px solid green;
  }
</style>

<script>
  let websocket = {
    id:null,
    stompClient:null,
    init:function(){
      this.id = $('#adm_id').text();
      $("#connect").click(function() {
        websocket.connect();
      });
      $("#disconnect").click(function() {
        websocket.disconnect();
      });
      $("#sendme").click(function() {
        websocket.sendMe();
      });
    },
    connect:function(){
      var sid = this.id;
      var socket = new SockJS('${adminserver}/chbot'); //chbot으로 접속
      this.stompClient = Stomp.over(socket);
// Stomp.over(socket)은 주어진 websocket 객체(socket)를 기반으로
// 새로운 STOMP 클라이언트를 생성

      this.stompClient.connect({}, function(frame) {
        websocket.setConnected(true);
        console.log('Connected: ' + frame);


        this.subscribe('/chsend/'+sid, function(msg) {

          $("#me").prepend(
                  "<h4>" + "Chat기pt" +":"+
                  JSON.parse(msg.body).content1+ "</h4>");
        });


      });
    },
    disconnect:function(){ // disconnect 인지 확인 후 행동
      if (this.stompClient !== null) {
        this.stompClient.disconnect();
      }
      websocket.setConnected(false);
      console.log("Disconnected");
    },
    setConnected:function(connected){ // connected 인지 disconnected 인지 화면에 보여주는 역할
      if (connected) {
        $("#status").text("Connected");
      } else {
        $("#status").text("Disconnected");
      }
    },
    sendMe:function(){
      var msg = JSON.stringify({
        'sendid' : this.id,
        'content1' : $('#metext').val()
      });
      this.stompClient.send("/chatbotme", {}, msg);
      $('#me').prepend(
              '<h4>'+this.id+':'+$('#metext').val()+'</h4>'
            );
      $('#metext').val('');
    }
  };


  $(function(){
    websocket.init();
  })

</script>
<!-- Begin Page Content -->
<div class="col-sm-8 text-left">
        <H1>CHATBOT</H1>

        <h1 id="adm_id">${logincust.id}</h1>
        <H1 id="status">Status</H1>
        <button id="connect">Connect</button>
        <button id="disconnect">Disconnect</button>

        <h3>Me</h3>
        <input type="text" id="metext"><button id="sendme">Send</button>
        <div id="me"></div>

</div>