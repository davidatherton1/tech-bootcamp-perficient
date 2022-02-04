// $("#addStudio").submit(function(event){
//     event.preventDefault();
//     let studioName = document.getElementById("studioName").value;
//     console.log(studioName);
//     $.post("http://localhost:8080/addStudio", {name: studioName});
// })

function addStudio(){
    let studioName = document.getElementById("studioName").value;
    console.log(studioName);
    $.post("http://localhost:8080/addStudio", {name: studioName});
}

// $("#addMovie").submit(function(event){
//     event.preventDefault();
//     let movieName = document.getElementById("movieName").value;
//     let releaseYear = document.getElementById("releaseYear").value;
//     let director = document.getElementById("director").value;
//     let studio = document.getElementById("movieStudio").value;
//     $.post("http://localhost:8080/addMovie",
//         {title: movieName,
//         releaseYear: releaseYear,
//         director: director,
//         studio: studio});
// })

function addMovie(){
    let movieName = document.getElementById("movieName").value;
    let releaseYear = document.getElementById("releaseYear").value;
    let director = document.getElementById("director").value;
    let studio = document.getElementById("movieStudio").value;
    $.post("http://localhost:8080/addMovie",
        {title: movieName,
            releaseYear: releaseYear,
            director: director,
            studio: studio});
}

$.get("http://localhost:8080/studios", function(data){
    console.log("looking for studios");
    console.log(data)
    data.forEach(element => {
        let table = "<tr><td>" + element.name + "</td></tr>";
        document.getElementById("studioTable").innerHTML += table;
    });
})

$.get("http://localhost:8080/studios", function(data){
    let selectElement = document.getElementById("movieStudio");
    data.forEach(element => {
        selectElement.add(new Option(element.name, element.name));
    })
})

$.get("http://localhost:8080/movies", function(data){
    data.forEach(element => {
        let table = "<tr><td>" + element.title + "</td>" +
        "<td>" + element.releaseYear + "</td>" +
        "<td>" + element.director + "</td>" +
        "<td>" + element.studioName + "</td></tr>";
        console.log(element.studio);
        document.getElementById("movieTable").innerHTML += table;
    });
})
