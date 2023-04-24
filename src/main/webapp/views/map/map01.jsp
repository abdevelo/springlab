<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    /*지도를 뿌리는 영역은 반드시 가로 세로 너비를 지정해주어야 한다*/
    #map01 > #map {
        width : 400px;
        height : 400px;
        border : 2px solid red;
    }
</style>

<script>
    let map01 = {
        map : null,
        init:function (){ //초기화가되면(화면이 준비되면) 지도를 출력
            var mapContainer = document.querySelector('#map');
            var mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };
            map = new kakao.maps.Map(mapContainer, mapOption);

            // map controller
            var mapTypeControl = new kakao.maps.MapTypeControl();
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);


            //map marker
            var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);


            // marker + event window
            var iwContent = '<img src="/img/a.jpg" style="width:80px"><div style="padding:5px;">Hello Pants!</div>';
            var infowindow = new kakao.maps.InfoWindow({
                content : iwContent
            });
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                infowindow.open(map, marker);
            });
            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });
            kakao.maps.event.addListener(marker, 'click', function() {
                location.href='http://www.nate.com';
            });
        }
    };
    $(function(){
        map01.init();
    });
</script>


<div class="col-sm-8 text-left">
    <div class="container" id="map01">
        <h3>MAP01</h3>
        <div id="map"> </div>
    </div>
</div>