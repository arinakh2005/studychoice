function show() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var city = JSON.parse(this.responseText);
            document.querySelector("#city").innerHTML = city.name;
        } else
            if (this.readyState == 4 && this.status != 200){
                alert('ERROR!');
        }
    };
    xhttp.open("GET", "/city", true);
    xhttp.send();
}