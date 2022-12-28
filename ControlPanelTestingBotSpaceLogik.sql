/*|--------------------INSPECCIONAR TABLAS----------------------------------------|*/ 	/*COPIA EL NOMBRE DE LA TABLA QUE VAS A USAR*/
/*|*/																			/*|*/ 	/*testbdspacelogik.datoscrearautoprogram*/
/*|*/		SELECT * FROM testbdspacelogik.datoscrearautoprogram;						/*|*/	/*testbdspacelogik.datoscrearcompetitiveset*/
/*|*/																			/*|*/	/*testbdspacelogik.datoscrearlaunch*/
/*|-------------------------------------------------------------------------------|*/	/*testbdspacelogik.datoscrearpaymentcancelationgrande*/
																						/*testbdspacelogik.datoscrearpaymentcancelationmediano*/
																						/*testbdspacelogik.datoscrearpaymentcancelationmuygrande*/
/*|--------------------HABILITAR/DESHABILITAR DATOS-------------------------------|*/	/*testbdspacelogik.datoscrearpaymentcancelationpequeño*/
/*|*/																			/*|*/	/*testbdspacelogik.datoscrearproposal*/
/*|*/		UPDATE NombreDeLaTabla SET estado = '1';							/*|*/	/*testbdspacelogik.datoscrearprospect*/
/*|*/		UPDATE NombreDeLaTabla SET estado = '0' WHERE id ='';				/*|*/	/*testbdspacelogik.datoscreartweak*/
/*|-------------------------------------------------------------------------------|*/	/*testbdspacelogik.datoseditarbuildingcontacts*/
																						/*testbdspacelogik.datoseditarbuildingrsf*/
																						/*testbdspacelogik.datoseditarexpensespassedthrough*/
/*|--------------------CONFIGURAR CASOS DE PRUEBA---------------------------------|*/	/*testbdspacelogik.datoseditargeneralinfoprospect*/
/*|*/				 															/*|*/	/*testbdspacelogik.datoseditarlistinglocationinformation*/
/*|*/					/*PARA CASOS DE 2 CAMPOS*/								/*|*/	/*testbdspacelogik.datoseditarmanualmentebroker*/
/*|*/		INSERT INTO testbdspacelogik.nombredetabla 							/*|*/	/*testbdspacelogik.datoseditarmydealleasetypelocation*/
/*|*/			VALUES("",FALSE);												/*|*/	/*testbdspacelogik.datoseditarmydealofficesize*/
/*|*/																			/*|*/	/*testbdspacelogik.datoseditarroomoptions*/
/*|*/					/*PARA CASOS DE 3 CAMPOS*/								/*|*/	/*testbdspacelogik.datoseditarsinglesuite*/
/*|*/		 INSERT INTO testbdspacelogik.nombredetabla 						/*|*/		
/*|*/			VALUES("","",FALSE);	 										/*|*/
/*|*/																			/*|*/
/*|*/					/*PARA CASOS DE 4 CAMPOS*/								/*|*/	
/*|*/		INSERT INTO testbdspacelogik.nombredetabla							/*|*/
/*|*/				VALUES("","","",FALSE);	  									/*|*/
/*|*/																			/*|*/
/*|*/				    /*PARA CASOS DE 5 CAMPOS*/								/*|*/
/*|*/		INSERT INTO testbdspacelogik.nombredetabla							/*|*/
/*|*/				VALUES("","","","",FALSE);									/*|*/
/*|*/																			/*|*/
/*|*/					/*PARA CASOS DE 11 CAMPOS*/								/*|*/
/*|*/		INSERT INTO testbdspacelogik.nombredetabla 							/*|*/
/*|*/				VALUES("","","","","","","","","","",FALSE);				/*|*/
/*|*/																			/*|*/
/*|*/					/*PARA CASOS DE 12 CAMPOS*/								/*|*/
/*|*/		INSERT INTO testbdspacelogik.nombredetabla							/*|*/
/*|*/				VALUES("","","","","","","","","","","",FALSE);				/*|*/
/*|*/              																/*|*/
/*|*/					/*PARA CASOS DE 14 CAMPOS*/								/*|*/
/*|*/		INSERT INTO testbdspacelogik.nombredetabla 							/*|*/
/*|*/				VALUES("","","","","","","","","","","","","",FALSE);	 	/*|*/  
/*|*/																			/*|*/
/*|*/					/*PARA CASOS DE 15 CAMPOS*/								/*|*/
/*|*/		INSERT INTO testbdspacelogik.nombredetabla 							/*|*/
/*|*/				VALUES("","","","","","","","","","","","","","",FALSE);	/*|*/
/*|-------------------------------------------------------------------------------|*/
	

        