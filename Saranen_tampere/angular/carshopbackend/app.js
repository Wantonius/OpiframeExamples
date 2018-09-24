let express = require("express");
let bodyParser = require("body-parser");
let apiRouter = require("./backend/apiRouter");

let app = express();

let loggedUsers = [];
let registeredUsers = [];

app.use(bodyParser.json());

function isUserLogged(req,res,next) {
	console.log(req.headers);
	if(!req.headers.token) {
		return res.status(403).json({"message":"not allowed"});		
	}
	let token = req.headers.token;	
	for(let i=0;i<loggedUsers.length;i++) {
		if(token === loggedUsers[i].token) {
			return next();
		}
	}		
	return res.status(403).json({"message":"not allowed"});
}

app.post("/login", function(req,res) {
	let user = {
		"username":req.body.username,
		"password":req.body.password
	}
	for(let i=0;i<registeredUsers.length;i++) {
		if(user.username === registeredUsers[i].username) {
			if(user.password === registeredUsers[i].password) {
				let token = "token123";
				loggedUsers.push({"username":user.username,"token":token});
				return res.status(200).json({"token":token});
			}
		}
	}
	return res.status(403).json({"message":"wrong credentials"});
});

app.post("/register", function(req,res) {
	if(!req.body || !req.body.username || !req.body.password) {
		return res.status(409).json({"message":"provide credentials"});
	}
	if(req.body.username.length === 0 || req.body.password.length === 0) {
		return res.status(409).json({"message":"provide credentials"});
	}
	for(let i=0;i<registeredUsers.length;i++) {
		if(req.body.username === registeredUsers[i].username) {
			return res.status(409).json({"message":"username already is use"})
		}
	}
	let user = {
		"username":req.body.username,
		"password":req.body.password
	}
	registeredUsers.push(user);
	return res.status(200).json({"message":"success"});

});

app.use("/api",isUserLogged,apiRouter);
app.listen(3000);
console.log("Running on port 3000");