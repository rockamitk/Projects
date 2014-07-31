<html>
<body style="background:#B0E0E6;text-align:center;font-size:17px;">
<?php
session_start();
$uid=$_SESSION['uid'];

mysql_connect("localhost","root","");
mysql_select_db("onlinefoodbooking");

	if (mysqli_connect_errno())
	{
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}

if(isset($_GET['add']))
{

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
	$item=mysql_query("select * from tem_table");

	$t=0;
		while($r=mysql_fetch_array($item))
		{
			$t+=$r['total'];
			$w=$r['itemId'];
 
		echo "<form action='del.php' method=get>"
		 .$r['item_name']."&nbsp &nbsp"
		.$r['price']."&nbsp &nbsp"
		.$r['quan']."&nbsp &nbsp"
		.$r['total']
		."<input type='hidden' name='del' value='$w'>
		<input type='submit' value='remove' name='remove' style='cursor:pointer;color:green;background: #F0E68C;margin-left:10px;border-style:none;border-radius:5px;'>"
		."</form>";
		}
		$_SESSION['uid']=$uid;
		$_SESSION['total']=$t;
		echo "<form action='del.php' method='get'>"
		."Total price :".$t."&nbsp &nbsp
		<input type='submit' name='order' value='Submit' style='cursor:pointer;color:green;background: #F0E68C;margin-left:10px;border-style:none;border-radius:5px;'>
		</form>
		<form action='del.php' method='get'>
		<input type='submit' name='cancel' value='Reload' style='cursor:pointer;color:green;background: #F0E68C;margin-left:10px;border-style:none;border-radius:5px;'>
		</form>";
}
		if($_SESSION['q']==1)
		{
		$item=mysql_query("select * from tem_table");
		$t=0;
			while($r=mysql_fetch_array($item))
			{
			$t+=$r['total'];
			$w=$r['itemId'];
 
			echo "<form action='del.php' method=get>"
				.$r['item_name']."&nbsp &nbsp"
				.$r['price']."&nbsp &nbsp"
				.$r['quan']."&nbsp &nbsp"
				.$r['total']
				."<input type='hidden' name='del' value='$w'>
		<input type='submit' value='remove' name='remove' style='cursor:pointer;color:green;background: #F0E68C;margin-left:10px;border-style:none;border-radius:5px;'>"
				."</form>";
			}
			
			$_SESSION['total']=$t;

		echo "<form action='del.php' method='get'>"
		."Total price :".$t."&nbsp &nbsp
		<input type='submit' name='order' value='Place Order' style='cursor:pointer;color:green;background: #F0E68C;margin-left:10px;border-style:none;border-radius:5px;'>
		</form>
		<form action='del.php' method='get'>
		<input type='submit' name='cancel' value='cancel' style='cursor:pointer;color:green;background: #F0E68C;margin-left:10px;border-style:none;border-radius:5px;'>
		</form>";
 		}
?>
</body>
</html>