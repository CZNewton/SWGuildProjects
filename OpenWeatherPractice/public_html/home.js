/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("#findWeather").on("click", function() {
    
var zip = $("#zipcodeEntry").val();
var units = $("unitsEntry").val();

var ajaxBegin = {
        method: "GET",
        url: "api.openweathermap.org/data/2.5/weather?zip=" + zip +",us&APPID=2583577a7a47f99cba45d58f18abfd49",
        success: infobyZip,        //function on success
        error: function(){
            alert("Problem importing API Data");
        }
    };
    
var infobyZip = function(JSONInfo) {
    if(units==="metric") {
        var currentTemp = (JSONInfo.main.temp)-273.12;
        var tempMax = (JSONInfo.main.temp_max)-273.12;
        var tempMin = (JSONInfo.main.temp_min)-273.12;
    } else {
        var currentTemp = ((JSONInfo.main.temp)*(9/5))-459.67;
        var tempMax = ((JSONInfo.main.temp_max)*(9/5))-459.67;
        var tempMin = ((JSONInfo.main.temp_min)*(9/5))-459.67;
    }
        document.getElementById("#results").innerHTML = 
                "<h3>Area:         </h3>"   +   JSONInfo.name
            +   "<h3>Current Sky:  </h3>"   +   JSONInfo.weather[0].main
            +   "<h3>Temperature:  </h3>"   +   currentTemp
            +   "<h3>Today's High: </h3>"   +   tempMax
            +   "<h3>Today's Low:  </h3>"   +   tempMin;
    };
    
    $.get(ajaxBegin);
});

