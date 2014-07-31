<html>
<body>
<?php
session_start();
mysql_connect("localhost","root","");
mysql_selectdb("onlinefoodbooking");
$item=mysql_query("select * from item");
echo "Available item<br>";

echo "<table border='1'><tr><th>Item_id</th><th>Item_name</th><th>Item_price</th><th>action</th></tr>"; 

while($r=mysql_fetch_array($item))
{
 $w=$r['itemId'];
 echo "<tr><td>".$r['itemId']."</td><td>".$r['itemName']."</td><td>".$r['price']."</td><td><form action='manager_action.php' method=get><input type='hidden' name='del_item' value='$w'><input type='submit' value='X' name='remove'></form></td><>";
 }
 echo "</table><br>";
 ?>
</body>
</html>