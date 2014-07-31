<html>
<body>
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
			$id=$_GET['id'];
			$name=$_GET['name'];
			$price=$_GET['price'];
			mysql_query("insert into item values('$id','$name','$price')");
			header('Location:add_item.php');
		}
  
  
		if(isset($_GET['remove']))
          {
            $d=$_GET['del_item'];
          
            mysql_query("delete from item where itemId='$d'");

           header('Location:delete_item.php');
          }
		  
		  if(isset($_GET['remove_customer']))
          {
            $d=$_GET['del_cus'];
			
			if( mysql_query("delete from account where roll='$d' and amount='000'"))
				{
					mysql_query("delete from user where userId='$d'");
					mysql_query("delete from customer where roll='$d'");
					header('Location:customer.php');
				}
			
          }
  ?>
  </body>
  </html>