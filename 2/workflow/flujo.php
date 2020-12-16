<?php
include "cabecera.php";
?>

<?php
include "conexion.inc.php";
session_start();
if(isset($_GET["ci"])){
	$ci = $_GET["ci"];
	$nombre = $_GET["nombre"];
	$apellido = $_GET["apellido"];
	$_SESSION["ci"]=$ci;
	$_SESSION["nombre"]=$nombre;
	$_SESSION["apellido"]=$apellido;

	$sqla ="select * from seguimiento ";
	$sqla.="where estudiante='".$nombre."' ";
	$sqla.="and fechafin is null";
	$res = mysqli_query($conn, $sqla);
	
	$op =  mysqli_fetch_row($res);
	if($op!= null){
		if(sizeof($op)> 0){
		header("Location: bentrada.php");
	}		
	}

}


$codflujo = $_GET["cf"];
$codproceso = $_GET["cp"];

$sql ="select * from proceso ";
$sql.="where codFlujo='$codflujo' ";
$sql.="and codProceso='$codproceso' ";
$resultado = mysqli_query($conn, $sql);
$fila = mysqli_fetch_row($resultado);
?>

<?php
include $fila[5];
?>
<form action = "controlador.php" method="GET">


<br>
<input type="hidden" name="pantalla" value="<?php echo $fila[5];?>"/>
<input type="hidden" name="codflujo" value="<?php echo $fila[0];?>"/>
<input type="hidden" name="codproceso" value="<?php echo $fila[1];?>"/>
<input type="submit" name="Siguiente" value="Siguiente"/>
<input type="submit" name="Anterior" value="Anterior"/>
</form>
<?php
include "footer.php";
?>