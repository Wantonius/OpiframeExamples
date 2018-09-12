getShoppingList = () => {
	let request = {
		method:"GET",
		mode:"cors",
		headers:{"Content-Type":"application/json"}
	}
	fetch("/api/shoppinglist",request).then((response) => {
		if(response.ok) {
			response.json().then((data) => {
				console.log(data);
				populateTable(data);
			}).catch((error) => {
				console.log(error);
			});
		} else {
			console.log("response not ok");
		}
	}).catch((error) => {
		console.log(error);
	});
}

addToList = (event) => {
	event.preventDefault();
	console.log("Moi!");
	let typeinput = document.getElementById("typeinput");
	let countinput = document.getElementById("countinput");
	let priceinput = document.getElementById("priceinput");
	let shoppingItem = {
		"type":typeinput.value,
		"count":countinput.value,
		"price":priceinput.value
	}
	let request = {
		method:"POST",
		mode:"cors",
		headers:{"Content-Type":"application/json"},
		body:JSON.stringify(shoppingItem)
	}
	fetch("/api/shoppinglist", request).then((response) => {
		if(response.ok) {
			console.log("Response ok");
			getShoppingList();
		} else {
			console.log("Response not ok");
		}
	}).catch((error) => {
		throw Error(error);
	});
}

removeFromList = (event) => {
	console.log(event.target.id);
		let request = {
		method:"DELETE",
		mode:"cors",
		headers:{"Content-Type":"application/json"}
	}
	let url = "/api/shoppinglist/"+event.target.id;
	fetch(url,request).then((response) => {
		if(response.ok) {
			response.json().then((data) => {
				console.log(data);
				getShoppingList();
			}).catch((error) => {
				console.log(error);
			});
		} else {
			console.log("response not ok");
		}
	}).catch((error) => {
		console.log(error);
	});
}

populateTable = (data) => {
	let table = document.getElementById("shoppinglist");
	let container = document.getElementById("container");
	container.removeChild(table);
	let newTable = document.createElement("table");
	let header = document.createElement("tr");
	let typeheader = document.createElement("th");
	let typeHeaderInfo = document.createTextNode("Type");
	typeheader.appendChild(typeHeaderInfo);
	let countheader = document.createElement("th");
	let countHeaderInfo = document.createTextNode("Count");
	countheader.appendChild(countHeaderInfo);
	let priceheader = document.createElement("th");
	let priceHeaderInfo = document.createTextNode("Price");
	priceheader.appendChild(priceHeaderInfo);
	let idheader = document.createElement("th");
	let idHeaderInfo = document.createTextNode("ID");
	idheader.appendChild(idHeaderInfo);	
	let removeHeader = document.createElement("th");
	let removeHeaderInfo = document.createTextNode("Remove");
	removeHeader.appendChild(removeHeaderInfo);
	header.appendChild(typeheader);
	header.appendChild(countheader);
	header.appendChild(priceheader);
	header.appendChild(idheader);
	header.appendChild(removeHeader);
	newTable.appendChild(header);
	newTable.setAttribute("id","shoppinglist");
	for(let i=0;i<data.length;i++) {
		let tempRow=document.createElement("tr");
		let typeColumn = document.createElement("td");
		let typeInfo = document.createTextNode(data[i].type);
		typeColumn.appendChild(typeInfo);
		let countColumn = document.createElement("td");
		let countInfo = document.createTextNode(data[i].count);
		countColumn.appendChild(countInfo);
		let priceColumn = document.createElement("td");
		let priceInfo = document.createTextNode(data[i].price);
		priceColumn.appendChild(priceInfo);
		let idColumn = document.createElement("td");
		let idInfo = document.createTextNode(data[i].id);
		idColumn.appendChild(idInfo);
		let removeColumn = document.createElement("td");
		let removeButton = document.createElement("button");
		let buttonText = document.createTextNode("Remove");
		removeButton.appendChild(buttonText);
		removeButton.setAttribute("id",data[i].id);
		removeButton.addEventListener("click", function(e) {
			removeFromList(e);
		});
		removeColumn.appendChild(removeButton);
		tempRow.appendChild(typeColumn);
		tempRow.appendChild(countColumn);
		tempRow.appendChild(priceColumn);
		tempRow.appendChild(idColumn);
		tempRow.appendChild(removeColumn);
		newTable.appendChild(tempRow);
	}
	container.appendChild(newTable);
}