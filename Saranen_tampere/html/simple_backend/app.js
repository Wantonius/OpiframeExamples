const express = require("express");
const bodyParser = require("body-parser");

let app = express();

app.use(bodyParser.json());
app.use(express.static(__dirname+"/public_www"));

let shoppingList = [];
let id = 100;

app.get("/api/shoppinglist", function(req,res) {
	console.log("GET shoppingList");
	console.log(shoppingList);
	res.status(200).json(shoppingList);
});

app.post("/api/shoppinglist", function(req,res) {
	console.log("POST shoppingList");
	console.log(req.body);
	let item = {
		"id":id,
		"type":req.body.type,
		"count":req.body.count,
		"price":req.body.price
	}
	id++;
	shoppingList.push(item);
	res.status(200).json({"message":"success"});
});

app.delete("/api/shoppinglist/:id", function(req,res) {
	console.log("DELETE shoppingList id:"+req.params.id);
	let tempId = req.params.id;
	for(let i=0;i<shoppingList.length;i++) {
		if(shoppingList[i].id == tempId) {
			shoppingList.splice(i,1);
			return res.status(200).json({"message":"success"});
		}
	}
	return res.status(404).json({"message":"not found"});
});
app.listen(8080);
console.log("Running in port 8080");