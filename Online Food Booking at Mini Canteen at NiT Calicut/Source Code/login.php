<html>
<body bgcolor="pink">

<?php
session_start();
$con=mysql_connect("localhost","root","") or die(mysql_error().'<br>');
mysql_select_db("onlinefoodbooking");
$uid=$_POST['uid'];
$pwd=$_POST['pwd'];

	$st=mysql_query("select * from user where userId='$uid' and password='$pwd'",$con);

	$num=mysql_num_rows($st);
	if($num and $uid != "manager")
	{
		header('Location:menu.php');
		$_SESSION['uid']=$uid;
	}
	else if($uid == "manager" and $pwd == "1234567890")
	{
		header('Location:manager.php');
		$_SESSION['uid']=$uid;
	}
	else 
	{
	$_SESSION['msg']="Invalid User ";
	header('Location:index.php');
	}
?>

</body>
</html>
