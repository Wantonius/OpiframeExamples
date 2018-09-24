const express = require("express");

let app = express();

app.use(express.static(__dirname+"/public_www"));

app.listen(8080);

console.log("Running in port 8080");