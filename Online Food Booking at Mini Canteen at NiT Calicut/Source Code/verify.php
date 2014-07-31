<html>
<body bgcolor="lightblue">
<?php
session_start();
$roll=$_SESSION['roll'];


		$con=mysql_connect("localhost","root","") or die(mysql_error().'<br>');
		mysql_select_db("onlinefoodbooking");

	if(isset($_POST['submit']))
	{
		$ans=$_POST['ans'];
		$sql="select * from user where userId='$roll' and securityAns='$ans'";
		$sql=mysql_query("$sql",$con);
		$row=mysql_fetch_array($sql);
		if($row >= 1)
		header('Location:recoPwd.php');
		else
		echo "<center>"."Wrong Answer";

		
		
	}
	
?>

</body>
</html>