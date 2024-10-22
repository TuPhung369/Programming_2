/**
 * First_WebApp_Examples.js
 */
 
 function getGreetingFromServer() {
	let url = "http://localhost:8080/First_WebApp_Examples/firstService";
	
    // Send a request to the server
    fetch(url)
    	// When the response is received, then we get the data as plain text from the response object
    	.then(response => response.text())
        // When the text is available, then we call another method which will display the text
        .then(greetingText => displayGreeting(greetingText));        
} 

function displayGreeting(greeting) { 
    let divOutput = document.getElementById("divOutput");

    divOutput.innerHTML = greeting;
} 

function clearGreeting() {
	document.getElementById("divOutput").innerHTML = "";
}





/* Some remarks...
1. The Fetch function is an asynchronous function. That is, the program execution does not stop and wait 
   for the server's response when we call the Fetch function. Instead, the program execution moves on 
   without waiting. The Fetch function will be waiting on the background until it gets a response
   from the server. When the response is received, JavaScript executes the operations that are specified
   using the ".then" syntax.
   
2. The lambda ('arrow function')
   	response => response.text()
	
	can alternatively be written as an anonymous function as follows:
	function (response) {
		return response.text()
	}

3. The lambda ('arrow function')
	greetingText => displayGreeting(greetingText)
	
	can alternatively be written as an anonymous function as follows:
	function (greetingText) {
		displayGreeting(greetingText);
	}
*/
