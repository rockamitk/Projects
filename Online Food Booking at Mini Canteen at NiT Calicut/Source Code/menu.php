<?php

session_start();

	if(!isset($_SESSION['uid']))
	{
		$_SESSION['msg']="You should login to access your Account";
		header('location:index.php');
	}
	else
		{
		$uid=$_SESSION['uid'];
		}
	$_SESSION['return']="";
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" href="images/logo.jpg" type="image/x-icon" />
<title>Online Food Booking</title>
<script src="slide.js" type="text/javascript"></script>
<meta name="keywords" content="free website templates, hotel and travel, CSS, XHTML, design layout" />
<meta name="description" content="Hotel and Travel - free website template provided by templatemo.com" />
<link href="decoMenu.css" rel="stylesheet" type="text/css" />

</head>
<body >
<div id="templatemo_container">
	
	
    <div id="templatemo_header">
        <div id="website_title">
            <div id="title">ONLINE FOOD BOOKING </div>
			<div id="salgon" style="float:left;font-size:14px;">Welcom <?php echo $uid; ?> </div>
            <div id="salgon">NITC Mini Canteen</div>
        </div>
    </div> <!-- end of header -->
    
	
    <div id="templatemo_banner">
    	<div id="templatemo_menu">
            <ul>
				
                <li><a href="balance.php" class="current" target="_parent">Check Balance</a></li>
                <li><a href="updateCustomer.php">Edit Profile</a></li>
				<li><a href="changePassword.php">Change Password</a></li>
                <li><a href="logout.php" class="last">logout</a></li>
            </ul> 
        </div>

<a href="javascript:gotoshow()"><img src="images.jpg" name="slide" width=940px; height=280px style="border-style:none;border-radius:30px;""></a>
<script>
slideshowimages("images/f2.jpg","images/f3.jpg","images/f12.jpg","images/f13.jpg","images/f6.jpg","images/f24.jpg",
"images/f25.jpg","images/f4.jpg","images/f19.jpg","images/f20.jpg","images/f21.jpg")


var slideshowspeed=2200

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
 </div> <!-- end of banner -->
    
    
	
	<div id="templatemo_content">
    
    	<div id="content_left">
        	<div class="content_left_section">
            <div class="content_title_01">Available Items</div>
            <iframe src="menuLeft.php" style="position:absolute;height:260px;width:98%;">
			</iframe>
			
        </div>    
        </div> <!-- end of content left -->
        
        
		<div id="content_right">
        
        	<div class="content_right_section">
			<div class="content_title_01">Selected Items</div>
        	<iframe src="menuRight.php" name='r' style="position:absolute;height:280px;width:90%;"></iframe>
          
   		  </div>
            
         
        </div> <!-- end of content right -->

    </div>
    
</div>

</html>