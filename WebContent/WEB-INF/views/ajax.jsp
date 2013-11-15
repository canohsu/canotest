
<%@ page session="false" %>

<html>

    <head>
    
        <title>ajax</title>
     <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    </head>
    <body>
       
<span>name</span>
<input type="text" id="name" name="name" value="">    
<span>age</span>
<input type="text" id="age" name="age" value="">    
<input type="button" id="submit" value="submit"> 
<script>
	$(function(){
		$("#submit").click(function(){
			alert("innn111");
			var data ={
					name: $("#name").val(),
					age:  $("#age").val()
		  	};
			alert("innn");
			$.post("/canotest/ajax" ,data ,function(json){
				alert("outt");
				if(json.result == "true"){
					alert("name:" + json.name +"age:" + json.age);
				}
			});	
		
		});
	});
</script>
    </body>
</html>