<?php
session_start();
if(isset($_SESSION['msg']) or isset($_SESSION['return'])){
		echo "<script>";
		echo "alert('".$_SESSION['msg']."');";
		echo "</script>";
		unset($_SESSION['msg']);
		unset($_SESSION['uid']);
	}
?>


<!DOCTYPE html>
<html>
<head>
<title>Online Food Booking</title>
<link rel="icon" href="images/logo.jpg" type="image/x-icon" />
<link href="decoMForm.css" rel="stylesheet" type="text/css" />
<script src="slide.js" type="text/javascript"></script>

</head>

<body style="background: url('images/bck1.jpg');">
	
		<div class="headLeft" >Nitc Mini Canteen</div>
		
		<div class="headRight">
			<form action="login.php" method="POST">	
					UserId &nbsp <input type="text" name="uid"> &nbsp 
					Password &nbsp <input type="password" name="pwd">
					<input type="submit" name="l2" value="Sign In" style="cursor:pointer;color:black;background: #F0E68C;border-style:none;border-radius:5px;">
					<a href="recover.php" style="color:black;cursor:pointer; background:#F0E68C;border-style:none;border-radius:7px;">Forget Password </a>
				
			</form>
		</div>
		
<div class="signup"><a href="registration.php" style="position:absolute;height:100%;width:100%;text-align:center;cursor:pointer; color: #2F4F4F;background:#F0E68C;font-size:25px;border-style:none;border-radius:5px;">Register New Customer</a></div>	

<div class="devp" style="position:absolute;left:2%;top:93%;font-size:20px;color:white;">
<label>Developers  </label><a href="developer.php" >Click here </a>		
</div>
<div class="main">	
<a href="javascript:gotoshow()"><img src="images.jpg" name="slide" width=100%; height=463px style="border-style:none;border-radius:50px;""></a>
<script>
slideshowimages("images/f2.jpg","images/f7.jpg","images/f17.jpg","images/f11.jpg","images/f4.jpg","images/f7.jpg","images/f15.jpg")


var slideshowspeed=2000

var whichlink=0
var whichimage=0
function slideit(){
if (!document.images)
return
document.images.slide.src=slideimages[whichimage].src
whichlink=whichimage
if (whichimage<slideimages.length-1)
whichimage++
else
whichimage=0
setTimeout("slideit()",slideshowspeed)
}
slideit()
</script>

</div>
	

</body>
</html>