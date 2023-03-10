SELECT * FROM testbdpeppermint.datoscrearworkshopcompleto;
INSERT INTO testbdpeppermint.datoscrearworkshopcompleto
VALUES("C:\\Users\\PineappleHP3\\Desktop\\dev\\WorkSpaces\\testingAutomation\\src\\test\\java\\Peppermint\\IMAGENPARAPRUEBAS.png","C:\\Users\\PineappleHP3\\Desktop\\dev\\WorkSpaces\\testingAutomation\\src\\test\\java\\Peppermint\\VIDEOPARAPRUEBAS.MP4","prueba Automatizada7","prueba Automatizada","2","2","2","2","2","prueba Automatizada","prueba Automatizada","prueba Automatizada","2","2","2","prueba Automatizada","prueba Automatizada","2","prueba Automatizada","2","prueba Automatizada","www.google.com","prueba Automatizada","50","prueba Automatizada","https://company.zoom.us/j/xxxxx?pwd=zzzzz","prueba Automatizada","prueba Automatizada","prueba Automatizada","prueba Automatizada","2","2","10","10","10","10",FALSE,1);


/*configurar workshop existente*/
UPDATE testbdpeppermint.datoscrearworkshopcompleto SET pathImage = "C:\\Users\\PineappleHP3\\Desktop\\dev\\WorkSpaces\\testingAutomation\\src\\test\\java\\Peppermint\\INSUMOSMULTIMEDIA\\IMAGENPARAPRUEBASWORKSHOP1.jpg", 
pathVideo = "C:\\Users\\PineappleHP3\\Desktop\\dev\\WorkSpaces\\testingAutomation\\src\\test\\java\\Peppermint\\INSUMOSMULTIMEDIA\\VIDEOPARAPRUEBAS.mp4",
titleWorkshop ="Curso bricolage", descriptionWorkshop = "Convertite en poco tiempo en un experto armador de muebles",
targetAudienceWorkshop = "Carpinteros principiantes", learningObjectivesWorkshop = "al final de este curso nunca mas volveras a tener problemas para armar tus muebles", whatDoYouNeed = "Solo necesitas ganas de aprender, en este curso te enseñamos todo desde 0",
questionWorkshop = "Tengo que tener experiencia armando muebles?",answerWorkshop= "No, no necesitas experiencia", reviewWorkshop = "un gran curso en el que podras dar salida practica a lo aprendido en poco tiempo", 
descriptionProjectWorkshop = "en esta primer tarea aprenderemos a armar un mueble simple", titleZoomWorkshop = "dudas sobre el armado del mueble", descriptionZoomWorkshop = "obtene tips y consejos en este encuentro por zoom",
activitiesTitleWorkshop = "Cajoneras", activitieDescriptionWorkshop = "en esta primer actividad aprenderemos a colocar las cajoneras de forma totalmente alineada facilmente", syncUpTitleWorkshop = "repaso de la primer actividad", syncUpDescriptionWorkshop = "en este syncup repasaremos todos los conceptos dados en la actividad anterior"
WHERE titleWorkshop = "prueba Automatizada7";

UPDATE testbdpeppermint.datoscrearworkshopcompleto SET ejecuciones = 1;
