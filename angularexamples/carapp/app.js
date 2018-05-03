const express = require("express");
const bodyParser = require("body-parser");
const path = require("path");
let app = express();

app.use(bodyParser.json());

app.use(express.static(path.join(__dirname,"public")));

let dataList = [];
let id = 0;
app.get("/api/data", function(req,res) {
	console.log("Get List")
	res.status(200).json(dataList);
});

app.post("/api/data", function(req,res) {
	console.log("Add Car:"+req.body.type);
	let car = {
		"id":id,
		"type":req.body.type,
		"price":req.body.price
	}
	id++;
	dataList.push(car);
	res.status(200).json(car)
});

app.delete("/api/data/:id", function(req,res) {
	console.log("Delete id:"+req.params.id);
	let id = req.params.id;
	for (i=0;i<dataList.length;i++) {
		if (dataList[i].id == id) {
			dataList.splice(i,1);
			return res.status(200).json({"message":"success"});
		}
		
	}
	res.status(404).json({"message":"not found"});
});

app.listen(3000);