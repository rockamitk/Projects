<html>
<body>
<?php
session_start();
mysql_connect("localhost","root","");
mysql_selectdb("onlinefoodbooking");
$cus=mysql_query("select * from customer");
echo "Customer List <br>";

echo "<table border='1'>
	<tr><th>Roll No.</th>
	<th>Name</th>
	<th>Contact No</th>
	<th>Email</th>
	<th>Hostel </th>
	<th>Balance</th>
	<th>Delete Account</th></tr>";
	
while($r=mysql_fetch_array($cus))
{
 $w=$r['roll'];
 $ac=mysql_query("select * from account where roll='$w'");
 $am=mysql_fetch_array($ac);

 echo "<tr><td>".$r['roll']."</td><td>"
 .$r['name']."</td><td>"
 .$r['contact']."</td><td>"
 .$r['email']."</td><td>"
 .$r['hostelName']."</td><td>"
 .$am['amount']."</td><td>
 <form action='manager_action.php' method=get>
 <input type='hidden' name='del_cus' value='$w'>
 <input type='submit' value='X' name='remove_customer' style='color:red;border-radius:5px;'>
 </form></td></tr>";
 }
 echo "</table><br>";
 ?>
</body>
</html>