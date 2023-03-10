SELECT * FROM testbdspacelogik.datoscrearproposal;
/*---------------------------------------------------------------------------------------------------------------------*/
INSERT INTO testbdspacelogik.datosproposal
VALUES("234216","9","1434",FALSE);/*PARA AGREGAR FILAS DE DATOS A UNA TABLA*/
/*---------------------------------------------------------------------------------------------------------------------*/
ALTER TABLE testbdspacelogik.datosproposal
ADD fecha_deprueba TIME;/*PARA AGREGAR COLUMNAS*/
/*---------------------------------------------------------------------------------------------------------------------*/
USE testbdspacelogik;
SELECT * FROM testbdspacelogik.datosproposal WHERE estado = 0 ORDER BY RAND() LIMIT 1;/*PARA SELECCIONAR DATOS ALEATORIOS DE UNA TABLA*/
/*---------------------------------------------------------------------------------------------------------------------*/
UPDATE testbdspacelogik.datoscrearprospect SET email = 'pruebautomatizada1@gmail.com';
/*WHERE building=999014;*/ /*PARA SETEAR UNA CELDA O MUCHAS COLUMNAS O FILAS AL MISMO TIEMPO*/
/*---------------------------------------------------------------------------------------------------------------------*/
ALTER TABLE datoscasosfallidoseditarmydealofficesiize RENAME datoscasosfallidoseditarmydealofficesize; /*PARA CAMBIAR NOMBRE DE TABLA*/
/*---------------------------------------------------------------------------------------------------------------------*/
ALTER TABLE testbdspacelogik.datoscasosfallidoscrearlaunch
CHANGE legalFormationLauncha legalFormationLaunch TEXT;/*PARA CAMBIAR EL NOMBRE DE UNA COLUMNA*/
/*---------------------------------------------------------------------------------------------------------------------*/
INSERT datosEditarManualmenteBroker(state, city, zipCode) SELECT state, city, zipCode FROM datoscrearprospect; /*PARA COPIAR COLUMNAS DE UNA TABLA A OTRA*/

ALTER TABLE testbdpeppermint.datoscreararticle ADD COLUMN id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL FIRST; /*PARA AGREGAR ID*/


