<?php
session_start();
$msg=$_SESSION['msg'];

$_SESSION['n_blank']="";
$_SESSION['r_blank']="";
$_SESSION['c_blank']="";
$_SESSION['e_blank']="";
$_SESSION['n_valid']="";
$_SESSION['c_valid']="";
$_SESSION['e_valid']="";
$flagg=0;
 if(isset($_POST['submit'])) 
 {
		$roll=$_POST['roll'];
		$name=$_POST['name'];
		$contact=$_POST['contact'];
		$email=$_POST['email'];
		$pwd=$_POST['pwd'];
		$sq=$_POST['sq'];
		$ans=$_POST['ans'];
		$hnm=$_POST['hnm'];
		
		$amount=0;
		 if (empty($_POST["name"]))
         {
		    $_SESSION['n_blank'] = "Name is required";
			$flagg=1;
		 }
         else
          {
              if (!preg_match("/^[a-zA-Z ]*$/",$name))
               {
                  $_SESSION['n_valid'] = "Only letters and white space allowed";
                  $flagg=1;				  
               }
          }
		  
		 if (empty($_POST["roll"]))
         {
		    $_SESSION['r_blank'] = "Roll is required";
			$flagg=1;
		 }
		 
		 if (empty($_POST["email"]))
         {
		    $_SESSION['e_blank'] = "Email is required";
			$flagg=1;
		 }
		 else
		  {
		     if (!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/",$email))
             {
               $_SESSION['e_valid'] = "Invalid email format";
                $flagg=1;			   
             }
		  }
		  
		 if (empty($_POST["contact"]))
         {
		    $_SESSION['c_blank'] = "contact is required";
			$flagg=1;
		 }
		 else
		  {
		     if (!preg_match("/^[0-9 ]*$/",$contact))
             {
               $_SESSION['c_valid'] = "Invalid contact format";
                $flagg=1;			   
             }
		  }
		  if($flagg==1)
          {
	         header('Location:registration.php');
	      }
   
 }
   
	$var1=mysql_connect("localhost","root","");
	if(!$var1)
	die(mysql_error().'<br>');
	
		mysql_select_db("onlinefoodbooking");

		$sql="select * from customer where roll='$roll'";
		$flag=mysql_query("$sql",$var1);
		if(mysql_fetch_array($flag)!=null)
		{
		$_SESSION['msg']="Already Registerd ";
		header('Location:index.php'); 
		}
		else{
			$ins="insert into customer values('$roll','$name','$contact','$email','$hnm')";
			if(mysql_query("$ins",$var1))
			{
				$ins="insert into user values ('$roll','$pwd','$sq','$ans')";
				$sq=mysql_query("$ins",$var1);
				$ins="insert into account values('$roll','$amount')";
				mysql_query("$ins",$var1);
				$_SESSION['msg']="Your account created,User Id:".$roll;
				header('Location:index.php'); 

			}
			}
	
?>