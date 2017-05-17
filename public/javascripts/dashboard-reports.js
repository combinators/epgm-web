$(document).ready(function() {
    populateDashboard();
});

function getUrl(){
    return "http://epgm-webapp.cloudapp.net:8080/epgm/dashboard/27";
    //return "http://localhost:8080/epgm/dashboard/27";
}

function populateMonth(data){
    var code = "01";
    if(data == "JANUARY") {code = "01"}
    if(data == "FEBRUARY") {code = "02"}
    if(data == "MARCH") {code = "03"}
    if(data == "APRIL") {code = "04"}
    if(data == "MAY") {code = "05"}
    if(data == "JUNE") {code = "06"}
    if(data == "JULY") {code = "07"}
    if(data == "AUGUST") {code = "08"}
    if(data == "SEPTEMBER") {code = "09"}
    if(data == "OCTOBER") {code = "10"}
    if(data == "NOVEMBER") {code = "11"}
    if(data == "DECEMBER") {code = "12"}

     $('#monthfilter').val(code);
}

function populateDashboard(){
    callDashboardService(getUrl())
}

function loadDashboard(data){
    $('.count').text(data.grade_data.total).css("color", "black");
    $('.count2').text(data.grade_data.severe).css("color", "black");
    $('.count3').text(data.grade_data.moderate).css("color", "black");
    $('.count4').text(data.grade_data.normal).css("color", "black");
    $('.last-modified').text(data.lastmodified);
    populateMonth(data.lastmodified.split(",")[0]);


    new Chart(document.getElementById("doughnut").getContext("2d")).Doughnut(data.gender_data);
    new Chart(document.getElementById("polarArea").getContext("2d")).PolarArea(data.age_data);
    new Chart(document.getElementById("bar").getContext("2d")).Bar(data.month_data);
}

function populateDashboardSpecificMonth(month){
    callDashboardService(getUrl()+"/"+month.value)
}

function callDashboardService(url){
    $.ajax({
    url: url
    }).then(function(data) {
        loadDashboard(data)
    });
}