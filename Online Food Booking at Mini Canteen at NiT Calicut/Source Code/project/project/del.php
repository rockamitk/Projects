<html>
<body bgcolor="pink">
<?php
session_start();
$_SESSION['roll']="m120369ca";
mysql_connect("localhost","root","");
mysql_selectdb("onlinefoodbooking");

         if(isset($_GET['remove']))
          {
            $d=$_GET['del'];
            $_SESSION['q']=1;
            mysql_query("delete from tem_table where itemId='$d'");

           header('Location:right.php');
          }
                if(isset($_GET['cancel']))
                {
                   $_SESSION['q']=1;
                   mysql_query("delete from tem_table");

                   header('Location:right.php');
                }
if(isset($_GET['order']))
{
 $_SESSION['q']=1;
 $e=$_SESSION['roll'];
$bal=mysql_query("select amount from account where roll='$e'");
$b=mysql_fetch_array($bal);
if($b['amount']<$_SESSION['total'])
{
  $_SESSION['msg']="U don't have sufficient balance";
   header('Location:right.php');
 }
else
{
    $or=mysql_query("select max((int)orderNo) from maintransaction");
	$q=mysql_fetch_array($or);
	$ord=(int)$q['orderNo']+1;
	mysql_query("insert into maintransaction values('$ord','$e'");
	$or=mysql_query("select * from tem_table");
	$orderitem=" ";
	while($q=mysql_fetch_array($or))
	 {
	    $a=$q['itemId'];
		$b=$q['item_name'];
		$c=$q['quan'];
		$d=$q['total'];
		$date=date("d-m-y");
		$time=date("G:i:s", time());
		mysql_query("insert into transaction values('1001','$e','$b',$c,$d,'$time','$date')");
		$orderitem=$orderitem."<br>".$b."&nbsp;".$c."  ".$d;
		 
	 }   
    $_SESSION['msg']="<center><u><h2>u ordered</h2></u><br>Item_name quantity  price</center><br><center>".$orderitem."<br>Total price--".$_SESSION['total'];
    $am=$_SESSION['total'];
    mysql_query("update account set amount=amount-$am where roll='$e'");
     mysql_query("delete from tem_table");    
    header('Location:right.php');
}
}
 ?>
 </body>
 </html>