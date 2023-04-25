<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<style>
    #map03 > #map {
        width : 550px;
        height : 400px;
        border : 2px solid greenyellow;
    }
</style>
<script>
    let map03 = {
        map:null,
        init: function () {

            this.display(); // 초기화면 : 성수동
            $('#s_btn').click(function () {
                map03.go(37.5857825,126.9828019,'s' );
            });
            $('#b_btn').click(function () {
                map03.go(35.1883491,129.2233197,'b');
            });
            $('#j_btn').click(function () {
                map03.go(33.2501708,126.5636786,'j');
            });

        },
        display: function () {

            var mapContainer = document.querySelector('#map03 > #map');
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
        go: function (lat,lng,loc) {
            var moveLatLon = new kakao.maps.LatLng(lat, lng);
            map.panTo(moveLatLon);

            var markerPosition  = new kakao.maps.LatLng(lat, lng);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);
            map03.markers(loc); // loc 정보로 -> marker를 받고자 요청
        },

        markers:function (loc){
            $.ajax({
                url:'/markers',
                data:{'loc': loc},
                success: function (data) {
                    map03.displaymarkers(data);
                },
            });
        },
        displaymarkers:function (positions) {
            var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
            for (var i = 0; i < positions.length; i++) {
                var imageSize = new kakao.maps.Size(20, 30);
                var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
                var markerPosition = new kakao.maps.LatLng( positions[i].lat, positions[i].lng);

                var marker = new kakao.maps.Marker({
                    map: map,
                    position : markerPosition,
                    title : positions[i].title,
                    image : markerImage
                });
                // infoWindow
                var iwContent = '<h2>'+positions[i].title+'</h2>';
                iwContent += '<img src="/img/'+positions[i].img+'" style="width:50px">';

                var infowindow = new kakao.maps.InfoWindow({
                    // position : positions[i].latlng,
                    position : markerPosition,
                    content : iwContent
                });

                kakao.maps.event.addListener(marker, 'mouseover', mouseoverListener(marker, infowindow));
                kakao.maps.event.addListener(marker, 'mouseout', mouseoutListener(marker, infowindow));
                kakao.maps.event.addListener(marker, 'click', mouseclickListener(positions[i].target));


                function mouseoverListener(marker, infowindow) {
                    return function(){
                        infowindow.open(map, marker);
                    };
                }
                function mouseoutListener(marker, infowindow) {
                    return function(){
                        infowindow.close();
                    };
                }
                function mouseclickListener(target) {
                    return function(){
                        location.href = target;
                    };
                }

            } // end for


        }

    };
    $(function(){
        map03.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container" id="map03">
        <h3>MAP03</h3>
        <button id="s_btn" type="button" class="btn btn-success">Seoul</button>
        <button id="b_btn" type="button" class="btn btn-success">Busan</button>
        <button id="j_btn" type="button" class="btn btn-success">Jeju</button>
        <div id="map"></div>
    </div>
</div>