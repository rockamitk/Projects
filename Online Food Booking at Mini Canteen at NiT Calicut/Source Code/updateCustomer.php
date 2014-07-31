<?php
session_start();
$uid=$_SESSION['uid'];

		$con=mysql_connect("localhost","root","") or die(mysql_error().'<br>');
		mysql_select_db("onlinefoodbooking");

	if(isset($_POST['submit']))
	{
	
		$name=$_POST['name'];
		$contact=$_POST['contact'];
		$email=$_POST['email'];
		$hnm=$_POST['hnm'];

	$sql="update customer set name='$name',contact='$contact',email='$email',hostelName='$hnm'  where roll='$uid'";
	$flag=mysql_query("$sql",$con);
	if(!$flag)
	die(mysql_error().'<br>');

	}


	$st=mysql_query("select * from customer where roll='$uid'",$con);
		while($row=mysql_fetch_array($st))
		{
		$name=$row['name'];
		$contact=$row['contact'];
		$email=$row['email'];
		$hnm=$row['hostelName'];
	
		}

?>


<!DOCTYPE HTML>

<html>
<head>
<link rel="icon" href="images/logo.jpg" type="image/x-icon" />
<title>Online Food Booking</title>

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

	</style></head>
<body style="background: url(images/bck7.jpg);>
	<div class="header"></div>
	<div class="center">
			<form action="<?php $_SERVER["PHP_SELF"];?>" method="POST">
				<fieldset>
				<legend>new user</legend>
				
				<p>Roll &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <?php echo $uid; ?></p>
				<p>Name &nbsp &nbsp <input type="text" size="20px" name="name" value="<?php echo $name;?>" /></p>
				<p>Contact &nbsp <input type="text" size="20px" name="contact" value="<?php echo $contact;?>" /></p>
				<p>Email &nbsp &nbsp &nbsp <input type="text" size="20px" name="email" value="<?php echo $email;?>" /></p>

				Hostel Name <input type="text" size="20px" name="hnm" value="<?php echo $hnm;?>" /></p>
				<br><br><input type="submit" name="submit" value="UPDATE" style="height: 40px; width: 495px; font-size: 22px;cursor:pointer; color: rgb(255,255,255);background: rgb(50,51,100);border-style:none;border-radius:5px;" />
				
			        
				</fieldset>
				</form>

			
	</div>
	
		</body>
</html>
