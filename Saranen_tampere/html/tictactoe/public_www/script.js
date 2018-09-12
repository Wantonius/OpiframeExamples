var inputs = [];
var gameBoard = [0,0,0,0,0,0,0,0,0];
var turn = 0;
var lastWinner = "none";
var gamesPlayed = 0;
window.onload = function() {
	for(let i=0;i<9;i++) {
		let tempId = "input"+i;
		let temp = document.getElementById(tempId);
		inputs.push(temp);
	}
	lastWinner = localStorage.getItem("lastWinner");
	gamesPlayed = localStorage.getItem("gamesPlayed");
	let message = document.getElementById("message");
	message.innerHTML = "Last Winner was "+lastWinner+" Games played:"+gamesPlayed;
};

function onChangeEvent(event) {
	let tempkey = event.key;
	if(event.key === "o" || event.key === "x") {
		if(tempkey === "x" && turn === 1) {
			alert("O's turn");
			event.target.value = "";
			return;
		}
		if(tempkey === "o" && turn === 0) {
			alert("X's turn");
			event.target.value = "";
			return;
		}
		let currentPlayer;
		if(turn) {
			currentPlayer = "o";
			turn = 0;
		} else {
			currentPlayer = "x";
			turn = 1;
		}
		let targetid = parseInt(event.target.id[5]);
		inputs[targetid].setAttribute("readonly",true);
		gameBoard[targetid] = tempkey;
		if(gameBoard[0] === tempkey && gameBoard[1] === tempkey && gameBoard[2]===tempkey) {
			winGame(currentPlayer);
		}
		if(gameBoard[3] === tempkey && gameBoard[4] === tempkey && gameBoard[5]===tempkey) {
			winGame(currentPlayer);
		}
		if(gameBoard[6] === tempkey && gameBoard[7] === tempkey && gameBoard[8]===tempkey) {
			winGame(currentPlayer);
		}
		if(gameBoard[0] === tempkey && gameBoard[3] === tempkey && gameBoard[6]===tempkey) {
			winGame(currentPlayer);
		}
		if(gameBoard[1] === tempkey && gameBoard[4] === tempkey && gameBoard[7]===tempkey) {
			winGame(currentPlayer);
		}		
		if(gameBoard[2] === tempkey && gameBoard[5] === tempkey && gameBoard[8]===tempkey) {
			winGame(currentPlayer);
		}
		if(gameBoard[0] === tempkey && gameBoard[4] === tempkey && gameBoard[8]===tempkey) {
			winGame(currentPlayer);
		}
		if(gameBoard[2] === tempkey && gameBoard[4] === tempkey && gameBoard[6]===tempkey) {
			winGame(currentPlayer);
		}		
	} else {
		console.log("wrong key");
		event.target.value = "";
		alert("Use 'x' and 'o'");
	}
	
}

function winGame(winner) {
	alert(winner+" wins!");
	lastWinner = winner;
	gamesPlayed++;
	localStorage.setItem("lastWinner", lastWinner);
	localStorage.setItem("gamesPlayed", gamesPlayed);
	let message = document.getElementById("message");
	message.innerHTML = "Last winner was "+winner+" Games Played:"+gamesPlayed; 
	clearGame();
}

function clearGame() {
	gameBoard = [0,0,0,0,0,0,0,0,0];
	turn = 0;
	for(let i = 0; i<9; i++) {
		inputs[i].value = "";
		inputs[i].removeAttribute("readonly");
	}
}