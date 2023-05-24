<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    let chart05 = {
        init:function (){
            $('#get_btn').click(function (){
                var year = $('#sel1').val(); // select에있는 value를 가져와라
                chart05.getdata(year);
            });
        },
        getdata: function(year){
            $.ajax({
                url:'/chart05',
                data:{'year':year},
                success:function (result){
                    chart05.display1(result);
                    chart05.display2(result);
                }
            })
        },
        display1: function (result){
            // Data retrieved https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature
            Highcharts.chart('c1', {
                chart: {
                    type: 'spline'
                },
                title: {
                    text: 'Monthly Average Temperature'
                },
                xAxis: {
                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                        'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                    accessibility: {
                        description: 'Months of the year'
                    }
                },
                yAxis: {
                    title: {
                        text: 'Temperature'
                    },
                    labels: {
                        formatter: function () {
                            return this.value + '°';
                        }
                    }
                },
                tooltip: {
                    crosshairs: true,
                    shared: true
                },
                plotOptions: {
                    spline: {
                        marker: {
                            radius: 4,
                            lineColor: '#666666',
                            lineWidth: 1
                        }
                    }
                },
                series: [{
                    name: 'Tokyo',
                    marker: {
                        symbol: 'square'
                    },
                    data:result
                }]
            }); // the end of chart source


        },
        display2: function (result){

            Highcharts.chart('c2', {
                chart: {
                    type: 'column',
                    options3d: {
                        enabled: true,
                        alpha: 10,
                        beta: 25,
                        depth: 70
                    }
                },
                title: {
                    text: 'External trade in goods by country, Norway 2021',
                    align: 'left'
                },
                subtitle: {
                    text: 'Source: ' +
                        '<a href="https://www.ssb.no/en/statbank/table/08804/"' +
                        'target="_blank">SSB</a>',
                    align: 'left'
                },
                plotOptions: {
                    column: {
                        depth: 25
                    }
                },
                xAxis: {
                    categories: ['Belgium', 'China', 'Denmark', 'Fiji', 'Germany', 'Netherlands', 'Russia',
                        'Sweden', 'Turkey', 'United States', 'Unspecified', 'Vietnam'],
                    labels: {
                        skew3d: true,
                        style: {
                            fontSize: '16px'
                        }
                    }
                },
                yAxis: {
                    title: {
                        text: 'NOK (million)',
                        margin: 20
                    }
                },
                tooltip: {
                    valueSuffix: ' MNOK'
                },
                series: [{
                    name: 'Total imports',
                    data: result
                }]
            }); //the end of chart code
        }
    }
    $(function(){
        chart05.init();
    });
</script>


<div class="col-sm-8 text-left">
    <div class="container">
        <h3>CHART05</h3>
        <div class="form-group col-sm-2">
            <label for="sel1">Select list (select one):</label>
            <select class="form-control" id="sel1">
<%--                연도를 일일히 입력할 필요없음--%>
                <c:forEach begin="2010" end="2020" var="year">
                    <option value="${year}">${year}</option>
                </c:forEach>
            </select>
            <button id="get_btn">GET THIS YEAR</button>
        </div>
        <div class="row">
            <div class="col-sm-4" id="c1"></div>
            <div class="col-sm-4" id="c2"></div>
        </div>
    </div>
</div>