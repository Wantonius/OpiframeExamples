var isClicked = 0;
function myClick() {
	if(isClicked) {
		document.getElementById("header").className = "normal";
		isClicked = 0;
	} else {
 	document.getElementById("header").className = "clicked";
		isClicked = 1;
		}
	console.log("myClick isClicked:"+isClicked);
	}
function mouseIn() {
	document.getElementById("header").className = "hover";
}
function mouseOut() {
	if(isClicked) {	
		document.getElementById("header").className = "clicked";

	} else {
		document.getElementById("header").className = "normal"

	}
	console.log("mouseOut isClicked:"+isClicked)
}