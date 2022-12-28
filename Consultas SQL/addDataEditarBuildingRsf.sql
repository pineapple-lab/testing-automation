SELECT * FROM testbdspacelogik.datoseditarbuildingrsf;

INSERT INTO testbdspacelogik.datoseditarbuildingrsf
VALUES("10000000",FALSE);

UPDATE testbdspacelogik.datoscrearpaymentcancelationgrande SET estado = '0' WHERE term = 180;

DELETE FROM testbdspacelogik.datoseditarbuildingrsf
WHERE estado=1;

/*26502 1*/