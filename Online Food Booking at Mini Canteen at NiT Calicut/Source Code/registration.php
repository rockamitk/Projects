<?php
session_start();
$_SESSION['msg']="Registeration Cancelled";

?>


<!DOCTYPE HTML>

<html>
	<style>
		body{ background-color : lightblue;}
		p.one
		  {
			border-style:solid;
			border-color:white;
			border-width:1px;
		  }
		 
 	.header
	{
		position:absolute;
		top:0%;
		left:12%;
        height:28%;
		width:76%;
		text-align: center;
	}

		.center
		  {
			position:absolute;
			top:28%;
			left:15%;
			border:solid white;
			border-width:2px;
			background-color:rgba(70,65,65,1);
			border-color:green;
			border-radius: 10px;
			-moz-border-radius: 5px;
			text-align: center;
			display: inline-block;
			width:70%;
			color:white;
			font-size:16px;
		  }	

			.error {color: white;}
	</style>
	
<body style="background: url(images/bck4.jpg);>
	<div class="header"></div>
	<div class="center">
			<form action="addUser.php" method="POST">
			<fieldset>
				<legend>new user</legend>
				
				<p>Roll &nbsp &nbsp &nbsp &nbsp <input type="text" size="20px" name="roll"/><?php echo $_SESSION['r_blank']; ?> </p>
				<p>Name &nbsp &nbsp <input type="text" size="20px" name="name" /><?php echo $_SESSION['n_blank']; ?><?php echo $_SESSION['n_valid']; ?></p>
				<p>Contact &nbsp <input type="text" size="20px" name="contact"/><?php echo $_SESSION['c_blank']; ?><?php echo $_SESSION['c_valid']; ?></p>
				<p>Email &nbsp &nbsp &nbsp <input type="text" size="20px" name="email"/><?php echo $_SESSION['e_blank']; ?><?php echo $_SESSION['e_valid']; ?></p>
				<p>Password&nbsp  <input type="password" size="20px" name="pwd"/></p>
				<p>SecurityQues <select name="sq"><p>
								<option>Your DOB place</option><option>Best friend name</option><option>First mobile number</option>
							</select>
				<p>Answer&nbsp  <input type="text" size="20px" name="ans"/></p>
				Hostel Name &nbsp &nbsp <select name="hnm">
								<option>A</option><option>B</option><option>C</option><option>D</option>
								<option>E</option><option>F</option><option>G</option><option>PG2</option>
							</select>
				&nbsp &nbsp <input type="reset" value="clear"/><br>
				<br><br><input type="submit" name="submit" value="Register" style="height: 40px; width: 495px; font-size: 22px;cursor:pointer; color: rgb(255,255,255);background: rgb(50,51,100);border-style:none;border-radius:5px;" />
				
			        
				</fieldset>
				</form>
<?php $_SESSION['n_blank']="";
$_SESSION['r_blank']="";
$_SESSION['c_blank']="";
$_SESSION['e_blank']="";
$_SESSION['n_valid']="";
$_SESSION['c_valid']="";
$_SESSION['e_valid']=""; ?>

	</div>

	</body>
</html>