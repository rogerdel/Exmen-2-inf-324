<?php
include "cabecera.php";
?>

<h1>Materia que estoy inscrito</h1>
<table border="1px">
	<tr>
		<td>Materia</td>
		<td>Sigla</td>
	</tr>
<?php 
include "conexion.inc.php";
session_start();
$ci = $_SESSION["ci"];

$sqlf = "Select nombre, sigla From materia m, inscrito i ";
$sqlf.= "Where ci = ".$ci." ";
$sqlf.= "and m.id = i.id";
$resultadof = mysqli_query($conn, $sqlf);
while ($filaf = mysqli_fetch_row($resultadof))
{
	echo "<tr>";
	echo "<td>".$filaf[0]."</td>";
	echo "<td>".$filaf[1]."</td>";
	echo "<tr>";
}

?>

<?php
include "footer.php";
?>