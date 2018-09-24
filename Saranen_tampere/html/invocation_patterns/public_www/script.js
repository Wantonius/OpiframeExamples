window.onload = function() {
console.log("--------------------------------");	
console.log("Method invocation pattern");
var person = {
    name: 'Calvin',
    age: 25,
    greet: function () {
        console.log('My name is ' + this.name + '.');
    }
};
person.greet(); 

console.log("--------------------------------");
console.log("Function invocation pattern")





person.calculateAge = function (yearsFromNow) {
    var self = this;

    function yearsOld() {
        return self.age + yearsFromNow;
    }

    console.log('I will be ' + yearsOld() + ' years old ' + yearsFromNow + ' years from now.');
}
person.calculateAge(10);







console.log("--------------------------------");
console.log("Same but with this and things go wrong");

person.calculateAge = function (yearsFromNow) {	
    function yearsOld() {
        return this.age + yearsFromNow;
    }

    console.log('I will be ' + yearsOld() + ' years old ' + yearsFromNow + ' years from now.');
}
person.calculateAge(10);





console.log("--------------------------------");
console.log("Constructor invocation pattern");

var person2 = function (name) {
    this.name = name;
};

person2.prototype.greet = function () {
    return this.name + ' says hi.';
};

console.log(new person2('Calvin').greet());






console.log("--------------------------------");
console.log("Apply invocation pattern");

person2.prototype.waveTo = function(who) {
	return this.name+" waves to "+who.name;
}

let calvin = new person2('Calvin');
let hobbes = new person2('Hobbes');
let test = Object.create({"name":"Blaah"});

console.log(calvin.waveTo.apply(hobbes,[calvin]));
console.log(calvin.waveTo.apply(test,[calvin]));
}