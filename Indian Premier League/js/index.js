/**
 * @author Yash
 */
function DDBModel() {
	var self=this;
	this.teamid =ko.observable();
	this.playerid=ko.observable(21);
	//make the property as observable property also pass default value
	this.teamname=ko.observable("");
	this.name=ko.observable("yassh");
	this.budget=ko.observable();
	this.points=ko.observable();
	this.players=ko.observable();
	this.nationality=ko.observable("india");
	this.DOB=ko.observable("1996-06-30");
	this.age=ko.observable(21);
	this.batpref=ko.observable("right");
	this.bowlpref=ko.observable("spin");
	
	//if u want to access observable property use this.property()
	//observation on an array and passing an empty array in it
	this.onInsertPlayer=function(){
		//alert(this.title()+"\n"+this.pages()+"\n"+this.price());
		//alert(typeof(this.title()));
		
		//whenever calling function on an observable array do not use bracket syntax
		//else accessing properties is always using () coz of browser compatibility reasons
		document.getElementById("playerid").className="visible";
		document.getElementById("name").className="visible";
		document.getElementById("nationality").className="visible";
		document.getElementById("DOB").className="visible";
		document.getElementById("age").className="visible";
		document.getElementById("batpref").className="visible";
		document.getElementById("bowlpref").className="visible";
		document.getElementById("confirm").className="visible";
			
	};
	this.onInsertTeam=function(){
		//alert(this.title()+"\n"+this.pages()+"\n"+this.price());
		//alert(typeof(this.title()));
		
		//whenever calling function on an observable array do not use bracket syntax
		//else accessing properties is always using () coz of browser compatibility reasons
		document.getElementById("teamname").className="visible";
		document.getElementById("points").className="visible";
		document.getElementById("budget").className="visible";
		document.getElementById("teamid").className="visible";
		document.getElementById("players").className="visible";
		document.getElementById("confirm2").className="visible";
			
	};
}

//ko is knockout object available in every js code if you have included jnockout.js ka script tag in html
ko.applyBindings(new DDBModel());
