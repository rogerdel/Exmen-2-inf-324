create table estudiante(
	ci integer primary key,
	nombre varchar(255),
	apellidos varchar(255)
);

create table materia(
	id integer primary key,
	nombre varchar(100),
	sigla varchar(10)
);

create table inscrito(
	ci integer,
	id integer,
	foreign key (id) references materia(id),
	foreign key (ci) references estudiante(ci),
	primary key (ci, id)
);

insert into estudiante(ci,nombre,apellidos)values
(213213,"Juan", "Perez"),
(178963,"Maria", "Urquizo"),
(746282,"Luis", "Montes");

insert into materia(id, nombre, sigla) values
(1, "Base de datos", "inf-161"),
(2, "Analsis matematico I", "mat-115"),
(3, "Matematica discreta I", "mat-114"),
(4, "Estrucutra de datos", "inf-131"),
(5, "Estadistica I", "est-133"),
(6, "Estadistica II", "est-145");

insert into inscrito values
(213213,1),
(213213,5),
(178963,1),
(746282,2),
(746282,6);



create table proceso(
	codFlujo varchar(5),
	codProceso varchar(5),
	codProcesoSiguiente varchar(5),
	tipo varchar(5),
	rol varchar(5),
	pantalla varchar(255)
);



insert into proceso(codFlujo,codProceso,codProcesoSiguiente,tipo,rol,pantalla)values 
("F1", "P1", "P2", "I", "E", "mis.materias.php"),
("F1", "P2", "P3", "P", "E", "selecionarmaterias.php"),
("F1", "P3", "P4", "P", "E", "inscribir.inc.php"),
("F1", "P4", null, "C", "E", "mensaje.inc.php"),





create table seguimiento
(
nroTramite	varchar(10),
codFlujo varchar(3),
codProceso varchar(3),
estudiante varchar(20),
fechaini date,
fechafin date
);

insert into seguimiento values('100','F1','P1',"Maria",'2018-04-01','2018-04-10');
insert into seguimiento values('100','F1','P2',"Juan",'2018-04-03',null);
insert into seguimiento values('210','F2','P1',"Luis",'2019-04-01',null);

