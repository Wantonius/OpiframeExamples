let express = require("express");
let bodyParser = require("body-parser");

let app = express();
app.use(bodyParser.json());

let shoppingItems = [];
let id = 100;
app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});
app.get("/api/shoppingitem", function(req,res) {
	console.log("Get all contacts");
	res.status(200).json(shoppingItems);
});

app.post("/api/shoppingitem", function(req,res) {
	let shoppingItem = {
		"type":req.body.type,
		"price":req.body.price,
		"count":req.body.count,
		"id":id
	}
	id++;
	shoppingItems.push(shoppingItem);
	console.log(shoppingItems);
	res.status(200).json({"message":"success"});
});

app.post("/api/shoppingitem/:id", function(req,res) {
	let tempId = req.params.id;
	for(let i=0; i<shoppingItems.length;i++) {
		if(tempId == shoppingItems[i].id) {
			shoppingItems.splice(i,1);
			return res.status(200).json({"message":"success"});
		}
		
	}
	return res.status(404).json({"message":"not found"});
});

app.listen(3001);

console.log("Running in port 3001");