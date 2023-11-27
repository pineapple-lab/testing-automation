/*|--------------------INSPECCIONAR TABLAS----------------------------------------|*/ 				/*COPIA EL NOMBRE DE LA TABLA QUE VAS A USAR*/
/*|*/																			/*|*/ 				/*testbdpeppermint.datoscrearworkshopcompleto*/
/*|*/		SELECT * FROM testbdpeppermint.datoscreartag;						/*|*/				/*testbdpeppermint.datoscrearclub*/
/*|*/																			/*|*/				/*testbdpeppermint.datoscreararticle*/
/*|-------------------------------------------------------------------------------|*/				/*testbdpeppermint.datoscrearlesson*/
																									/*testbdpeppermint.datoscrearsegment*/
																									/*testbdpeppermint.datoscreartag*/
/*|--------------------CONFIGURAR EJECUCION---------------------------------------------------|*/	/*testbdpeppermint.datoscreartaxonomy*/
/*|*/																						/*|*/	/*testbdpeppermint.datoscreartechnique*/
/*|*/			/*SETEA EN 0 LOS DATOS QUE QUERES execute*/								/*|*/	/*testbdpeppermint.datoslogin*/
/*|*/		UPDATE testbdpeppermint.nombredetabla SET estado = '0' WHERE id ='';			/*|*/	
/*|*/																						/*|*/	
/*|*/		/*SETEA EN 1 LOS DATOS QUE NO QUERES execute*/									/*|*/
/*|*/		UPDATE testbdpeppermint.nombredetabla SET estado = '1' WHERE id !='';			/*|*/	
/*|*/																						/*|*/	
/*|*/			/*SETEAR CANTIDAD DE EJECUCIONES*/											/*|*/		
/*|*/		UPDATE testbdpeppermint.nombredetabla SET execute = '' WHERE id = '';			/*|*/
/*|-------------------------------------------------------------------------------------------|*/

/*|--------------------AGREGAR CASOS DE PRUEBA------------------------------------|*/				
/*|*/				 															/*|*/				
/*|*/					/*PARA CASOS DE 1 CAMPO*/								/*|*/				
/*|*/		INSERT INTO testbdpeppermint.nombredetabla 							/*|*/				
/*|*/			VALUES("",FALSE,1);												/*|*/	
/*|*/																			/*|*/	
/*|*/					/*PARA CASOS DE 2 CAMPOS*/								/*|*/	
/*|*/		 	 INSERT INTO testbdpeppermint.datoscreartag						/*|*/		
/*|*/			VALUES("","",FALSE,1);											/*|*/
/*|*/																			/*|*/
/*|*/					/*PARA CASOS DE 3 CAMPOS*/								/*|*/	
/*|*/		INSERT INTO testbdpeppermint.nombredetabla							/*|*/
/*|*/			VALUES("","","",FALSE,1);	  									/*|*/
/*|*/																			/*|*/
/*|*/				    /*PARA CASOS DE 4 CAMPOS*/								/*|*/
/*|*/		INSERT INTO testbdpeppermint.datoscreartaxonomy						/*|*/
/*|*/			VALUES("","","","",FALSE,1);									/*|*/
/*|*/																			/*|*/
/*|*/					/*PARA CASOS DE 10 CAMPOS*/								/*|*/
/*|*/		INSERT INTO testbdpeppermint.nombredetabla							/*|*/
/*|*/			VALUES("","","","","","","","","","",FALSE,1);					/*|*/
/*|*/																			/*|*/
/*|*/					/*PARA CASOS DE 11 CAMPOS*/								/*|*/
/*|*/		INSERT INTO testbdpeppermint.nombredetabla							/*|*/
/*|*/			VALUES("","","","","","","","","","","",FALSE,1);				/*|*/
/*|*/              																/*|*/
/*|*/					/*PARA CASOS DE 13 CAMPOS*/								/*|*/
/*|*/		INSERT INTO testbdpeppermint.nombredetabla 							/*|*/
/*|*/			VALUES("","","","","","","","","","","","","",FALSE,1);	 		/*|*/  
/*|*/																			/*|*/
/*|*/					/*PARA CASOS DE 14 CAMPOS*/								/*|*/
/*|*/		INSERT INTO testbdpeppermint.nombredetabla							/*|*/
/*|*/			VALUES("","","","","","","","","","","","","","",FALSE,1);		/*|*/
/*|-------------------------------------------------------------------------------|*/