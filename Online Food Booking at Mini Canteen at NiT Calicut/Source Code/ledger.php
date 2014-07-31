<html>
<body style="background:#FFFAF0;font-size:17px;">

<?php
session_start();
$roll=$_SESSION['uid'];
$orderNo=$_SESSION['ord'];
$total=$_SESSION['total'];

mysql_connect("localhost","root","");
mysql_selectdb("onlinefoodbooking");
		
		$date=$time="";
		echo "   OrderNo :".$orderNo
			." ,    Roll No :".$roll."<br>";
			
		$sql=mysql_query("select * from transaction where orderNo='$orderNo' and roll='$roll'");
		echo "<table border='1'>";
		while($row=mysql_fetch_array($sql))
		{
		echo "<tr>
			<td height='20' width='130'>".$row['itemName']."</td>
			<td height='20' width='40'>".$row['quantity']."</td>
			<td height='20' width='40'>".$row['totalPrice']."</td>
			</tr>";
			$time=$row['time'];
			$date=$row['date'];
		}
		echo "</table><br>";
		echo "Total Price :".$total
			." ,    Time :".$time." ,   Date :".$date."<br>";

?>

</body>
</html>
