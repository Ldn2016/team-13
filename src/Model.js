var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        var response_text = xhttp.response;
        window.alert(response_text);
    }
};

xhttp.open("GET", "https://graph.facebook.com/me?limit=100&access_token=EAACEdEose0cBAL2BW3U7IkkVkxZAZBQF4ygU6rbQDzTMZCd0ZCKOt9RIHW4oqrOxUEAGqNHpejIUGZAh2sV70IXcifSyAFGBNNoCZBVB2v4aKWuy0w1MaZCdfGknA41bktQcI3PkNiCKXDp3DRM8wGpzYDZBFd6lVPtvG2czobBB0Y3wy3FhZCPG7", true);
xhttp.send();
