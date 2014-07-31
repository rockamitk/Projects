<!DOCTYPE html>
<html>
<head>
<title>Online Food Booking</title>
<link rel="icon" href="images/logo.jpg" type="image/x-icon" />
<script src="slide.js" type="text/javascript"></script>
<style>
	.slideBck
	{
	position : absolute;
	top :45%;
	left :40%;
	width:20%;
	height:20%;
	}
	
	body
	{
	color: #e0e0ba;
	background: url('images/bck10.jpg') no-repeat;
	color: white;
	font-size: 30px;
	font-weight: bold;
	margin-left:10px;
	margin-right:10px;
	font-family:  Script MT Bold;
	}
	


</style>
<link rel="icon" href="images/logo.png" type="image/x-icon" />
<title>Online Food Booking</title>

</head>

<body 	style="background-color:#12110f;">
<div class="slideBck">
<a href="javascript:gotoshow()"><img src="images.jpg" name="slide" width=280px; height=280px style="border-style:none;border-radius:100px;"></a>
<script>
slideshowimages("images/d3.jpg","images/d2.jpg")


var slideshowspeed=1500

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
	
	<div class="slideMov">
	<marquee ><img src="images/d2.jpg" height=220px width=220px style="border-style:none;border-radius:140px;"/>Bittu</marquee>
	<img src="images/d3.jpg" height=220px width=220px style="border-style:none;border-radius:140px;"/>Amit</marquee>

	</div>
	
</body>

</html>