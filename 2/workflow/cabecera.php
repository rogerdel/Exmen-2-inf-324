<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<?php  
$colors = array("#3ce845", "#0084c2","#fc7d05", "#5108c7", "#b02802", "#00ad06", "#b3051f", "#61797d", "#79d90b", "#ff0048", "#e84b3c");
$cl = rand(0, sizeof($colors)-1);

echo "<body style='background-color:".$colors[$cl]."'>";
?>


