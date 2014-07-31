<html>
<body style="background: url('images/bck11.jpg');text-align:center;color:green;font-size:15px;">
<?php
session_start();
mysql_connect("localhost","root","");
mysql_select_db("onlinefoodbooking");

$item=mysql_query("select * from item");

while($r=mysql_fetch_array($item))
{
 $_SESSION['q']=0;
 $i=$r['itemId'];
 $a=$r['itemName'];
 $p=$r['price'];
 echo "<form action='menuRight.php' method='get' target='r' >"
		.$r['itemName']."&nbsp; &nbsp; &nbsp;"
		.$r['price']."<input name='q' type='text' style='width: 30px; margin-left: 10px;' />"
		."<input type='hidden' name='k' value='$p'>"
		."<input type='hidden' name='i' value='$i'>"
		."<input type='hidden' name='n' value='$a'>"
		."<input type='submit' name ='add' value='add' style='cursor:pointer;color:green;background: #F0E68C;margin-left:10px;border-style:none;border-radius:5px;'>
		</form>";
 }
?>
</body>
</html>