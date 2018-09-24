import {Component} from '@angular/core'

@Component({
	selector:"person-list",
	templateUrl:"personlist.component.html"
})
export class PersonList{
	dataList = [
	{
		"firstName": "George",
		"lastName": "Rich"
	},
	{
		"firstName": "Boris",
		"lastName": "Hill"
	},
	{
		"firstName": "Urielle",
		"lastName": "Goodwin"
	},
	{
		"firstName": "Baker",
		"lastName": "Weaver"
	},
	{
		"firstName": "Hyacinth",
		"lastName": "Whitley"
	},
	{
		"firstName": "Ryan",
		"lastName": "Robinson"
	},
	{
		"firstName": "Hedley",
		"lastName": "Newman"
	},
	{
		"firstName": "Urielle",
		"lastName": "Tillman"
	},
	{
		"firstName": "Dylan",
		"lastName": "Stanton"
	},
	{
		"firstName": "Hop",
		"lastName": "Bartlett"
	},
	{
		"firstName": "Maris",
		"lastName": "Harding"
	},
	{
		"firstName": "Theodore",
		"lastName": "Macias"
	},
	{
		"firstName": "Blake",
		"lastName": "Henry"
	},
	{
		"firstName": "Mary",
		"lastName": "Higgins"
	},
	{
		"firstName": "Edward",
		"lastName": "Nolan"
	},
	{
		"firstName": "Serena",
		"lastName": "Newman"
	},
	{
		"firstName": "Isabella",
		"lastName": "Leonard"
	},
	{
		"firstName": "Cruz",
		"lastName": "Byers"
	},
	{
		"firstName": "Wilma",
		"lastName": "Mcdonald"
	},
	{
		"firstName": "Iris",
		"lastName": "Ramos"
	},
	{
		"firstName": "Declan",
		"lastName": "Langley"
	},
	{
		"firstName": "Boris",
		"lastName": "Villarreal"
	},
	{
		"firstName": "Jemima",
		"lastName": "Bird"
	},
	{
		"firstName": "Upton",
		"lastName": "Dejesus"
	},
	{
		"firstName": "Lester",
		"lastName": "Butler"
	},
	{
		"firstName": "Hu",
		"lastName": "Gill"
	},
	{
		"firstName": "Denton",
		"lastName": "Townsend"
	},
	{
		"firstName": "Steven",
		"lastName": "Yates"
	},
	{
		"firstName": "Melodie",
		"lastName": "Wells"
	},
	{
		"firstName": "Lamar",
		"lastName": "Nguyen"
	},
	{
		"firstName": "Zorita",
		"lastName": "Day"
	},
	{
		"firstName": "Clinton",
		"lastName": "Pacheco"
	},
	{
		"firstName": "Serina",
		"lastName": "Alston"
	},
	{
		"firstName": "Avye",
		"lastName": "Solis"
	},
	{
		"firstName": "Abigail",
		"lastName": "Randall"
	},
	{
		"firstName": "Camille",
		"lastName": "Key"
	},
	{
		"firstName": "Geoffrey",
		"lastName": "Olson"
	},
	{
		"firstName": "Alfonso",
		"lastName": "Coffey"
	},
	{
		"firstName": "Blythe",
		"lastName": "Oneal"
	},
	{
		"firstName": "Cadman",
		"lastName": "Pennington"
	},
	{
		"firstName": "Jasper",
		"lastName": "Ramirez"
	},
	{
		"firstName": "Jamalia",
		"lastName": "Jordan"
	},
	{
		"firstName": "Reagan",
		"lastName": "Luna"
	},
	{
		"firstName": "Darius",
		"lastName": "Cooley"
	},
	{
		"firstName": "Jorden",
		"lastName": "Christensen"
	},
	{
		"firstName": "Magee",
		"lastName": "Peterson"
	},
	{
		"firstName": "Nayda",
		"lastName": "Bass"
	},
	{
		"firstName": "Desirae",
		"lastName": "Potter"
	},
	{
		"firstName": "Julie",
		"lastName": "Ruiz"
	},
	{
		"firstName": "Paula",
		"lastName": "Thompson"
	},
	{
		"firstName": "Berk",
		"lastName": "Holt"
	},
	{
		"firstName": "Ali",
		"lastName": "Bonner"
	},
	{
		"firstName": "Roary",
		"lastName": "Stewart"
	},
	{
		"firstName": "Cheyenne",
		"lastName": "Page"
	},
	{
		"firstName": "Garrison",
		"lastName": "Barry"
	},
	{
		"firstName": "Hop",
		"lastName": "Thornton"
	},
	{
		"firstName": "Burton",
		"lastName": "Dickson"
	},
	{
		"firstName": "Hiroko",
		"lastName": "Buckner"
	},
	{
		"firstName": "Shelly",
		"lastName": "Stark"
	},
	{
		"firstName": "Quamar",
		"lastName": "Holloway"
	},
	{
		"firstName": "Dalton",
		"lastName": "Watson"
	},
	{
		"firstName": "Gil",
		"lastName": "Warner"
	},
	{
		"firstName": "Cynthia",
		"lastName": "Wilcox"
	},
	{
		"firstName": "Walker",
		"lastName": "Walker"
	},
	{
		"firstName": "Dylan",
		"lastName": "Pollard"
	},
	{
		"firstName": "Aurelia",
		"lastName": "Adkins"
	},
	{
		"firstName": "Caldwell",
		"lastName": "Holcomb"
	},
	{
		"firstName": "Kenyon",
		"lastName": "Cross"
	},
	{
		"firstName": "Wing",
		"lastName": "Saunders"
	},
	{
		"firstName": "Yolanda",
		"lastName": "Sharpe"
	},
	{
		"firstName": "Macy",
		"lastName": "Lawrence"
	},
	{
		"firstName": "Lyle",
		"lastName": "Ray"
	},
	{
		"firstName": "Rajah",
		"lastName": "Baird"
	},
	{
		"firstName": "Anika",
		"lastName": "Tyson"
	},
	{
		"firstName": "Cora",
		"lastName": "Spears"
	},
	{
		"firstName": "Nomlanga",
		"lastName": "Conley"
	},
	{
		"firstName": "Ria",
		"lastName": "Lester"
	},
	{
		"firstName": "Leonard",
		"lastName": "Blevins"
	},
	{
		"firstName": "Tana",
		"lastName": "Kaufman"
	},
	{
		"firstName": "Madaline",
		"lastName": "Martin"
	},
	{
		"firstName": "Katell",
		"lastName": "Moore"
	},
	{
		"firstName": "Mollie",
		"lastName": "Williamson"
	},
	{
		"firstName": "Chadwick",
		"lastName": "Sullivan"
	},
	{
		"firstName": "Charde",
		"lastName": "Delgado"
	},
	{
		"firstName": "Octavia",
		"lastName": "Carroll"
	},
	{
		"firstName": "Dean",
		"lastName": "Nunez"
	},
	{
		"firstName": "Charlotte",
		"lastName": "Carroll"
	},
	{
		"firstName": "Molly",
		"lastName": "Hardin"
	},
	{
		"firstName": "Darius",
		"lastName": "Wall"
	},
	{
		"firstName": "Susan",
		"lastName": "Fleming"
	},
	{
		"firstName": "Sean",
		"lastName": "Paul"
	},
	{
		"firstName": "Nina",
		"lastName": "Lott"
	},
	{
		"firstName": "Amal",
		"lastName": "Durham"
	},
	{
		"firstName": "Erasmus",
		"lastName": "Eaton"
	},
	{
		"firstName": "Fay",
		"lastName": "Patterson"
	},
	{
		"firstName": "Akeem",
		"lastName": "Brown"
	},
	{
		"firstName": "Hashim",
		"lastName": "Rivers"
	},
	{
		"firstName": "Jeremy",
		"lastName": "Gentry"
	},
	{
		"firstName": "Gray",
		"lastName": "Daugherty"
	},
	{
		"firstName": "Lawrence",
		"lastName": "Salazar"
	}
]

}