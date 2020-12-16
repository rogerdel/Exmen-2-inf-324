<?php
include "cabecera.php";
?>
<h1>Selecione a la materia que se inscribira</h1>
<?php
session_start();
include "conexion.inc.php";
$sqlf ="select * from materia ";
$resultadof = mysqli_query($conn, $sqlf);
?>	
<form action="matins.php">
<?php
while ($filaf = mysqli_fetch_row($resultadof))
{
	echo "<input type='radio' id=".$filaf[0]." name='materia' value=".$filaf[0].">".$filaf[0]." ";
	echo $filaf[1]."<br>";
}
?>	

<input type="hidden" name="cf" value="F1">
<input type="hidden" name="cp" value="P2">

<input type = "submit" name  ="slecionar" value = "Selecionar">

</form>
<?php
include "footer.php";
?>