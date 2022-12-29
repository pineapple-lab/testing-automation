/*|--------------------INSPECCIONAR TABLAS----------------------------------------|*/ 				/*COPIA EL NOMBRE DE LA TABLA QUE VAS A USAR*/
/*|*/																			/*|*/ 				/*testbdspacelogik.datoscrearautoprogram*/
/*|*/		SELECT * FROM testbdspacelogik.nombredelatabla;						/*|*/				/*testbdspacelogik.datoscrearcompetitiveset*/
/*|*/																			/*|*/				/*testbdspacelogik.datoscrearlaunch*/
/*|-------------------------------------------------------------------------------|*/				/*testbdspacelogik.datoscrearpaymentcancelationgrande*/
																									/*testbdspacelogik.datoscrearpaymentcancelationmediano*/
																									/*testbdspacelogik.datoscrearpaymentcancelationmuygrande*/
/*|--------------------CONFIGURAR EJECUCION---------------------------------------------------|*/	/*testbdspacelogik.datoscrearpaymentcancelationpequeño*/
/*|*/																						/*|*/	/*testbdspacelogik.datoscrearproposal*/
/*|*/			/*SETEA EN 0 LOS DATOS QUE QUERES EJECUTAR*/								/*|*/	/*testbdspacelogik.datoscrearprospect*/
/*|*/		UPDATE testbdspacelogik.nombredetabla SET estado = '0' WHERE id ='';			/*|*/	/*testbdspacelogik.datoscreartweak*/
/*|*/																						/*|*/	/*testbdspacelogik.datoseditarbuildingcontacts*/
/*|*/		/*SETEA EN 1 LOS DATOS QUE NO QUERES EJECUTAR*/									/*|*/	/*testbdspacelogik.datoseditarbuildingrsf*/			
/*|*/		UPDATE testbdspacelogik.nombredetabla SET estado = '1' WHERE id !='';			/*|*/	/*testbdspacelogik.datoseditarexpensespassedthrough*/
/*|*/																						/*|*/	/*testbdspacelogik.datoseditargeneralinfoprospect*/
/*|*/			/*SETEAR CANTIDAD DE EJECUCIONES*/											/*|*/	/*testbdspacelogik.datoseditarlistinglocationinformation*/		
/*|*/		UPDATE testbdspacelogik.nombredetabla SET ejecutar = '' WHERE id = '';			/*|*/	/*testbdspacelogik.datoseditarmanualmentebroker*/
/*|-------------------------------------------------------------------------------------------|*/	/*testbdspacelogik.datoseditarmydealleasetypelocation*/
																									/*testbdspacelogik.datoseditarmydealofficesize*/
																									/*testbdspacelogik.datoseditarroomoptions*/
/*|--------------------AGREGAR CASOS DE PRUEBA------------------------------------|*/				/*testbdspacelogik.datoseditarsinglesuite*/
/*|*/				 															/*|*/				
/*|*/					/*PARA CASOS DE 2 CAMPOS*/								/*|*/				
/*|*/		INSERT INTO testbdspacelogik.nombredetabla 							/*|*/				
/*|*/			VALUES("",FALSE);												/*|*/	
/*|*/																			/*|*/	
/*|*/					/*PARA CASOS DE 3 CAMPOS*/								/*|*/	
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
	

        