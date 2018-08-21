let express = require('express');
let bodyParser = require('body-parser');

let app = express();

app.use(bodyParser.json());

let shoppingList = [];
let id = 100;

app.get("/api/shopping", function(req,res) {
	console.log("GET ShoppingList. ShoppingList contents:");
	console.log(shoppingList);
	res.status(200).json(shoppingList);
});

app.post("/api/shopping", function(req,res) {
	console.log("POST ShoppingList. Body contents:");
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

app.delete("/api/shopping/:id", function(req,res) {
	console.log("DELETE ShoppingList. Id:");
	console.log(req.params.id);
	let tempId = req.params.id;
	let found = false;
	for(let i=0;i<shoppingList.length;i++) {
		if(shoppingList[i].id == tempId) {
			shoppingList.splice(i,1);
			found = true;
			break;
		}
	}
	if(found) {
		return res.status(200).json({"message":"success"});
	}
	return res.status(404).json({"message":"no such id"});
});

app.listen(3001);

console.log("Running in port 3001");