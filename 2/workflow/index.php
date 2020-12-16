<?php
include "cabecera.php";
?>
<p><h1>Ingrese sus datos</h1></p>
<form action="flujo.php">
<div>
<font style="color:blue; font-size: 18px">Carnet de identidad</font>
<br>
<input type="text" value="" name="ci"/><br>
<font style="color:blue; font-size: 18px">Nombre</font>
<br>
<input type="text" value="" name="nombre"/><br>
<font style="color:blue; font-size: 18px">Apellidos</font>
<br>
<input type="text" value="" name="apellido"/><br>
<br>
<input type="submit" name="materias" value="Siguiente">
<input type="hidden" name="cp" value="P1">
<input type="hidden" name="cf" value="F1">
</div>

</form>
<?php
include "footer.php";
?>