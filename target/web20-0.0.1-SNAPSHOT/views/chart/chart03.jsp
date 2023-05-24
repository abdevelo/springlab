<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script>
    let chart03 = {
        init: function () {
            this.getdata1();
            this.getdata2();
            this.getdata3();
        },
        getdata1: function () {
            $.ajax({
                url:'/chart0301',
                success:function (result){
                    chart03.display1(result);
                }
            })

        },
        getdata2: function () {
            $.ajax({
                url:'/chart0302',
                success:function (result2){
                    chart03.display2(result2);
                }
            })
        },
        getdata3: function () {
            $.ajax({
                url:'/chart0303',
                success:function (result3){
                    chart03.display3(result3);
                }
            })
        },
        display1: function (result) {
            // the start of chart code
            // Data retrieved from https://olympics.com/en/olympic-games/beijing-2022/medals
            Highcharts.chart('c1', {
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 45
                    }
                },
                title: {
                    text: 'Beijing 2022 gold medals by country',
                    align: 'left'
                },
                subtitle: {
                    text: '3D donut in Highcharts',
                    align: 'left'
                },
                plotOptions: {
                    pie: {
                        innerSize: 100,
                        depth: 45
                    }
                },
                series: [{
                    name: 'Medals',
                    data: result
                }]
            }); // the end of chart code

        },
        display2: function (result2) {

            Highcharts.chart('c2', {
                chart: {
                    type: 'cylinder',
                    options3d: {
                        enabled: true,
                        alpha: 15,
                        beta: 15,
                        depth: 50,
                        viewDistance: 25
                    }
                },
                title: {
                    text: 'Number of confirmed COVID-19'
                },
                subtitle: {
                    text: 'Source: ' +
                        '<a href="https://www.fhi.no/en/id/infectious-diseases/coronavirus/daily-reports/daily-reports-COVID19/"' +
                        'target="_blank">FHI</a>'
                },
                xAxis: {
                    categories: result2.age,
                    title: {
                        text: 'Age groups'
                    }
                },
                yAxis: {
                    title: {
                        margin: 20,
                        text: 'Reported cases'
                    }
                },
                tooltip: {
                    headerFormat: '<b>Age: {point.x}</b><br>'
                },
                plotOptions: {
                    series: {
                        depth: 25,
                        colorByPoint: true
                    }
                },
                series: [{
                    data: result2.data,
                    name: 'Cases',
                    showInLegend: false
                }]
            });

        },
        display3: function (result3) {

            Highcharts.chart('c3', {
                chart: {
                    type: 'area'
                },
                title: {
                    useHTML: true,
                    text: 'Countries/regions with highest Gt CO<sub>2</sub>-emissions',
                    align: 'left'
                },
                subtitle: {
                    text: 'Source: ' +
                        '<a href="https://energiogklima.no/klimavakten/land-med-hoyest-utslipp/"' +
                        'target="_blank">Energi og Klima</a>',
                    align: 'left'
                },
                accessibility: {
                    point: {
                        valueDescriptionFormat: '{index}. {point.category}, {point.y:,.1f} billions, {point.percentage:.1f}%.'
                    }
                },
                yAxis: {
                    labels: {
                        format: '{value}%'
                    },
                    title: {
                        enabled: false
                    }
                },
                tooltip: {
                    pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.percentage:.1f}%</b> ({point.y:,.1f} billion Gt)<br/>',
                    split: true
                },
                plotOptions: {
                    series: {
                        pointStart: 1990
                    },
                    area: {
                        stacking: 'percent',
                        marker: {
                            enabled: false
                        }
                    }
                },
                series: [{
                    name: 'China',
                    data: result3.china
                }, {
                    name: 'USA',
                    data: result3.usa
                }, {
                    name: 'EU',
                    data: result3.eu
                }, {
                    name: 'India',
                    data: result3.india
                }]
            });


        }
    }
    $(function(){
        chart03.init();
    });
</script>


<div class="col-sm-8 text-left">
    <div class="container">
        <h3>CHART03</h3>
        <div class="row">
            <div class="col-sm-4" id="c1">
            </div>
            <div class="col-sm-4" id="c2">
            </div>
            <div class="col-sm-4" id="c3">
            </div>
        </div>
    </div>
</div>