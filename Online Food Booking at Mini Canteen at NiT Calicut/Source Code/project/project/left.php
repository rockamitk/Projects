<html>
<body bgcolor="pink">
<?php
session_start();
mysql_connect("localhost","root","");
mysql_selectdb("onlinefoodbooking");
$item=mysql_query("select * from item");
$_SESSION['msg']=" ";
echo "Item_name &nbsp; &nbsp; &nbsp; Price<br><br>"; 
while($r=mysql_fetch_array($item))
{
 $_SESSION['q']=0;
 $i=$r['itemId'];
 $a=$r['itemName'];
 $p=$r['price'];
 echo "<form action='right.php' method='get' target='r' >".$r['itemName']."&nbsp; &nbsp; &nbsp;".$r['price']."<input type='text' name='q'>"."<input type='hidden' name='k' value='$p'>"."<input type='hidden' name='i' value='$i'>"."<input type='hidden' name='n' value='$a'>"."<input type='submit' name ='add' value='add'><br></form>";
 }
?>
</body>
</html>