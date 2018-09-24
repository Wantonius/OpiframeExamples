class Student {
	fullName:string;
	constructor(public firstName:string, public lastName:string){
		this.fullName = firstName+" "+lastName;
	}
	
	getFullname() {
		return this.fullName;
	}
}

let student1 = new Student("Jaska", "Jokunen");

document.getElementById("messageBody").innerHTML = student1.getFullname();
