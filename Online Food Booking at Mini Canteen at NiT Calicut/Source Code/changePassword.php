<?php
session_start();
$uid=$_SESSION['uid'];

		$con=mysql_connect("localhost","root","") or die(mysql_error().'<br>');
		mysql_select_db("onlinefoodbooking");
		
	if(isset($_POST['submit']))
	{
	
		$pwd=$_POST['pwd'];
		$pwd1=$_POST['pwd1'];
		$pwd2=$_POST['pwd2'];

		if( $pwd1 == $pwd2 )
		{
			$st=mysql_query("select * from user where userId='$uid' and password='$pwd' ",$con);
			if(mysql_num_rows($st))
			{
			$sql="update user set password='$pwd1' where userId='$uid'";
			$flag=mysql_query("$sql",$con);
			if(!$flag)
			die(mysql_error().'<br>');
			
			$_SESSION['msg']="Password changed ,Login again";
			$_SESSION['return']="";
			header('location:index.php');
			}
			else
			{
			echo "<center>"."Invalid Current Password"."<br>";
			echo "<a href='menu.php'>Back to Your Account</a>";

			}
		}
		else
		{
			echo "<center>"."Your New Password not Matched"."<br>";
			echo "<a href='menu.php'>Back to Your Account</a>";
		}

	}

?>

<html>
<head>

<title>Online Food Booking</title>
<link rel="icon" href="images/logo.jpg" type="image/x-icon" />

<link href="decoMenu.css" rel="stylesheet" type="text/css" />
</head>
<body>
		<div class="center">
			<form action="<?php $_SERVER["PHP_SELF"];?>" method="POST">
				<fieldset>
				<legend>new user</legend>
				
				<center><p>Roll &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <?php echo $uid; ?></p>
				<p>Old Password&nbsp  <input type="password" size="16px" name="pwd"/></p>
				<p>New Password&nbsp  <input type="password" size="16px" name="pwd1"/></p>
				<p>Conform Password&nbsp  <input type="password" size="16px" name="pwd2"/></p>

				<br><br><input type="submit" name="submit" value="Submit" style="height: 40px; width: 495px; font-size: 22px;cursor:pointer; color: rgb(255,255,255);background: rgb(50,51,100);border-style:none;border-radius:5px;" />
				
			        
				</fieldset>
				</form>

			
		</div>
	
</body>
</html>
