<html>
<body bgcolor="white">
<?php
session_start();
$roll=$_SESSION['uid'];

mysql_connect("localhost","root","");
mysql_selectdb("onlinefoodbooking");

			
			if(isset($_GET['remove']))
			{
            $d=$_GET['del'];
            $_SESSION['q']=1;
            mysql_query("delete from tem_table where itemId='$d'");
			header('Location:menuRight.php');
			}
            if(isset($_GET['cancel']))
            {
            $_SESSION['q']=1;
            mysql_query("delete from tem_table");

             header('Location:menuRight.php');
            }

	if(isset($_GET['order']))
	{
		$_SESSION['q']=1;
		$bal=mysql_query("select amount from account where roll='$roll'");
		$b=mysql_fetch_array($bal);

		if($b['amount']<$_SESSION['total'])
		{
			
			echo "<br><br>"."<center>"."Your Current Balance only  :".$b['amount']."<br>";
			echo "<a href='menuRight.php'>Back to Reduce content </a>";
		}
		else
		{
			$ord=1000;
			$or=mysql_query("select * from maintransaction");
			while($q=mysql_fetch_array($or))
			{
			if($ord < $q['orderNo'])
			$ord=$q['orderNo'];
			}
			
			$ord=$ord+1;
			
			mysql_query("insert into maintransaction values('$ord','$roll')");
			$or=mysql_query("select * from tem_table");
	
			while($q=mysql_fetch_array($or))
			{
				$a=$q['itemId'];
				$b=$q['item_name'];
				$c=$q['quan'];
				$d=$q['total'];
				$time=date('H:i:s', strtotime("+5 hours + 30 minutes"));
				$date=date("y-m-d");
				
		
				mysql_query("insert into transaction values('$ord','$roll','$b','$c','$d','$time','$date')");
		 
			}   
			
			$total=$_SESSION['total'];
			$_SESSION['ord']=$ord;
			
			mysql_query("update account set amount=amount-$total where roll='$roll'");
			mysql_query("delete from tem_table");    
			//header('Location:menuRight.php');
			echo "<iframe src='ledger.php' name='r' style='position:absolute;height:100%;width:100%;'></iframe>";

		}
	}
 ?>
 </body>
 </html>