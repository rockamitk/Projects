<?php
session_start();
unset($_SESSION['uid']);
//if required set successful logout message
header('Location:index.php');
?>