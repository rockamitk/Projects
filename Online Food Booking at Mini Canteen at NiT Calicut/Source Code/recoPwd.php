<?php
session_start();
$roll=$_SESSION['roll'];

	if(!isset($_SESSION['roll']))
	{
		$_SESSION['msg']="You should login to access your Account";
		header('Location:index.php');
	}
		$con=mysql_connect("localhost","root","") or die(mysql_error().'<br>');
		mysql_select_db("onlinefoodbooking");
		
	if(isset($_POST['submit']))
	{
		$pwd1=$_POST['pwd1'];
		$pwd2=$_POST['pwd2'];

		if( $pwd1 == $pwd2 )
		{
			$sql="update user set password='$pwd1' where userId='$roll'";
			$flag=mysql_query("$sql",$con);
			if(!$flag)
			die(mysql_error().'<br>');
			
			unset($_SESSION['roll']);
			$_SESSION['msg']="You Should login";
			header('Location:menu.php');
		}
	}

?>

<html>
<head>
<link href="decoMenu.css" rel="stylesheet" type="text/css" />
</head>
<body>
		<div class="center">
			<form action="<?php $_SERVER["PHP_SELF"];?>" method="POST">
				<fieldset>
				<legend>Recover Password</legend>
				
				<center><p>Roll &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <?php echo $roll; ?></p>
				<p>New Password&nbsp  <input type="password" size="16px" name="pwd1"/></p>
				<p>Conform Password&nbsp  <input type="password" size="16px" name="pwd2"/></p>

				<br><br><input type="submit" name="submit" value="Submit" style="height: 25px; width: 120px;border-style:none;border-radius:5px;" />
				
			        
				</fieldset>
				</form>

			
		</div>
	
</body>
</html>
