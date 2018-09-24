var Student = /** @class */ (function () {
    function Student(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }
    Student.prototype.getFullname = function () {
        return this.fullName;
    };
    return Student;
}());
var student1 = new Student("Jaska", "Jokunen");
document.getElementById("messageBody").innerHTML = student1.getFullname();
