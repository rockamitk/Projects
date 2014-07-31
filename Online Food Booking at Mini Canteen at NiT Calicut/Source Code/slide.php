<!DOCTYPE html>
<html> 
<head>
 <script language="JavaScript1.1">

    var slideimages=new Array() 
	var slidelinks=new Array()
	function slideshowimages()
	{ 
	for (i=0;i<slideshowimages.arguments.length;i++)
		{ 
		slideimages[i]=new Image() 
		slideimages[i].src=slideshowimages.arguments[i] 
		}
	}

    function slideshowlinks()
	{ 
		for (i=0;i<slideshowlinks.arguments.length;i++)
		slidelinks[i]=slideshowlinks.arguments[i] 
	}

    function gotoshow()
	{ 
	if (!window.winslide||winslide.closed)
		winslide=window.open(slidelinks[whichlink])
	else 
		winslide.location=slidelinks[whichlink] winslide.focus()
	} 

slideshowimages("images/f1.jpg","images/f10.jpg","images/f3.jpg","images/f4.jpg","images/f5.jpg","images/f6.jpg","images/f7.jpg","images/f8.jpg","images/f9.jpg")

var slideshowspeed=10
var whichlink=0 
var whichimage=0
 function slideit()
 {
	if (!document.images)
	return document.images.slide.src=slideimages[whichimage].src whichlink=whichimage
	if (whichimage<slideimages.length-1)
	whichimage++ 
	else whichimage=0 
	setTimeout("slideit()",slideshowspeed)
} 
	slideit()
	</script>

	<title> movie online project </title>
<style>
	#u{ background-color:pink; border-radius:25px; }
	#v{ background-color:green; border-radius:25px; } 
	#w{ background-color:skyblue; border-radius:25px; }
</style>
 </head>
<body bgcolor="#993300">
 <table border="4"> 
 <tr>
 <td bgcolor="#6600CC" width="1600"> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<img src="images/bck9.jpg">
			</td>
			</tr> 
</table> 


<table border="1"> <tr>
 <td width="275" height="120">
<div id="w"> <br> <p><B><h1><center><a href="advertisement.html">Advertise</a></center></h1></B></p> <br> </td> 
 <td width="800" height="360">

<div id="slideShowImages" class="scroll" style="width:700px;"> 
<a href="javascript:gotoshow()"><img src="images/f1.jpg" name="slide" width="800" height="360"></a>
</div> 

 </td> 
 </tr>
 </table>

 <table> <tr>

 <video width="300" height="240" controls> 
 <source src="C:\wamp\www\php project\videos\5.mp4" type="video/mp4"> </video>

 </tr> 
 </table> 

 </body>
 </html>

