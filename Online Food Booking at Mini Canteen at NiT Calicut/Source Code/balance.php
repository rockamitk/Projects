<html>
<head>
<link rel="icon" href="images/logo.jpg" type="image/x-icon" />
<title>Online Food Booking</title>
</head>

<body bgcolor="#66CDAA">
<?php
session_start();
$uid=$_SESSION['uid'];

		$con=mysql_connect("localhost","root","") or die(mysql_error().'<br>');
		mysql_select_db("onlinefoodbooking");
		
		$st=mysql_query("select * from account where roll='$uid'",$con);
		while($row=mysql_fetch_array($st))
		{
			echo "<br><br>"."<center>"."Your Current Balance only  :".$row['amount']."<br>";
			//echo "<a href='menu.php'>Back </a>";
		}
?>
</body>
</html>