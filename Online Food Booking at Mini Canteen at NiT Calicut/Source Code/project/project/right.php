<html>
<body bgcolor="gray">
<?php
session_start();
mysql_connect("localhost","root","");
mysql_selectdb("onlinefoodbooking");
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

if(isset($_GET['add']))
{
$_SESSION['msg']=" ";
$_SESSION['q']=0;
$w=1;
$name=$_GET['n'];
$id=$_GET['i'];
$price=(int)$_GET['k'];
$quan=(int)$_GET['q'];
$total=$price*$quan;
$dup=mysql_query("select * from tem_table where itemId='$id'");
$q=mysql_fetch_array($dup);

if($q==null)
{
 mysql_query("insert into tem_table values('$id','$name',$price,$quan,$total)");
}
else
{
 
 mysql_query("update tem_table set quan=$quan,total=$price*quan where itemId='$id'");

}
echo "Selected Item<br>";
$item=mysql_query("select * from tem_table");
echo "Item_name &nbsp; &nbsp; &nbsp; Price &nbsp; &nbsp; &nbsp; quantity &nbsp; &nbsp; &nbsp; total<br><br>";
echo "<ul>"; 
$t=0;
while($r=mysql_fetch_array($item))
{
 $t+=$r['total'];
 $w=$r['itemId'];
 echo "<li>".$r['item_name']."&nbsp; &nbsp; &nbsp;".$r['price']."&nbsp; &nbsp; &nbsp;".$r['quan']."&nbsp; &nbsp; &nbsp;".$r['total']."<form action='del.php' method=get>"."<input type='hidden' name='del' value='$w'><input type='submit' value='remove' name='remove'>"."</form><br>";
 }
 echo "</ul>";
  echo "---------------------------------------------------------------------------";
   $_SESSION['total']=$t;
 echo "<h1>Total price ->".$t."</h1><br>";
 echo "<form action='del.php' method='get'><input type='submit' name='order' value='order'></form><form action='del.php' method='get'><input type='submit' name='cancel' value='cancel'></form>";
 }
 if($_SESSION['q']==1)
  {
    echo "Selected Item<br>";
$item=mysql_query("select * from tem_table");
echo "Item_name &nbsp; &nbsp; &nbsp; Price &nbsp; &nbsp; &nbsp; quantity &nbsp; &nbsp; &nbsp; total<br><br>";
echo "<ul>"; 
$t=0;
while($r=mysql_fetch_array($item))
{
 $t+=$r['total'];
 $w=$r['itemId'];
 echo "<li>".$r['item_name']."&nbsp; &nbsp; &nbsp;".$r['price']."&nbsp; &nbsp; &nbsp;".$r['quan']."&nbsp; &nbsp; &nbsp;".$r['total']."<form action='del.php' method=get>"."<input type='hidden' name='del' value='$w'><input type='submit' value='remove' name='remove'>"."</form><br>";
 }
 echo "</ul>";
  echo "---------------------------------------------------------------------------";
  $_SESSION['total']=$t;
 echo "<h1>Total price ->".$t."</h1>";
 echo "<form action='del.php' method='get'><input type='submit' name='order' value='order'></form><form action='del.php' method='get'><input type='submit' name='cancel' value='cancel'></form>";
 echo "<h1>".$_SESSION['msg']."</h1>";
 
}
?>
</body>
</html>