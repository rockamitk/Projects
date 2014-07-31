<html>
<head>
<link rel="icon" href="images/logo.jpg" type="image/x-icon" />
<title>Online Food Booking</title>
</head>
<body style="font-size:17px;">

<?php
mysql_connect("localhost","root","");
mysql_selectdb("onlinefoodbooking");
		
	
	$sq=mysql_query("select * from maintransaction");
	while($r=mysql_fetch_array($sq))
	{
		echo "<li>"."OrderNo :".$r['orderNo']
			.",     Roll No :".$r['roll']."</li>";
			
		$roll=$r['roll']; $orderNo=$r['orderNo'];$total=0;
		
		$sql=mysql_query("select * from transaction where orderNo=$orderNo and roll=$roll ");
		echo "<table border='1'>";
		while($row=mysql_fetch_array($sql))
		{
		echo "<tr>
			<td height='20' width='40'>".$row['itemName']."</td>
			<td height='20' width='40'>".$row['quantity']."</td>
			<td height='20' width='40'>".$row['totalPrice']."</td>
			</tr>";
			$time=$row['time'];
			$date=$row['date'];
			$total+=$row['totalPrice'];
		}
		echo "</table>";

		echo "Total Price :".$total
			.",    Time :".$time.",   Date :".$date."<br>";
		echo "______________________________________________________<br>";
	}
?>

</body>
</html>
