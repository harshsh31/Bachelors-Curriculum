$( document ).ready(function() {
    ////alert( "ready!" );
    count=0;
    random=Math.floor(Math.random()*4);
    addition=true;
    $("#first").val(0);
    $("#second").val(0);
    $("#add1").hide();
    $("#add2").hide();
    $("#imgdiv").hide();
    $('#add1').html('');
    $('#add2').html('');
    $("#equaltosign").hide();
    $("#symbol").hide();
    $( "#target" ).click(function() {
        x=Math.floor(Math.random() * 10)+6;
        y=Math.floor(Math.random() * 5)+1;
        random=Math.floor(Math.random()*4);
        //$("#first").text(x);
        $("#second").text(y);
        $("#add1").hide();
        $("#add2").hide();
        $("#imgdiv").hide();
        $("#symbol").hide();
        $("#symbol").html('');
        $('#imgdiv').html('');   
        $('#add1').html('');
        for(i=0;i<x;i++)
        {
            $('#add1').append('<img height="100px" width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');
        }
        $("#add1").fadeIn(2000);
        $('#add2').html('');
        for(i=0;i<y;i++)
        {
            $('#add2').append('<img height="100px" width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');
        }
        $("#add2").fadeIn(2000);
        if((count/3)%2==1)
          addition=false;
        else
          addition=true;
        count++;
                
        if(addition)
            {
                $("#first").text(x+"+");
                x+=y;
                $('#imgdiv').append('<img height="100px" width="100px" class="inline" id="image" src="images/add.jpg" />');
                
            } 
        else
            {

                $("#first").text(x+"-");
                x-=y;
                $('#imgdiv').append('<img height="100px" width="100px" class="inline" id="image" src="images/subtract.jpg" />');
            }
            $("#imgdiv").fadeIn(2000);
            $('#equal').html('');
            $('#equal1').html('');
            $('#equal2').html('');
            $('#equal3').html('');
            $("#equal").hide();
            $("#equal1").hide();
            $("#equal2").hide();
            $("#equal3").hide();
            if(random==0)
            {
              for(i=0;i<x;i++)
                $('#equal').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');  
              $('#equal').append('<h3>'+x+'</h3>');     
              y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+5;
              for(i=0;i<y;i++)
                $('#equal1').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal1').append('<h3>'+y+'</h3>');     
              y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+2;
             for(i=0;i<y;i++)
                $('#equal2').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
             $('#equal2').append('<h3>'+y+'</h3>');     
               y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+1;
             for(i=0;i<y;i++)
                $('#equal3').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
            $('#equal3').append('<h3>'+y+'</h3>');     
              
            }
            else if(random == 1)
            {
              for(i=0;i<x;i++)
                $('#equal1').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal1').append('<h3>'+x+'</h3>');     
              y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+5;
              for(i=0;i<y;i++)
                $('#equal').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal').append('<h3>'+y+'</h3>');     
              y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+2;
             for(i=0;i<y;i++)
                $('#equal2').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal2').append('<h3>'+y+'</h3>');     
              y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+1;
              for(i=0;i<y;i++)
                $('#equal3').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal3').append('<h3>'+y+'</h3>');     
            
           }
            else if(random == 2)
            {
              for(i=0;i<x;i++)
                $('#equal2').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal2').append('<h3>'+x+'</h3>');     
            y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+5;
              for(i=0;i<y;i++)
                $('#equal1').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal1').append('<h3>'+y+'</h3>');     
              y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+2;
             for(i=0;i<y;i++)
                $('#equal').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal').append('<h3>'+y+'</h3>');     
            y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+1;
              for(i=0;i<y;i++)
                $('#equal3').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal3').append('<h3>'+y+'</h3>');      
           }
            else if(random == 3)
            {
              for(i=0;i<x;i++)
                $('#equal3').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal3').append('<h3>'+x+'</h3>');     
              y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+5;
              for(i=0;i<y;i++)
                $('#equal1').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal1').append('<h3>'+y+'</h3>');     
              y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+2;
             for(i=0;i<y;i++)
                $('#equal2').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal2').append('<h3>'+y+'</h3>');     
              y=x;
              while(y==x)
              y=Math.floor(Math.random()*10)+1;
              for(i=0;i<y;i++)
                $('#equal').append('<img height="100px"  width="100px" class="inline img-rounded" id="image" src="images/candy.jpg" />');       
              $('#equal').append('<h3>'+y+'</h3>');     
            
            }
            $("#equal").fadeIn(2000);
            $("#equal1").fadeIn(2000);
            $("#equal2").fadeIn(2000);
            $("#equal3").fadeIn(2000);
            $("#equaltosign").fadeIn(5000);
});
$( "#equal" ).click(function() {
  $('#symbol').html('');
  $("#symbol").hide();
  if(random==0)
    {
      //alert("correct");
      $("#symbol").append('<img class="fixedatcenter" src="images/correct.gif" />');
    }
  else
    {
      //alert("incorrect");
      $("#symbol").append('<img class="fixedatcenter" src="images/wrong.gif" />');
    }
    $('#symbol').fadeIn(800);
    
    $('#symbol').fadeOut(3000);
});
$( "#equal1" ).click(function() {
  $('#symbol').html('');
  $("#symbol").hide();
  if(random==1)
    {
      //alert("correct");
      $("#symbol").append('<img class="fixedatcenter" src="images/correct.gif" />');
    }
  else
    {
      //alert("incorrect");
      $("#symbol").append('<img class="fixedatcenter" src="images/wrong.gif" />');
    }
    $('#symbol').fadeIn(800);
    //$('#symbol').animate({ 'zoom': 1.5 }, 2000);
    $('#symbol').fadeOut(3000);
});
$( "#equal2" ).click(function() {
  $('#symbol').html('');
  $("#symbol").hide();
  if(random==2)
    {
      //alert("correct");
      $("#symbol").append('<img class="fixedatcenter" src="images/correct.gif" />');
    }
  else
    {
      //alert("incorrect");
      $("#symbol").append('<img class="fixedatcenter" src="images/wrong.gif" />');
    }
    $('#symbol').fadeIn(800);
    //$('#symbol').animate({ 'zoom': 1.5 }, 2000);
    $('#symbol').fadeOut(3000);
});

$( "#equal3" ).click(function() {
  $('#symbol').html('');
  $("#symbol").hide();
  if(random==3)
    {
      //alert("correct");
      $("#symbol").append('<img class="fixedatcenter" src="images/correct.gif" />');
    }
  else
    {
      //alert("incorrect");
      $("#symbol").append('<img class="fixedatcenter" src="images/wrong.gif" />');
    }
    $('#symbol').fadeIn(800);
    //$('#symbol').animate({ 'zoom': 1.5 }, 2000);
    $('#symbol').fadeOut(3000);
});

});