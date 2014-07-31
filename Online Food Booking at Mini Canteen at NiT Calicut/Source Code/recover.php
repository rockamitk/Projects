<?php
		session_start();

		$con=mysql_connect("localhost","root","") or die(mysql_error().'<br>');
		mysql_select_db("onlinefoodbooking");
		
			if(isset($_POST['next']))
			{
			$roll=$_POST['roll'];
			$_SESSION['roll']=$roll;
			
			$st=mysql_query("select * from user where userId='$roll'",$con);
			while($row=mysql_fetch_array($st))
			{
			echo "<center>"."<form action='verify.php' method='POST'>";
			echo $row['securityQues']."<input type='text' size='16px' name='ans'/>";
			echo "<input type='submit' name='submit' value='Submit' style='height: 25px; width: 150px; font-size: 18px;border-style:none;border-radius:5px;' />";
			echo "</form>";
			}
			}

?>


<html>
<head>
<link href="decoMenu.css" rel="stylesheet" type="text/css" />
</head>
<body>
		<div class="center">
			<form action="<?php $_SERVER["PHP_SELF"];?>" method="POST">
				<br><br><center><p>Enter Roll &nbsp  <input type="text" size="16px" name="roll"/></p>

				<br><br><input type="submit" name="next" value="Next" style="height: 25px; width: 150px; font-size: 18px;cursor:pointer; color: rgb(255,255,255);background: rgb(50,51,100);border-style:none;border-radius:5px;" />
				
				</form>

			
		</div>
		
	
</body>
</html>