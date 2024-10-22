/*
*  movieList.js (This is the simple ES6 compliant version with no error handling) 
*/

function main() { 

    // Send a request to the server
    fetch("http://localhost:8080/First_WebApp_Examples/movies")
        // Convert the server's JSON response to a JavaScript object
        .then(response => response.json())     
        // Call the method which will display the data
        .then(movieList => printMovies(movieList));        
} 

function printMovies(movieList) { 
    let divOutput = document.getElementById("divOutput");
    let outputText = "";
    
    for (let movie of movieList) { 
        outputText += movie.name + " (" + movie.year + ")<br/>"; 
    } 
    
    divOutput.innerHTML = outputText;
}  

// Call the main function when the browser loads the HTML page
main(); 

// End