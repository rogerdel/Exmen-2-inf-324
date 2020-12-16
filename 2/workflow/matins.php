<?php
session_start();
$cp = $_GET["cp"];
$cf = $_GET["cf"];
$materia = $_GET["materia"];
$_SESSION["materia"] = $materia;
header("Location: flujo.php?cf=$cf&cp=$cp");
?>
