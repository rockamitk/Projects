<?php
//Template Assignment
$fullapiurl="http://smsc.biz/httpapi/send?username=bittusingh0348@gmail.com&password=bittusingh&sender_id=SMSIND&route=T&phonenumber=8714271433&message=Test%20sms%20from%20ANYVARIABLE1.%20Thanks%20for%20choosing%20our%20service%20-%20smsc.biz";
// url_encode() Encoded message
//Call API
$ch = curl_init($fullapiurl);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
$result = curl_exec($ch); 
//echo $result ; // For Report or Code Check
curl_close($ch);
echo "<br><p>SMS Sent....</p>";
?>
