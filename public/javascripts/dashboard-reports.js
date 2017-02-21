$(document).ready(function() {
    $.ajax({
//        url: "http://epgm-webapp.centralindia.cloudapp.azure.com:8080/epgm/dashboard/27"
    url: "http://epgm-webapp.cloudapp.net:8080/epgm/dashboard/27"
    }).then(function(data) {

/*    countUp(data.grade_data.total);
    countUp2(data.grade_data.severe);
    countUp3(data.grade_data.moderate);
    countUp4(data.grade_data.normal);*/

    $('.count').text(data.grade_data.total)
    $('.count2').text(data.grade_data.severe)
    $('.count3').text(data.grade_data.moderate)
    $('.count4').text(data.grade_data.normal)

    new Chart(document.getElementById("doughnut").getContext("2d")).Doughnut(data.gender_data);
    new Chart(document.getElementById("polarArea").getContext("2d")).PolarArea(data.age_data);
    new Chart(document.getElementById("bar").getContext("2d")).Bar(data.month_data);
    });
});