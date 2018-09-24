let express = require("express");

let apiRouter = express.Router();
let carList = [];
let id = 100;

apiRouter.get("/carlist", function(req,res) {
	return res.status(200).json(carList);
});

apiRouter.post("/carlist", function(req,res) {
	let car = {
		"id":id,
		"type":req.body.type,
		"price":req.body.price
	}
	carList.push(car);
	id++;
	return res.status(200).json({"message":"success"});
});

apiRouter.delete("/carlist/:id", function(req,res) {
	let id = req.params.id;
	for(let i=0;i<carList.length;i++) {
		if(id == carList[i].id) {
			carList.splice(i,1);
			return res.status(200).json({"message":"success"});
		}
	}
	return res.status(404).json({"message":"not found"});
})

module.exports = apiRouter;