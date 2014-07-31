<html>
<head>
<link rel="icon" href="images/logo.jpg" type="image/x-icon" />
<title>Online Food Booking</title>
</head>
<body>
<?php

		$con=mysql_connect("localhost","root","") or die(mysql_error().'<br>');
		mysql_select_db("onlinefoodbooking");
		
		if(isset($_POST['submit']))
		{
		$roll=$_POST['roll'];
		$amount=$_POST['amount'];
		
		$sql=mysql_query("select * from account where roll='$roll'",$con);
		if($row=mysql_fetch_array($sql))
		{
			$amount+=$row['amount'];
			mysql_query("update account set amount=$amount where roll='$roll'",$con);
			
			echo "<center>"."<table><tr><td>Roll Number </td><td>".$roll."</td></tr>
			<tr><td>Current Balance</td><td>".$amount."</td></tr></table>";	
		}
		
		else echo "<center>"."Customer's Acccount  : ".$roll."   does not exist";
		}
?>
</body>
</html>