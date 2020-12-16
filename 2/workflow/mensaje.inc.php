<?php
include "cabecera.php";
?>
<?php 
session_start();
include "conexion.inc.php";
$ci =$_SESSION["ci"];
$idmat = $_SESSION["materia"];
$sqlf = "select count(ci) from inscrito where ci=".$ci." and id=".$idmat."";
$res = mysqli_query($conn, $sqlf);
$a =  mysqli_fetch_row($res);
if($a[0] > 0){
	echo "<p style='color:red; font-size: 18px'>Usted ya es encontraba inscrito en la materia</p>";
}
else{
	$sqlf = "insert into inscrito values(".$ci.",".$idmat.")";
	$r = mysqli_query($conn, $sqlf);

	if($r){
	 	echo "Se inscribio satifactoriamente";
	}
	else{
	 	echo "Hubo un error no s elo puedo inscribir intentelo mas tarde";
	}
}
?>

<form action = "index.php">
	<input type="submit" name="Salir" value="Salir">

</form>
<?php
include "footer.php";
?>