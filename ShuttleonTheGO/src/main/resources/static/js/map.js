var map,infoWindow;
function initMap() {
    var options = {
        center: {lat: 36.8480, lng: -76.2621},
        zoom: 15
    };

    map = new google.maps.Map(document.getElementById('map'), options)


    infoWindow = new google.maps.InfoWindow;


    if(navigator.geolocation){
        navigator.geolocation.getCurrentPosition(function (p){
            var position = {
                lat: p.coords.latitude,
                lng:p.coords.longitude
            };
            infoWindow.setPosition(position);
            infoWindow.setContent("Your location!");
            infoWindow.open(map);

        }, function (){
            handleLocationError("Geolocation service failed", map.center())
        })

    }else{
        handleLocationError("No geolocation available", map.center());
    }
}

function handleLocationError(content,position){
    infoWindow.setPosition(position);
    infoWindow.setContent(content);
    infoWindow.open(map);
}


