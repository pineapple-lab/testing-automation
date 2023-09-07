package Peppermint;

import insumosPeppermint.robotBasePeppermint;
import insumosPeppermint.variablesPeppermint;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static insumosPeppermint.variablesPeppermint.*;

public class configuracionAvanzadaCrearWorkshops extends interfaceActions{
    robotBasePeppermint metodosPeppermint = new robotBasePeppermint();
    public configuracionAvanzadaCrearWorkshops(String ejecucionesAvanzadas , String seleccionAvanzada){
        this.ejecuciones = ejecucionesAvanzadas;
        this.seleccion = seleccionAvanzada;
    }
    public void start(Stage stageConfigAvanzadaCrearWorkshop){
        stageConfigAvanzadaCrearWorkshop.setTitle("Configuracion avanzada crear workshops");
        GridPane gridPaneCrearWorkshopAvanzado = new GridPane();
        gridPaneCrearWorkshopAvanzado.setHgap(3);
        gridPaneCrearWorkshopAvanzado.setVgap(10);
        gridPaneCrearWorkshopAvanzado.add(checkBoxEditarTituloWorkshops,1,1);
        gridPaneCrearWorkshopAvanzado.add(textFieldEditarTituloWorkshops,3,1);
        gridPaneCrearWorkshopAvanzado.add(labelModalidadGroupWithInstructor,1,2);
        gridPaneCrearWorkshopAvanzado.add(checkBoxEditarEstudiantesMaximosModalidadGroupWithInstructor,1,3);
        gridPaneCrearWorkshopAvanzado.add(textFieldMaxStudentsGroupWithInstructor,3,3);
        gridPaneCrearWorkshopAvanzado.add(checkBoxEditarEstudiantesOptimosModalidadGroupWithInstructor,1,4);
        gridPaneCrearWorkshopAvanzado.add(textFieldOptimalBuddyGroupGroupWithInstructor,3,4);
        gridPaneCrearWorkshopAvanzado.add(labelModalidadGrupoSinInstructor,1,6);
        gridPaneCrearWorkshopAvanzado.add(checkBoxEditarEstudiantesMaximosModalidadGroupSinInstructor,1,7);
        gridPaneCrearWorkshopAvanzado.add(textFieldMaxStudentsGroup,3,7);
        gridPaneCrearWorkshopAvanzado.add(checkBoxEditarEstudiantesOptimosModalidadGroupSinInstructor,1,8);
        gridPaneCrearWorkshopAvanzado.add(textFieldOptimalBuddyGroup,3,8);
        gridPaneCrearWorkshopAvanzado.add(ejecutarWorkshopAvanzado,9,10);
        ejecutarWorkshopAvanzado.setStyle("-fx-text-fill: #FFFFFF; -fx-background-color: #008A66;");
        tabConfiguracionAvanzadaWorkshops.setContent(gridPaneCrearWorkshopAvanzado);
        tabPane.getTabs().addAll(tabConfiguracionAvanzadaWorkshops);
        rootConfigAvanzada.getChildren().add(tabPane);
        Scene configAvanzadaScene = new Scene(rootConfigAvanzada,450,350);
        stageConfigAvanzadaCrearWorkshop.setScene(configAvanzadaScene);
        textFieldEditarTituloWorkshops.setVisible(false);
        textFieldMaxStudentsGroupWithInstructor.setVisible(false);
        textFieldOptimalBuddyGroupGroupWithInstructor.setVisible(false);
        textFieldMaxStudentsGroup.setVisible(false);
        textFieldOptimalBuddyGroup.setVisible(false);
        checkBoxEditarTituloWorkshops.setOnAction(actionEvent -> {
            if (checkBoxEditarTituloWorkshops.isSelected()){
                textFieldEditarTituloWorkshops.setVisible(true);
            }else {
                textFieldEditarTituloWorkshops.setVisible(false);
            }
        });
        checkBoxEditarEstudiantesMaximosModalidadGroupWithInstructor.setOnAction(actionEvent -> {
            if (checkBoxEditarEstudiantesMaximosModalidadGroupWithInstructor.isSelected()){
                textFieldMaxStudentsGroupWithInstructor.setVisible(true);
            }else {
                textFieldMaxStudentsGroupWithInstructor.setVisible(false);
            }
        });
        checkBoxEditarEstudiantesOptimosModalidadGroupWithInstructor.setOnAction(actionEvent -> {
            if (checkBoxEditarEstudiantesOptimosModalidadGroupWithInstructor.isSelected()){
                textFieldOptimalBuddyGroupGroupWithInstructor.setVisible(true);
            }else {
                textFieldOptimalBuddyGroupGroupWithInstructor.setVisible(false);
            }
        });
        checkBoxEditarEstudiantesMaximosModalidadGroupSinInstructor.setOnAction(actionEvent -> {
            if (checkBoxEditarEstudiantesMaximosModalidadGroupSinInstructor.isSelected()){
                textFieldMaxStudentsGroup.setVisible(true);
            }else {
                textFieldMaxStudentsGroup.setVisible(false);
            }
        });
        checkBoxEditarEstudiantesOptimosModalidadGroupSinInstructor.setOnAction(actionEvent -> {
            if (checkBoxEditarEstudiantesOptimosModalidadGroupSinInstructor.isSelected()){
                textFieldOptimalBuddyGroup.setVisible(true);
            }else {
                textFieldOptimalBuddyGroup.setVisible(false);
            }
        });
        ejecutarWorkshopAvanzado.setOnAction(e->{
            Thread ejecutar=  new Thread (()->{
                if (checkBoxEditarTituloWorkshops.isSelected()){
                    titleWorkshop = textFieldEditarTituloWorkshops.getText();
                    configuracionavanzadaTitleWorkshop = true;
                }
                if (checkBoxEditarEstudiantesMaximosModalidadGroupWithInstructor.isSelected()){
                    maxStudentsGroupWithInstructor = textFieldMaxStudentsGroupWithInstructor.getText();
                    configuracionAvanzadaMaxGroupWithInstructor = true;
                }
                if (checkBoxEditarEstudiantesOptimosModalidadGroupWithInstructor.isSelected()){
                    optimalBuddyGroupGroupWithInstructor = textFieldOptimalBuddyGroupGroupWithInstructor.getText();
                    configuracionAvanzadaOptimalGroupWithInstructor = true;
                }
                if (checkBoxEditarEstudiantesMaximosModalidadGroupSinInstructor.isSelected()){
                    maxStudentsGroup = textFieldMaxStudentsGroup.getText();
                    configuracionAvanzadaMaxStudenGroup = true;
                }
                if (checkBoxEditarEstudiantesOptimosModalidadGroupSinInstructor.isSelected()){
                    optimalBuddyGroup= textFieldOptimalBuddyGroup.getText();
                    configuracionAvanzadaOptimalStudenGroup = true;
                }
                actionCrearWorkshop();
            }, "ejecutar");
            if(ejecutar.isAlive()) {
                ejecutar.stop();
            }else {
                metodosPeppermint.iniciarTest();
                ejecutar.start();
            }
        });
    }
}
