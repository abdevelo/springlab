<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<style>
    #map02 > #map {
        width : 400px;
        height : 400px;
        border : 2px solid red;
    }
</style>

<script>
    let map02 = {
        map:null,
        init: function () {

            this.display(); // 초기화면 : 성수동
            $('#s_btn').click(function () {
                map02.go(37.5857825,126.9828019 );
            });
            $('#b_btn').click(function () {
                map02.go(35.1883491,129.2233197);
            });
            $('#j_btn').click(function () {
                map02.go(33.2501708,126.5636786);
            });

        },
        display: function () {

            var mapContainer = document.querySelector('#map02 > #map');
            var mapOption = {
                center: new kakao.maps.LatLng(37.5456385, 127.0534575), // 지도의 중심좌표
                level: 5 // 지도의 확대 레벨
            };
            map = new kakao.maps.Map(mapContainer, mapOption);

            // map controller
            var mapTypeControl = new kakao.maps.MapTypeControl();
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            //map marker
            var markerPosition  = new kakao.maps.LatLng(37.5456385, 127.0534575);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);

        },
        go: function (lat,lng) {
            var moveLatLon = new kakao.maps.LatLng(lat, lng);
            map.panTo(moveLatLon);


            var markerPosition  = new kakao.maps.LatLng(lat, lng);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);

        },
    };
    $(function(){
        map02.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container" id="map02">
        <h3>MAP02</h3>
        <button id="s_btn" type="button" class="btn btn-success">Seoul</button>
        <button id="b_btn" type="button" class="btn btn-success">Busan</button>
        <button id="j_btn" type="button" class="btn btn-success">Jeju</button>
        <div id="map"></div>
    </div>
</div>