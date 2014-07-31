<html>
<body>
<?php
session_start();
mysql_connect("localhost","root","");
mysql_selectdb("onlinefoodbooking");

 echo "<table>";
 echo "<form action='manager_action.php' method='get'>
 <tr><td>Item Id </td><td><input type='text' name='id'></td></tr>
 <tr><td>Item Name</td><td><input type='text' name='name'></td></tr>
 <tr><td>Item Price</td><td><input type='text' name='price'></td></tr>
 <tr><td></td><td><input type='submit' name='add' value='Add Item'
 style='cursor:pointer;width:100px;height:25px;background:lightblue;margin-left:30px;
 border-style:none;border-radius:5px;'></td></tr>";
 
 echo "</table>";

 
$item=mysql_query("select * from item");

echo "<br>Available Items<br>";
echo "<table border='1'><tr><th>Item_id</th><th>Item_name</th><th>Item_price</th></tr>"; 
while($r=mysql_fetch_array($item))
{
 echo "<tr><td>".$r['itemId']."</td><td>".$r['itemName']."</td><td>".$r['price']."</td></tr>";
 }
 echo "</table><br>";
 
  
?>
</body>
</html>