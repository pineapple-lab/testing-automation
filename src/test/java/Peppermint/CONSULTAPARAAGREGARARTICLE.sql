SELECT * FROM testbdpeppermint.datoscreararticle;

INSERT INTO testbdpeppermint.datoscreararticle
VALUES("6","C:\\Users\\PineappleHP3\\Desktop\\dev\\WorkSpaces\\testingAutomation\\src\\test\\java\\Peppermint\\INSUMOSMULTIMEDIA\\IMAGENPARAPRUEBASARTICLE5.jpg","C:\\Users\\PineappleHP3\\Desktop\\dev\\WorkSpaces\\testingAutomation\\src\\test\\java\\Peppermint\\INSUMOSMULTIMEDIA\\VIDEOPARAPRUEBAS.mp4","¡la mejor receta de arrozmoro!","despues de leer este articulo vas a saber hacer el mejor arroz moro","2","2","5","2","1","2","A continuacion una receta increible para hacer arroz moro","Ingredientes
300 gramos de frijoles negros
250 gramos de arroz
1 cebolla
1 pimiento rojo
1 pimiento verde
2 ajo
1 poco de apio
1 tomate
Sal
Una hoja de laurel
Procedimiento:
1.- Comenzaremos cociendo por una parte los frijoles. La noche anterior los debemos de poner en remojo y al día siguiente los ponemos desde agua fría con unos ajos, apio, un tomate y una hoja de laurel. Los cocemos en la olla express durante 20 minutos. El tiempo lo contamos desde que empieza a salir vapor.
Una vez cocidos retiramos y reservamos. El caldo lo guardamos para cocer el arroz posteriormente.
2.- Hacemos un sofrito con una cebolla, un ajo y un pimiento rojo. Todo lo cocinamos a fuego lento.
3.- Agregamos el arroz y rehogamos unos minutos.
4.- Cubrimos con el caldo de cocer las alubias. Esto le aportará un sabor especial. Ponemos un poco de sal.
5.- Una vez cocido el arroz, agregamos los frijoles y lo dejamos cocinar unos minutos antes de servir.",FALSE,1);

UPDATE testbdpeppermint.datoscreararticle SET estado = false, executionDetails = 10, topicArticle="1" where id= "6";
UPDATE testbdpeppermint.datoscreararticle SET videoPath ="C:\\Users\\PineappleHP3\\Desktop\\dev\\WorkSpaces\\testingAutomation\\src\\test\\java\\Peppermint\\INSUMOSMULTIMEDIA\\VIDEOPARAPRUEBASARTICLE2.mp4"   where id= "6";
UPDATE testbdpeppermint.datoscreararticle SET estado = true; 
DELETE FROM testbdpeppermint.datoscreararticle WHERE id = 5;
UPDATE testbdpeppermint.datoscreararticle SET titleArticle = "La mejor receta de arroz moro" where id= "6"; 