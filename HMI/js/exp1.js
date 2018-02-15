$( document ).ready(function() {
    //alert( "ready!" );
    addition=true;
    $("#first").val(0);
    $("#second").val(0);
    $("#add1").hide();
    $("#add2").hide();
    $("#imgdiv").hide();
    $("#equaltosign").hide();
     $("#first").on("change", function() {
   $("#add1").hide();
   $('#add1').html('');
   //$('#equal').html('');
   $("#equal").fadeOut(500);
        
   for(i=0;i<$("#first").val();i++)
   {
        $('#add1').append('<img height="100px" class="img-rounded" width="100px" class="inline" id="image" src="images/candy.jpg" />');
   }
    $("#add1").fadeIn(2000);
    
});
    $("#second").on("change", function() {
   $('#equal').html('');
   $("#equal").fadeOut(500);
        
   $("#add2").fadeOut(100);
   $('#add2').html('');
   for(i=0;i<$("#second").val();i++)
   {
        $('#add2').append('<img height="100px" class="img-rounded" width="100px" class="inline" id="image" src="images/candy.jpg" />');
   }
    $("#add2").fadeIn(2000);
    
});
     $( "#addition" ).click(function() {
    addition=true;
    $('#imgdiv').html('');
    $("#imgdiv").fadeOut(100);
    $('#imgdiv').append('<img height="100px" class="img-rounded" width="100px" class="inline" id="image" src="images/add.jpg" />');           
    $("#imgdiv").fadeIn(2000);
    //$('#equal').html('');
   $("#equal").fadeOut(500);
   
}); $( "#subtraction" ).click(function() {
    addition=false;
    $('#imgdiv').html('');
    $("#imgdiv").fadeOut(100);
    $('#imgdiv').append('<img height="100px" class="img-rounded" width="100px" class="inline" id="image" src="images/subtract.jpg" />');       
    $("#imgdiv").fadeIn(2000);
    //$('#equal').html('');
   $("#equal").fadeOut(500);
   
});
    $( "#target" ).click(function() {
        $("#equaltosign").fadeIn(2000);
 		x=parseInt($("#first").val());
        y=parseInt($("#second").val());
        if(addition)
            x+=y;
        else
       {
            //if(x<y)
                //alert("less candies");
            x-=y;
        }
        $('#equal').html('');
        $("#equal").fadeOut(50);
        for(i=0;i<x;i++)
        $('#equal').append('<img height="100px"  class="img-rounded" width="100px" class="inline" id="image" src="images/candy.jpg" />');       
        $('#equal').append('<h3>'+x+'</h3>')
        $("#equal").fadeIn(2000);
});
});