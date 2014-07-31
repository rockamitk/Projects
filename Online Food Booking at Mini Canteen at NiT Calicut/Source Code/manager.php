<?php

session_start();

	if(!isset($_SESSION['uid']))
	{
		$_SESSION['msg']="You should login to access your Account";
		header('location:index.php');
	}
	else
		{
		$uid=$_SESSION['uid'];
		}
	$_SESSION['return']="";
?>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="images/logo.jpg" type="image/x-icon" />
<title>Online Food Booking</title>

<link href="manager.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="headLeft" >Nitc Mini Canteen
		<div style="float:right;font-size:20px;">Manager Working Window
		<br><a href="logout.php">Logout</a>
		</div>
	</div>
	
	<div class="left">
		
		<div>
		<form action="manager/add_item.php" method="POST" target="r">
		<input type="submit" name="ad" value="Add New Item" tabindex="t" style=" background-color: #CD853F; 
		height: 100%; width: 100%; font-size:1.6em;background: rgb(50,51,100);border-style:none;border-radius:7px;cursor:pointer;color:white;"></p><br>
		</form>	
		</div>

		<div>
		<form action="manager/delete_item.php" method="POST" target="r">
		<input type="submit" name="ad" value="Delete Item" tabindex="t" style=" background-color: #CD853F; 
		height: 100%; width: 100%; font-size:1.6em;background: rgb(50,51,100);border-style:none;border-radius:7px;cursor:pointer;color:white;"></p><br>
		</form>	
		</div>

		

		<div>
		<form action="manager/customer.php" method="POST" target="r">
		<input type="submit" value="Customer Record" tabindex="t" style=" background-color: #CD853F; 
		height: 100%; width: 100%; font-size:1.6em;background: rgb(50,51,100);border-style:none;border-radius:7px;cursor:pointer;color:white;"></p><br>
		</form>	
		</div>
		<div>

		<form action="manager/payment.php" method="POST" target="tr">
		<input type="submit" value="Credit Account" tabindex="t" style=" background-color: #CD853F; 
		height: 100%; width: 100%; font-size:1.6em;background: rgb(50,51,100);border-style:none;border-radius:7px;cursor:pointer;color:white;"></p><br>
		</form>	
		</div>
		
		<div>
		<form action="manager/viewTransaction.php" method="POST" target="tr">
		<input type="submit" value="View Transaction" tabindex="t" style=" background-color: #CD853F; 
		height: 100%; width: 100%; font-size:1.6em;background: rgb(50,51,100);border-style:none;border-radius:7px;cursor:pointer;color:white;"></p><br>
		</form>	
		</div>


	</div>
		
	<div class="main"><iframe src="manager/OperationFrame.php" width="100%" height="100%" name='r' ></iframe>
	</div>

	<div class="right"><iframe src="manager/tranjectFrame.php" width="96%" height="100%" name='tr' ></iframe>
	</div>

	</body>
</html>